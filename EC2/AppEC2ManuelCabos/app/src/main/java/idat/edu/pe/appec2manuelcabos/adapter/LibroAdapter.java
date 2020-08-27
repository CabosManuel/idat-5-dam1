package idat.edu.pe.appec2manuelcabos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import idat.edu.pe.appec2manuelcabos.ListadoDetalleActivity;
import idat.edu.pe.appec2manuelcabos.R;
import idat.edu.pe.appec2manuelcabos.model.Libro;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Libro> lista;

    public LibroAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public LibroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_libro,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroAdapter.ViewHolder holder, int position) {
        final Libro objLibro = lista.get(position);
        holder.tvTituloLibro.setText(objLibro.getTitulo());
        holder.tvDesLibro.setText(objLibro.getDescripcion());
        holder.tvAnioLibro.setText(objLibro.getAnio().toString());
        holder.ivLibro.setImageResource(objLibro.getImagen());
        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLibroDetalle = new Intent(context, ListadoDetalleActivity.class);
                intentLibroDetalle.putExtra("libro",objLibro);
                context.startActivity(intentLibroDetalle);
            }
        });
    }

    public void agregarElementos(ArrayList<Libro> listaLibro){
        lista.clear();
        lista.addAll(listaLibro);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLibro;
        TextView tvTituloLibro,tvDesLibro,tvAnioLibro;
        CardView contenedor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLibro = itemView.findViewById(R.id.ivlibro);
            tvTituloLibro = itemView.findViewById(R.id.tvtitulolibro);
            tvAnioLibro = itemView.findViewById(R.id.tvaniolibro);
            tvDesLibro = itemView.findViewById(R.id.tvdeslibro);
            contenedor = itemView.findViewById(R.id.contenedor);
        }
    }
}
