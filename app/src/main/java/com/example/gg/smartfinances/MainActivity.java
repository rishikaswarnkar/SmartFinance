package com.example.gg.smartfinances;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton convert = (RadioButton)findViewById (R.id.radConvert);
        final RadioButton studentLoan = (RadioButton)findViewById (R.id.radTotalInterest);
        final RadioButton creditPay = (RadioButton)findViewById (R.id.radCredit);
        final RadioButton appointments = (RadioButton)findViewById (R.id.radApp);

        Button btCal = (Button)findViewById(R.id.btnCalculate);
        btCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(convert.isChecked()){
                    startActivity(new Intent(MainActivity.this, conversion.class));
                }
                if(studentLoan.isChecked()){
                    startActivity(new Intent(MainActivity.this, StudentLoan.class));
                }
                if(creditPay.isChecked()){
                    startActivity(new Intent(MainActivity.this, CreditPayOff.class));
                }
                if(appointments.isChecked()){
                    startActivity(new Intent(MainActivity.this, appointment.class));
                }
            }
        });




    }
}
