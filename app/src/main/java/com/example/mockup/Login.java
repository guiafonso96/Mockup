package com.example.mockup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void proxima_Tela_ (View view) {

        Intent intent = new Intent(this, tela_mapa.class);
        startActivity(intent);
    }
    public void proxima_Tela2_ (View view) {

        Intent intent = new Intent(this, cadastrar.class);
        startActivity(intent);
    }
}
