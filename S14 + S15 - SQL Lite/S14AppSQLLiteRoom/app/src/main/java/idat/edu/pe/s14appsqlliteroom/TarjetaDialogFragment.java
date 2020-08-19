package idat.edu.pe.s14appsqlliteroom;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputEditText;

import idat.edu.pe.s14appsqlliteroom.db.entity.TarjetaEntity;
import idat.edu.pe.s14appsqlliteroom.viewmodel.TarjetaDialogViewModel;

// SEMANA 15
public class TarjetaDialogFragment extends DialogFragment {

    private View view;
    private TextInputEditText etTitulo, etContenido;
    private RadioGroup rgColor;
    private RadioButton rbtnRojo, rbtnVerde, rbtnAzul;
    private Switch swImportante;
    private TarjetaDialogViewModel mViewModel;
    private Integer idTarjeta = 0;

    public static TarjetaDialogFragment newInstance() {
        return new TarjetaDialogFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            idTarjeta = getArguments().getInt("idtarjeta"); // "el mismos que eta en Adapter"
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(getActivity())
                .get(TarjetaDialogViewModel.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Nueva Tarjeta");
        builder.setMessage("Introdusca los datos de la nueva tarjeta")
                .setPositiveButton("Guardar",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String titulo = etTitulo.getText().toString();
                        String contenido = etContenido.getText().toString();
                        String color = "verde";
                        switch (rgColor.getCheckedRadioButtonId()){
                            case R.id.rbtnrojo:
                                color = "rojo";
                                break;
                            case R.id.rbtnazul:
                                color = "azul";
                        }
                        boolean esImportante = swImportante.isChecked();

                        // Validacion para crear o actualizar
                        if(idTarjeta>0){
                            mViewModel.updateTarjeta(new TarjetaEntity(idTarjeta,
                                    titulo,contenido,esImportante,color));
                        }else{
                            mViewModel.insertTarjeta(new TarjetaEntity(idTarjeta,
                                    titulo,contenido,esImportante,color));
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
            });
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.tarjeta_dialog_fragment,null);
        etTitulo = view.findViewById(R.id.ettitulo);
        etContenido = view.findViewById(R.id.etcontenido);
        rgColor = view.findViewById(R.id.rgcolor);
        rbtnAzul = view.findViewById(R.id.rbtnazul);
        rbtnRojo = view.findViewById(R.id.rbtnrojo);
        rbtnVerde = view.findViewById(R.id.rbtnverde);
        swImportante = view.findViewById(R.id.swfavorito);
        if(idTarjeta>0){
            mViewModel.getTarjeta(idTarjeta)
                    .observe(getActivity(),
                            new Observer<TarjetaEntity>() {
                                @Override
                                public void onChanged(TarjetaEntity tarjetaEntity) {
                                    cargarInfoTarjeta(tarjetaEntity);
                                }
                            });
        }
        builder.setView(view);
        return builder.create();
    }

    private void cargarInfoTarjeta(TarjetaEntity tarjetaEntity) {
        etTitulo.setText(tarjetaEntity.getTitulo());
        etContenido.setText(tarjetaEntity.getContenido());
        if(tarjetaEntity.isImportante()){
            swImportante.setChecked(true);
        }else{
            swImportante.setChecked(false);
        }
        switch (tarjetaEntity.getColor()){
            case "verde": rbtnVerde.setChecked(true); break;
            case "azul": rbtnAzul.setChecked(true); break;
            case "rojo": rbtnRojo.setChecked(true); break;
        }
    }
}
