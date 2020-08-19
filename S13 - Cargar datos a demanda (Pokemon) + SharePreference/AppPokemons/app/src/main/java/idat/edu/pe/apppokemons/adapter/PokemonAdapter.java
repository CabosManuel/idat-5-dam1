package idat.edu.pe.apppokemons.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import idat.edu.pe.apppokemons.R;
import idat.edu.pe.apppokemons.model.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> listPokemon;
    private Context context;

    public PokemonAdapter(Context context) {
        this.context = context;
        listPokemon = new ArrayList<>();
    }

    @NonNull
    @Override
    public PokemonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.ViewHolder holder, int position) {
        final Pokemon objPokemon = listPokemon.get(position);
        holder.tvNomPokemon.setText(objPokemon.getNombre());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ objPokemon.getId()+".png")
                .into(holder.ivPokemon);
    }

    public void agregarElementos(ArrayList<Pokemon> dataPokemon){
        listPokemon.addAll(dataPokemon);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPokemon;
        private TextView tvNomPokemon,tvNro;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNro = itemView.findViewById(R.id.tvnro);
            ivPokemon = itemView.findViewById(R.id.ivpokemon);
            tvNomPokemon = itemView.findViewById(R.id.tvnompokemon);
        }
    }
}
