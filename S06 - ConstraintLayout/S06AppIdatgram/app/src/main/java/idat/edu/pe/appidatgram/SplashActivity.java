package idat.edu.pe.appidatgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Intent intetLogin = new Intent(this, LoginActivity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);
                }catch (InterruptedException ex){

                }finally {
                    startActivity(intetLogin);
                    finish();
                }
            }
        };
        timer.start();
    }
}
