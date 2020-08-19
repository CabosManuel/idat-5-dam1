package idat.edu.pe.s05apprecilerviewimage.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import idat.edu.pe.s05apprecilerviewimage.DetalleAndroidActivity;
import idat.edu.pe.s05apprecilerviewimage.R;
import idat.edu.pe.s05apprecilerviewimage.model.Android;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Android> lista;

    public AndroidAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public AndroidAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_android,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AndroidAdapter.ViewHolder holder, int position) {
        final Android objAndroid = lista.get(position);
        holder.tvNomAndroid.setText(objAndroid.getNombre());
        holder.tvVerAndroid.setText(objAndroid.getVersion());
        holder.ivAndroid.setImageResource(objAndroid.getImagen());
        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAndroidDetalle = new Intent(context, DetalleAndroidActivity.class);
                intentAndroidDetalle.putExtra("android",objAndroid);
                context.startActivity(intentAndroidDetalle);
            }
        });
    }

    //cuando viene de un servicio web
    public void agregarElementos(ArrayList<Android> listaAndroid){
        lista.clear();
        lista.addAll(listaAndroid);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAndroid;
        TextView tvNomAndroid,tvVerAndroid;
        CardView contenedor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAndroid = itemView.findViewById(R.id.ivandroid);
            tvNomAndroid = itemView.findViewById(R.id.tvnomandroid);
            tvVerAndroid = itemView.findViewById(R.id.tvverandroid);
            contenedor = itemView.findViewById(R.id.contenedor);
        }
    }
}
