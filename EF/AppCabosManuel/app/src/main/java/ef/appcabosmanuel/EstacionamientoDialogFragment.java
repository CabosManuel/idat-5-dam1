package ef.appcabosmanuel;

import androidx.fragment.app.DialogFragment;
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

import ef.appcabosmanuel.db.entity.EstacionamientoEntity;
import ef.appcabosmanuel.viewmodel.EstacionamientoDialogViewModel;

public class EstacionamientoDialogFragment extends DialogFragment {


    private View view;
    private TextInputEditText etNombre, etAforo;
    private RadioGroup rgEstado;
    private RadioButton rbtnLleno, rbtnVacio, rbtnReservado;
    private Switch swLavado;
    private EstacionamientoDialogViewModel mViewModel;
    private Integer codEstacionamiento = 0;

    public static EstacionamientoDialogFragment newInstance() {
        return new EstacionamientoDialogFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            codEstacionamiento = getArguments().getInt("cod");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(getActivity())
                .get(EstacionamientoDialogViewModel.class);
        AlertDialog.Builder builder = new AlertDialog
                .Builder(getActivity());
        builder.setTitle("Nuevo Estacionamiento");
        builder.setMessage("Introdusca los datos de nuevo estacionamiento.")
            .setPositiveButton("Guardar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nombre = etNombre.getText().toString();
                        int aforo = Integer.parseInt(etAforo.getText().toString());
                        String lavado = "No incluye lavado.";
                        if(swLavado.isChecked()){
                            lavado="Sí incluye lavado.";
                        }

                        String estado = "El estacionamiento está vacío.";
                        switch (rgEstado.getCheckedRadioButtonId()){
                            case R.id.rbtn_lleno:
                                estado = "El estacionamiento está lleno.";
                                break;
                            case R.id.rbtn_reservado:
                                estado = "El estacionamiento está reservado.";
                                break;
                        }

                        mViewModel.insertEstacionamiento(
                            new EstacionamientoEntity(0,
                                    nombre,aforo,lavado,estado));
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.estacionamiento_dialog_fragment,
                null);
        etNombre = view.findViewById(R.id.et_nombre);
        etAforo = view.findViewById(R.id.et_aforo);
        swLavado = view.findViewById(R.id.sw_lavado);
        rgEstado = view.findViewById(R.id.rg_estado);
        rbtnLleno = view.findViewById(R.id.rbtn_lleno);
        rbtnReservado = view.findViewById(R.id.rbtn_reservado);
        rbtnVacio = view.findViewById(R.id.rdbtn_vacio);

        builder.setView(view);
        return builder.create();
    }
}
