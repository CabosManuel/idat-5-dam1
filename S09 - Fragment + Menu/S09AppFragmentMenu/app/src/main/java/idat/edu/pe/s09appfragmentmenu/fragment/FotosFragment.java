package idat.edu.pe.s09appfragmentmenu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import idat.edu.pe.s09appfragmentmenu.R;
import idat.edu.pe.s09appfragmentmenu.adapter.FlorAdapter;
import idat.edu.pe.s09appfragmentmenu.model.Flor;

public class FotosFragment extends Fragment {

    private RecyclerView rvDatos;
    private FlorAdapter adapter;
    ArrayList<Flor> list;
    private RequestQueue colaPeticiones;

    public FotosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fotos, container, false);

        rvDatos = view.findViewById(R.id.rvdatos);
        //al no estar en un actitvity sino un fragmente getActivity() es para obtener donde esta...
        rvDatos.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FlorAdapter(getContext());
        rvDatos.setAdapter(adapter);
        list = new ArrayList<>();
        colaPeticiones = Volley.newRequestQueue(getActivity());
        consumirWebService();
        return view;
    }

    private void consumirWebService() {
        String url = "";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject objJsonFlor = jsonArray.getJSONObject(i);
                                list.add(new Flor(
                                        objJsonFlor.getString("tags"),
                                        objJsonFlor.getString("webformatURL")
                                ));
                            }
                            adapter.agregarElementos(list);
                        }catch (JSONException e){

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
    }
}
