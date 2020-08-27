package idat.edu.pe.appmanuelcabos.adapter;

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

import idat.edu.pe.appmanuelcabos.R;
import idat.edu.pe.appmanuelcabos.model.Dato;

public class DatoAdapter extends RecyclerView.Adapter<DatoAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Dato> lista;

    public DatoAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dato,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dato itemDato = lista.get(position);
        holder.tvAlbumId.setText(itemDato.getAlbumId().toString());
        holder.tvId.setText(itemDato.getId().toString());
        holder.tvTitulo.setText(itemDato.getTitulo());
        Picasso.get().load(itemDato.getMiniaturaUrl()).into(holder.ivImagen);
    }

    public void agregarDatos(ArrayList<Dato> datos){
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
        TextView tvAlbumId, tvId,tvTitulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivimagen);
            tvAlbumId = itemView.findViewById(R.id.tvalbumid);
            tvId = itemView.findViewById(R.id.tvid);
            tvTitulo = itemView.findViewById(R.id.tvtitulo);
        }
    }
}
