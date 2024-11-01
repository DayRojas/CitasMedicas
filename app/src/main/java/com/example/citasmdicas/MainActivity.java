package com.example.citasmdicas;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.Button;
import android.view.View;
import java.util.Calendar;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

       TextView textViewNombre, textViewFecha, textViewEspecialidad,textViewModalidad,textViewVacuna;
       EditText editTextNombre;
        Spinner especialidadSpinner;
        DatePicker fechaPicker;
       RadioButton presencialRadioButton;
        RadioButton remotaRadioButton;
        CheckBox No_vacunado_check_box, vacunado_1_dosis_check_box,vacunado_2_dosis_check_box,vacunado_3_dosis_check_box;
         Button solicitarButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textViewNombre=findViewById(R.id.textViewNombre);
            textViewFecha=findViewById(R.id.textViewFecha);
            textViewModalidad=findViewById(R.id.textViewModalidad);
            textViewEspecialidad=findViewById(R.id.textViewEspecialidad);
            textViewVacuna=findViewById(R.id.textViewVacuna);
            editTextNombre=findViewById(R.id.editTextNombre);
            especialidadSpinner = findViewById(R.id.especialidad_spinner);
            fechaPicker = findViewById(R.id.fecha_picker);
            presencialRadioButton = findViewById(R.id.presencial_radio_button);
            remotaRadioButton = findViewById(R.id.remota_radio_button);
            No_vacunado_check_box = findViewById(R.id.No_vacunado_check_box);
            vacunado_1_dosis_check_box = findViewById(R.id.vacunado_1_dosis_check_box);
            vacunado_2_dosis_check_box = findViewById(R.id.vacunado_2_dosis_check_box);
            vacunado_3_dosis_check_box = findViewById(R.id.vacunado_3_dosis_check_box);
            solicitarButton = findViewById(R.id.solicitar_button);

            solicitarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = editTextNombre.getText().toString();
                    String especialidad = especialidadSpinner.getSelectedItem().toString();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(fechaPicker.getYear(), fechaPicker.getMonth(), fechaPicker.getDayOfMonth());
                    int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

                    String fecha = fechaPicker.getDayOfMonth() + "/" + (fechaPicker.getMonth() + 1) + "/" + fechaPicker.getYear();
                    String tipoCita = presencialRadioButton.isChecked() ? "Presencial" : "Remota";
                    String vacunado = "";

                    if (No_vacunado_check_box.isChecked()) {
                        vacunado = "No Vacunado";
                    } else if (vacunado_1_dosis_check_box.isChecked()) {
                        vacunado = "Vacunado 1 dosis";
                    } else if (vacunado_2_dosis_check_box.isChecked()) {
                        vacunado = "Vacunado 2 dosis";
                    } else if (vacunado_3_dosis_check_box.isChecked()) {
                        vacunado = "Vacunado 3 dosis";
                    }

                    if (diaSemana == Calendar.SUNDAY) {
                        Toast.makeText(getApplicationContext(), "No se pueden solicitar citas los domingos", Toast.LENGTH_SHORT).show();
                    } else {
                        String mensaje = "Hola"+" "+name+ "\nSolicitud de cita: " + especialidad + "\nFecha: " + fecha + "\nTipo de cita: " + tipoCita + "\n¿Está vacunado?: "+ vacunado;

                        // Create a new intent to start the new activity
                        Intent intent = new Intent(MainActivity.this, MostrarDatos.class);

                        // Pass the data to the new activity
                        intent.putExtra("mensaje", mensaje);

                        // Start the new activity
                        startActivity(intent);
                    }
            }
        });

    }
}

