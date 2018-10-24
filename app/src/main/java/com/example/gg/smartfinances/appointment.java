package com.example.gg.smartfinances;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class appointment extends Activity {
private TextView reservations;
String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        reservations =(TextView)findViewById(R.id.txtDate);
        Button btDate =(Button)findViewById(R.id.btnDate);
        Spinner spinner = (Spinner) findViewById(R.id.txtGroup);
        final Spinner group= (Spinner)findViewById(R.id.txtGroup);

        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(appointment.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
            }
            Calendar c = Calendar.getInstance();
            DateFormat fntDate =DateFormat.getDateInstance();
            DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    c.set(Calendar.YEAR,year);
                    c.set(Calendar.MONTH, monthOfYear);
                    c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    groupChoice = group.getSelectedItem().toString();
                    reservations.setText("Your Appointment is set for " + fntDate.format(c.getTime())+" at "+groupChoice);
                }
            };
        });
    }

}
