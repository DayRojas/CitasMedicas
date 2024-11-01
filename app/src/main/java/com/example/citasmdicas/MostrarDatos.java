package com.example.citasmdicas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class MostrarDatos extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        // Get the message from the intent
        Intent intent = getIntent();
        String mensaje = intent.getStringExtra("mensaje");

        // Find the TextView in the layout
        textView = findViewById(R.id.textView);

        // Set the message to the TextView
        textView.setText(mensaje);
    }
    }
