package idat.edu.pe.appmanuelcabos.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import idat.edu.pe.appmanuelcabos.R;
import idat.edu.pe.appmanuelcabos.adapter.DatoAdapter;
import idat.edu.pe.appmanuelcabos.model.Dato;

public class PrimeroFragment extends Fragment {

    private RecyclerView rvData;
    private DatoAdapter adapter;
    ArrayList<Dato> list;
    private RequestQueue colaPeticiones;

    public PrimeroFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_primero, container, false);
        rvData = view.findViewById(R.id.rvdata);
        rvData.setLayoutManager(new GridLayoutManager(getActivity(),3));
        adapter = new DatoAdapter(getContext());
        rvData.setAdapter(adapter);
        list = new ArrayList<>();
        colaPeticiones = Volley.newRequestQueue(getActivity());
        getDatosWebService();
        return view;
    }

    private void getDatosWebService() {

        String url = "https://jsonplaceholder.typicode.com/photos";

        JsonArrayRequest peticion = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i =0; i<response.length();i++){
                                JSONObject obj = response.getJSONObject(i);

                                //3,8,12,19,26,89
                                if(obj.getInt("albumId")==3||
                                        obj.getInt("albumId")==8||
                                        obj.getInt("albumId")==12||
                                        obj.getInt("albumId")==19||
                                        obj.getInt("albumId")==26||
                                        obj.getInt("albumId")==89) {

                                    list.add(new Dato(
                                            obj.getInt("albumId"),
                                            obj.getInt("id"),
                                            obj.getString("title"),
                                            obj.getString("thumbnailUrl")
                                    ));
                                }
                            }

                            adapter.agregarDatos(list);

                        }catch (JSONException e){
                            Log.e("ErrorVolley",e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorRequest",error.getMessage());
                Log.e("ErrorRequest2",error.getCause().toString());
                Log.e("ErrorRequest3",error.getLocalizedMessage());
            }
        }
        );

        colaPeticiones.add(peticion);
    }
}
