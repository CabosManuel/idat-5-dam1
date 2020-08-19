package idat.edu.pe.s14appsqlliteroom.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import idat.edu.pe.s14appsqlliteroom.R;
import android.widget.Toast;

import idat.edu.pe.s14appsqlliteroom.TarjetaDialogFragment;
import idat.edu.pe.s14appsqlliteroom.db.entity.TarjetaEntity;
import idat.edu.pe.s14appsqlliteroom.viewmodel.TarjetaDialogViewModel;

// SEMANA 15
public class TarjetaAdapter extends RecyclerView.Adapter<TarjetaAdapter.ViewHolder>{

    private Context context;
    private List<TarjetaEntity> list;
    private TarjetaDialogViewModel viewModel;

    public TarjetaAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        // Instancia a la lcase TarjetaDialogViewModel
        viewModel = new ViewModelProvider((AppCompatActivity)this.context)
            .get(TarjetaDialogViewModel.class);
    }

    @NonNull
    @Override
    public TarjetaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tarjeta,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarjetaAdapter.ViewHolder holder, int position) {
        final TarjetaEntity itemTarjeta = list.get(position);
        holder.tvTitulo.setText(itemTarjeta.getTitulo());
        holder.tvContenido.setText(itemTarjeta.getContenido());

        if(itemTarjeta.isImportante()) {
            holder.ivImportante.setImageResource(R.drawable.ic_star_white_24dp);
        }else{
            holder.ivImportante.setImageResource(R.drawable.ic_star_border_white_24dp);
        }

        switch (itemTarjeta.getColor().toUpperCase()){
            case "ROJO":
                holder.cvContendor.setBackgroundColor(Color.RED);
                break;
            case "VERDE":
                holder.cvContendor.setBackgroundColor(Color.GREEN);
                break;
            case "AZUL":
                holder.cvContendor.setBackgroundColor(Color.BLUE);
                break;
            default:
                Toast.makeText(context, "Fallo el cambio de color", Toast.LENGTH_SHORT).show();
                break;
        }

        holder.ivDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewModel.deleteTarjeta(itemTarjeta.getId());
            }
        });

        holder.cvContendor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle parametro = new Bundle();
                parametro.putInt("idtarjeta",itemTarjeta.getId());
                FragmentManager fragmentManager =
                        ((AppCompatActivity)context).getSupportFragmentManager();
                TarjetaDialogFragment dialogFragment =
                        new TarjetaDialogFragment();
                dialogFragment.setArguments(parametro);
                dialogFragment.show(fragmentManager,"NuevaTarjetaDialogFragment");
            }
        });

    }

    public void setList(List<TarjetaEntity> lstNuevasTarjetas){
        this.list = lstNuevasTarjetas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitulo,tvContenido;
        public ImageView ivImportante,ivDelete;
        public CardView cvContendor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvtitulo);
            tvContenido = itemView.findViewById(R.id.tvcontenido);

            ivImportante = itemView.findViewById(R.id.ivfavorito);
            ivDelete = itemView.findViewById(R.id.iveliminar);
            cvContendor = itemView.findViewById(R.id.contenedor);
        }
    }
}
