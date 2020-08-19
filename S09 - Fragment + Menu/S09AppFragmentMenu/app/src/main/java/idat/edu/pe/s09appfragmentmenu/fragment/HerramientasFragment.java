package idat.edu.pe.s09appfragmentmenu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import idat.edu.pe.s09appfragmentmenu.R;

public class HerramientasFragment extends Fragment {

    private TextInputEditText etNumero;
    private Button btnCalcular;

    public HerramientasFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_herramientas, container, false);

        etNumero=view.findViewById(R.id.etnumero);
        btnCalcular=view.findViewById(R.id.btncalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double numero = Double.parseDouble(etNumero.getText().toString());
                Double modnumero = numero %2;
                String resultado = "IMPAR";
                if(modnumero == 0){
                    resultado="PAR";
                }
                Toast.makeText(getContext(), "El número es "+resultado, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
