package com.example.mockup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void proximaTela(View view) {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void tela_mapa(View view) {

        Intent intent = new Intent(this, Exercicio_Maps.class);
        startActivity(intent);
    }

}
