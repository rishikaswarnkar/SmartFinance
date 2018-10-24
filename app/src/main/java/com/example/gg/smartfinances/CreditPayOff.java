package com.example.gg.smartfinances;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CreditPayOff extends AppCompatActivity {
   double bal=0;
   double i=0 ;
   int t=0;
   double minPay=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_pay_off);
        final EditText balance = (EditText) findViewById(R.id.numCcb);
        final   EditText interest = (EditText) findViewById(R.id.numInterest);
        final   EditText time = (EditText) findViewById(R.id.numYear);
        final TextView result = (TextView) findViewById(R.id.minPayment);
        Button cal = (Button) findViewById(R.id.btnPayment);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bal = Double.parseDouble(balance.getText().toString());
                i = Double.parseDouble(interest.getText().toString());
                t = Integer.parseInt(time.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if (bal <= 100000000) {
                    i=i/100;
                    double div = (1 - (1 / Math.pow((1 + i / 12), (t * 12)))) / (i / 12);
                    minPay = bal / div;
                    result.setText("Your Minimum Monthly Payment is: $ " + tenth.format(minPay));
                }
                else {
                    Toast.makeText(CreditPayOff.this, "Try a smaller number.", Toast.LENGTH_LONG).show();
                }
            }
        });
}

    }
