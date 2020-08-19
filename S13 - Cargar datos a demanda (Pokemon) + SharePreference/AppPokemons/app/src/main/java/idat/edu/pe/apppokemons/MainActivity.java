package idat.edu.pe.apppokemons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

import idat.edu.pe.apppokemons.adapter.PokemonAdapter;
import idat.edu.pe.apppokemons.model.Pokemon;

public class MainActivity extends AppCompatActivity {

    private String urlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    private RecyclerView rvPokemon;
    private PokemonAdapter adapter;
    private Boolean puedeCargar = false;
    private String nextUrl = "";
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPokemon = findViewById(R.id.rvpokemon);
        adapter = new PokemonAdapter(this);
        rvPokemon.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
        rvPokemon.setAdapter(adapter);

        rvPokemon.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0){
                    //cuantos items se ven en el RV
                    int itemsVsibles = rvPokemon.getLayoutManager().getChildCount();
                    int itemTotales = rvPokemon.getLayoutManager().getItemCount();
                    int primerItemVisible = ((GridLayoutManager)rvPokemon.getLayoutManager())
                            .findFirstVisibleItemPosition();
                    if(puedeCargar){
                        if(itemsVsibles+primerItemVisible>=itemTotales){
                            puedeCargar = false;
                            getPokemons(nextUrl);
                        }
                    }
                }
            }
        });

        queue = Volley.newRequestQueue(this);
        getPokemons(urlPokemon);
    }

    private void getPokemons(String urlPokemon) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlPokemon,
                null, // enviar paraemtros cuando es POST
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            nextUrl = response.getString("next");
                            JSONArray jsonArrayPokemon = response.getJSONArray("results");
                            if(jsonArrayPokemon.length()>0){
                                ArrayList<Pokemon> listPokemons = new ArrayList<>();
                                puedeCargar=true;
                                for (int i = 0; i < jsonArrayPokemon.length(); i++) {
                                    JSONObject jsonPokemon = jsonArrayPokemon.getJSONObject(i);
                                    listPokemons.add(new Pokemon(
                                            jsonPokemon.getString("name"),
                                            jsonPokemon.getString("url")
                                            ));
                                }
                                adapter.agregarElementos(listPokemons);
                            }
                        }catch(JSONException ex){
                            puedeCargar = false;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(jsonObjectRequest);
    }
}
