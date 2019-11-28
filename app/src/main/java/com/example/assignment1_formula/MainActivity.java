package com.example.assignment1_formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txtResult;
    TextInputEditText txtX, txtY, txtZ;
    TextInputLayout tilX, tilY, tilZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.result);
        txtX = findViewById(R.id.xVar);
        txtY = findViewById(R.id.yVar);
        txtZ = findViewById(R.id.zVar);
        tilX = findViewById(R.id.textInputLayoutX);
        tilY = findViewById(R.id.textInputLayoutY);
        tilZ = findViewById(R.id.textInputLayoutZ);

        txtX.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    tilX.setErrorEnabled(true);
                    tilX.setError("Please enter value for X ");
                } else {
                    tilX.setError(null);
                    tilX.setErrorEnabled(false);
                }
            }
        });

        txtY.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    tilY.setErrorEnabled(true);
                    tilY.setError("Please enter value for Y");
                } else {
                    tilY.setError(null);
                    tilY.setErrorEnabled(false);
                }
            }
        });

        txtZ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    tilZ.setErrorEnabled(true);
                    tilZ.setError("Please enter value for Z");
                } else {
                    tilZ.setError(null);
                    tilZ.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    tilZ.setErrorEnabled(true);
                    tilZ.setError("Please enter value for Z");
                } else {
                    tilZ.setError(null);
                    tilZ.setErrorEnabled(false);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(!tilX.isErrorEnabled() && !tilY.isErrorEnabled() && !tilZ.isErrorEnabled()) {
                    String xVal, yVal, zVal;
                    double inputX, inputY, inputZ;
                    xVal = txtX.getText().toString();
                    yVal = txtY.getText().toString();
                    zVal = txtZ.getText().toString();

                    inputX = new Double(xVal).doubleValue();
                    inputY = new Double(yVal).doubleValue();
                    inputZ = new Double(zVal).doubleValue();
                    txtResult.setText(getResult(inputX, inputY, inputZ));
                }
                else {
                    txtResult.setText("Invalid Input");
                }
            }
            private String getResult(double x, double y, double z){
                double result = Math.round(((60 * x) + (29 * y) * (88 * z))*10.0)/10.0;
                return ""+result;
            }
        });


    }

}

