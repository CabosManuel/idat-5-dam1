package idat.edu.pe.s05apprecilerviewimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import idat.edu.pe.s05apprecilerviewimage.model.Android;

public class DetalleAndroidActivity extends AppCompatActivity {

    private ImageView ivDetAndroid;
    private TextView tvDetNomAndroid, tvDetVerAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_android);

        ivDetAndroid=findViewById(R.id.ivdetandroid);
        tvDetNomAndroid=findViewById(R.id.tvdetnomandroid);
        tvDetVerAndroid=findViewById(R.id.tvdetverandroid);
        if(getIntent().hasExtra("android")){
            Android objAndroid = getIntent().getParcelableExtra("android");
            tvDetNomAndroid.setText(Html.fromHtml("<b>Android</b> "+objAndroid.getNombre()));
            tvDetVerAndroid.setText(Html.fromHtml("<b>Versión:</b> "+objAndroid.getVersion()));
            ivDetAndroid.setImageResource(objAndroid.getImagen());
        }
    }
}
