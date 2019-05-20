package com.example.calculatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void insertValue(View view){
        switch (view.getId()){
            case R.id.button:
                EditText val1 = (EditText)findViewById(R.id.v1);
                EditText val2 = (EditText)findViewById(R.id.v2);
                Spinner spinner1 = (Spinner)findViewById(R.id.spinner);
                String spin = (String)spinner1.getSelectedItem();
                Double value1 = null;
                Double value2 = null;

                try {
                    value1 = Double.parseDouble(val1.getText().toString());
                }
                catch (Exception E){
                    Toast.makeText(MainActivity.this, "Error, empty value automatically set to 0.0", Toast.LENGTH_LONG).show();
                    value1 = 0.0;
                }

                try {
                    value2 = Double.parseDouble(val2.getText().toString());
                }
                catch (Exception E) {
                    Toast.makeText(MainActivity.this, "Error, empty value automatically set to 0.0", Toast.LENGTH_LONG).show();
                    value2 = 0.0;
                }
                Double result = 0.0;
                if(spin.equals("+")){
                    result = value1 + value2;
                }
                else if(spin.equals("-")){
                    result = value1 - value2;
                }
                else if(spin.equals("*")){
                    result = value1 * value2;
                }
                else if(spin.equals("/")){
                    if(value2 == 0){
                        result = 0.0;
                    }
                    result = value1 / value2;
                }
                TextView res = findViewById(R.id.ans);
                res.setText("Answer: " + result);

        }
    }
}
