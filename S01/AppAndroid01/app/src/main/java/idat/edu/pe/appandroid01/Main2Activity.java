package idat.edu.pe.appandroid01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnirpar,btnirimc;
        btnirpar = findViewById(R.id.btnirpar);
        btnirimc = findViewById(R.id.btnirimc);

        btnirpar.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               startActivity(new Intent(Main2Activity.this,Main2Activity.class));
           }
        });

        btnirimc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
    }
}
