package idat.edu.pe.s10appvolleyrecyclerpicasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import idat.edu.pe.s10appvolleyrecyclerpicasso.adaptador.FlorAdapter;
import idat.edu.pe.s10appvolleyrecyclerpicasso.modelo.Flor;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDatos;
    private FlorAdapter adapter;
    private RequestQueue colaPeticiones;
    ArrayList<Flor> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDatos = findViewById(R.id.rvdatos);
        rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new FlorAdapter(MainActivity.this);
        rvDatos.setAdapter(adapter);
        lista = new ArrayList<>();

        //instanciar peticiones
        colaPeticiones = Volley.newRequestQueue(this);
        consumirWebService();
    }

    private void consumirWebService() {
        String url = "https://pixabay.com/api/?key=12544769-ce772d6f6df4078b74b23c3cf&q=yellow+flowers&image_type=photo&pretty=true";

        //instanciar obj request (JsonArrayRequest/JsonObjectRequest)
        JsonObjectRequest peticion = new JsonObjectRequest(
            Request.Method.GET, url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("hits");
                        for(int i =0; i<jsonArray.length();i++){
                            JSONObject obj = jsonArray.getJSONObject(i);
                            lista.add(new Flor(
                                obj.getString("tags"),
                                obj.getString("user"),
                                obj.getString("largeImageURL")
                            ));
                        }

                        adapter.agregarDatos(lista);

                    }catch (JSONException e){
                        Log.e("ErrorVolley",e.getMessage());
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("ErrorRequest",error.getMessage());
                }
            }
        );
        //agregar la petición a la cola de peticiones
        colaPeticiones.add(peticion);
    }
}
