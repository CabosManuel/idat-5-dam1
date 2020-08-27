package idat.edu.pe.appec2manuelcabos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import idat.edu.pe.appec2manuelcabos.model.Libro;

public class ListadoDetalleActivity extends AppCompatActivity {

    private ImageView ivDetLibro;
    private TextView tvDetTituloLibro;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_detalle);

        ivDetLibro=findViewById(R.id.ivdetlibro);
        tvDetTituloLibro=findViewById(R.id.tvdettitulolibro);
        if(getIntent().hasExtra("libro")){
            Libro objLibro = getIntent().getParcelableExtra("libro");
            tvDetTituloLibro.setText(Html.fromHtml("<b>Titulo: </b> "+objLibro.getTitulo()));
            ivDetLibro.setImageResource(objLibro.getImagen());
        }
    }
}
