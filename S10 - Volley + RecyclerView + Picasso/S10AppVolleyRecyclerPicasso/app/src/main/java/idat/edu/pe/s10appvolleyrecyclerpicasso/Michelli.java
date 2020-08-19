package idat.edu.pe.appvolleyrecyclerpicasso;
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
import idat.edu.pe.appvolleyrecyclerpicasso.adaptador.FlorAdapter;
import idat.edu.pe.appvolleyrecyclerpicasso.modelo.Flor;
public class MainActivity extends AppCompatActivity {
    private RecyclerView rvdatos;
    private FlorAdapter adaptador;
    //Declarar la cola de peticiones
    private RequestQueue colapeticiones;
    ArrayList<Flor> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvdatos = findViewById(R.id.rvdatos);
        //Le digo como se mostrarán mis datos
        rvdatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adaptador = new FlorAdapter(MainActivity.this);
        rvdatos.setAdapter(adaptador);
        lista = new ArrayList<>();
        //instanciar la cola de peticiones.
        colapeticiones = Volley.newRequestQueue(this);
        ConsumirWebServices();
    }
    private void ConsumirWebServices() {
        String url = "https://pixabay.com/get/55e0d340485aa814f6da8c7dda79367c103bdae255586c48702678d39f45c35db9_1280.jpg";
        //Instanciar el objeto request. (JsonArrayRequest o JsonObjectRequest)
        JsonObjectRequest peticion = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject objjson = jsonArray.getJSONObject(i);
                                lista.add(new Flor(
                                        objjson.getString("tags"),
                                        objjson.getString("user"),
                                        objjson.getString("largeImageURL")
                                ));
                            }
                            adaptador.agregarDatos(lista);
                        }catch (JSONException ex){
                            Log.e("ErrorVolley", ex.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorRequest", error.getMessage());
            }
        }
        );
        //Agregar la peticion a la cola de peticiones.
        colapeticiones.add(peticion);
    }
}



