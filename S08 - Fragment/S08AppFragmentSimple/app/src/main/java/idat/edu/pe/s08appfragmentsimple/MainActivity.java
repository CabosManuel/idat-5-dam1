package idat.edu.pe.s08appfragmentsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnFragment1,btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment1 = findViewById(R.id.btnfragment1);
        btnFragment2 = findViewById(R.id.btnfragment2);

        btnFragment1.setOnClickListener(this);
        btnFragment2.setOnClickListener(this);

        final Fragment1 frag1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.flcontenedor,frag1).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnfragment1:
                getSupportFragmentManager().beginTransaction().replace(R.id.flcontenedor,
                        new Fragment1()).commit();
                break;
            case R.id.btnfragment2:
                getSupportFragmentManager().beginTransaction().replace(R.id.flcontenedor,
                        new Fragment2()).commit();
                break;
        }
    }
}
