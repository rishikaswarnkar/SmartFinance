package com.example.gg.smartfinances;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class conversion extends AppCompatActivity {
    double amountEntered=0;
    double convertedAmount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

      final   EditText money = (EditText) findViewById(R.id.amount);
        final RadioButton dollartoRupee = (RadioButton) findViewById(R.id.radDollar);
       final RadioButton rupeetoDollar = (RadioButton) findViewById(R.id.radRupees);
        final TextView result = (TextView) findViewById(R.id.txtAnswer);
        Button cal = (Button) findViewById(R.id.btnCal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               amountEntered= Double.parseDouble(money.getText().toString()) ;
                DecimalFormat tenth= new DecimalFormat("#.#");
                if (dollartoRupee.isChecked()) {
                          if(amountEntered<=10000000)
                          {
                            convertedAmount= amountEntered/60;
                            result.setText(tenth.format(convertedAmount)+"($)" );
                          }
                          else
                          {
                              Toast.makeText(conversion.this,"Try a smaller number.",Toast.LENGTH_LONG).show();
                          }
                }
                if (rupeetoDollar.isChecked()) {
                    if(amountEntered<=10000000)
                    {
                        convertedAmount= amountEntered*60;
                        result.setText(tenth.format(convertedAmount)+"(INR)" );
                    }
                    else
                    {
                        Toast.makeText(conversion.this,"Try a smaller number.",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        }
    }

