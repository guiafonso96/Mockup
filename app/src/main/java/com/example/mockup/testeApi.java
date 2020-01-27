package com.example.mockup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class testeApi extends AppCompatActivity {

    Button btnBuscarCep = findViewById(R.id.btnMain_buscarCep);

    btnBuscarCep.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // buscar o CEP
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_api);
    }
    
}
