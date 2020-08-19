package idat.edu.pe.s09appfragmentmenu.adapter;

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

import idat.edu.pe.s09appfragmentmenu.R;
import idat.edu.pe.s09appfragmentmenu.model.Flor;

public class FlorAdapter extends RecyclerView.Adapter<FlorAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Flor> lista;

    public FlorAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override //crear las vistas
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(null).inflate(R.layout.item_flor,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Flor objFlor = lista.get(position);
        holder.tvetiqueta.setText(objFlor.getEtiquetas());
        Glide.with(context)
                .load(objFlor.getUrlImagen())
                .centerCrop()
                .into(holder.ivImagen);
    }

    public void agregarElementos(ArrayList<Flor> data){
        lista.clear();
        lista.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvetiqueta;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivimagen);
            tvetiqueta = itemView.findViewById(R.id.tvetiqueta);
        }
    }
}
