package com.example.gg.smartfinances;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class StudentLoan extends AppCompatActivity {
    double bal=0;
    double i=0 ;
    double m=0;
    int t=0;
    double totalInterest=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_loan);
        final EditText balance = (EditText) findViewById(R.id.numBal);
        final EditText monthlyPay = (EditText) findViewById(R.id.numMonthly);
        final   EditText time = (EditText) findViewById(R.id.numYear);
        final TextView result = (TextView) findViewById(R.id.txtInterstPaid);
        Button cal = (Button) findViewById(R.id.btnInterest);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bal = Double.parseDouble(balance.getText().toString());
                m = Double.parseDouble(monthlyPay.getText().toString());
                t = Integer.parseInt(time.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if (bal <= 100000000) {

                    if ((m * t * 12) > bal) {
                        totalInterest = (m * t * 12) - bal;
                        result.setText("Your Credit Card Interest will be : $ " + tenth.format(totalInterest));
                    }
                    else
                    {
                        Toast.makeText(StudentLoan.this, "Input Correct Minimum balance.", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(StudentLoan.this, "Try a smaller number.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
