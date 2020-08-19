package idat.edu.pe.s10appvolleyrecyclerpicasso.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import idat.edu.pe.s10appvolleyrecyclerpicasso.R;
import idat.edu.pe.s10appvolleyrecyclerpicasso.modelo.Flor;

public class FlorAdapter extends RecyclerView.Adapter<FlorAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Flor> lista;

    public FlorAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public FlorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_flor,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlorAdapter.ViewHolder holder, int position) {
        Flor itemFlor = lista.get(position);
        holder.tvEtiqueta.setText(itemFlor.getEtiqueta());
        holder.tvUsuario.setText(itemFlor.getUsuario());
        Picasso.get().load(itemFlor.getUrlImagen()).into(holder.ivImagen);
    }

    public void agregarDatos(ArrayList<Flor> datos){
        lista.clear();
        lista.addAll(datos);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvEtiqueta,tvUsuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivimagen);
            tvEtiqueta = itemView.findViewById(R.id.tvetiqueta);
            tvUsuario = itemView.findViewById(R.id.tvusuario);
        }
    }
}
