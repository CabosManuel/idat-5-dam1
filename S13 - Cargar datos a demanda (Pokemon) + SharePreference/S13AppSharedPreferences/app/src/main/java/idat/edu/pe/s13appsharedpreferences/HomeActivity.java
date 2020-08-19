package idat.edu.pe.s13appsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUser;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvUser = findViewById(R.id.tvuser);
        btnLogout = findViewById(R.id.btnlogout);

        SharedPreferences preferences = getSharedPreferences("appIDAT",MODE_PRIVATE);
        tvUser.setText(preferences.getString("user","Usuario no encontrado ☹"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("appIDAT",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
