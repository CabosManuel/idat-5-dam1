package ef.appcabosmanuel.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ef.appcabosmanuel.EstacionamientoDialogFragment;
import ef.appcabosmanuel.R;
import ef.appcabosmanuel.db.entity.EstacionamientoEntity;
import ef.appcabosmanuel.viewmodel.EstacionamientoDialogViewModel;

public class EstacionamientoAdapter extends
        RecyclerView.Adapter<EstacionamientoAdapter.ViewHolder> {

    private Context context;
    private List<EstacionamientoEntity> list;
    private EstacionamientoDialogViewModel viewModel;

    public EstacionamientoAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        viewModel = new ViewModelProvider((AppCompatActivity)this.context)
                .get(EstacionamientoDialogViewModel.class);
    }
    
    @NonNull
    @Override
    public EstacionamientoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estacionamiento,parent,
                        false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstacionamientoAdapter.ViewHolder holder, int position) {
        final EstacionamientoEntity e = list.get(position);
        holder.tvNombre.setText(e.getNombreEstacionamiento());
        holder.tvCodigo.setText(String.valueOf(e.getCodEstacionamiento()));
        holder.tvAforo.setText(String.valueOf(e.getAforoMax()));
        holder.tvLavado.setText(e.getIncluyeLavado());
        if(e.getIncluyeLavado().equals("No incluye lavado.")){
            holder.tvLavado.setTextColor(Color.RED);
        }else{
            holder.tvLavado.setTextColor(Color.GREEN);
        }

        holder.tvEstado.setText(e.getEstado());

        switch (e.getEstado()){
            case "El estacionamiento está lleno.":
                holder.tvEstado.setTextColor(Color.RED);
                break;
            case "El estacionamiento está reservado.":
                holder.tvEstado.setTextColor(Color.YELLOW);
                break;
            case "El estacionamiento está vacío.":
                holder.tvEstado.setTextColor(Color.GREEN);
                break;
            default:
                Toast.makeText(context, "Falló cargar estado estacionamiento", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void setList(List<EstacionamientoEntity> listNuevosEstacionamientos){
        this.list = listNuevosEstacionamientos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNombre,tvCodigo,tvAforo,tvLavado,
                tvEstado;
        public CardView cvContenedor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tv_nombre);
            tvCodigo = itemView.findViewById(R.id.tv_cod);
            tvAforo = itemView.findViewById(R.id.tv_aforo);
            tvLavado = itemView.findViewById(R.id.tv_lavado);
            tvEstado = itemView.findViewById(R.id.tv_estado);
            cvContenedor = itemView.findViewById(R.id.contenedor);
        }
    }
}
