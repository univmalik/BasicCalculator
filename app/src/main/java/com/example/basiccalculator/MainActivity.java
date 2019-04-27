package com.example.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText displayText;
    private Double number1 = 0.0;
    private Double number2 = 0.0;
    private Double sum = 0.0;
    private String opCase;

    boolean checkNum = false;
    //decides whether its first number or 2nd number
    //in calculation

    //if true, resets the displayText to clear.
    boolean newText = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        displayText = findViewById(R.id.display);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button buttonDecimal = findViewById(R.id.buttonDecimal);

        Button buttonPlus = findViewById(R.id.buttonPlus);

        Button clearButton = findViewById(R.id.clear);
        Button equalButton = findViewById(R.id.equal);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newText == true){
                    displayText.getText().clear();
                    newText = false;
                }
                    Button b = (Button) v;
                    displayText.append(b.getText());

            }
        };

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        buttonDecimal.setOnClickListener(listener);

        View.OnClickListener plusListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opCase = "+";
                newText = true;
                //check whether first number to be entered or 2nd.
                if (checkNum == false){
                    number1 = Double.valueOf(displayText.getText().toString());
                } else {
                    number2 = Double.valueOf(displayText.getText().toString());
                }
                checkNum = true;    //checkNumber is always true otherwise once first is added.


            }
        };

        buttonPlus.setOnClickListener(plusListener);

        View.OnClickListener equalListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newText = true;
                //get value of number2
                if (checkNum == false){
                    number1 = Double.valueOf(displayText.getText().toString());
                } else {
                    number2 = Double.valueOf(displayText.getText().toString());
                }
                switch (opCase){
                    case "+":
                        sum = number1 + number2;
                        displayText.setText(sum.toString());
                        break;
                    case "-":
                        sum = number1 - number2;
                        displayText.setText(sum.toString());
                        break;
                    case "*":
                        sum = number1 * number2;
                        displayText.setText(sum.toString());
                        break;
                    case "/":
                        sum = number1/number2;
                        displayText.setText(sum.toString());
                        break;

                }


            }
        };

        equalButton.setOnClickListener(equalListener);

        View.OnClickListener clearListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear the text, set both numbers to zero and shift to 1st Number.
                displayText.getText().clear();
                number1 = 0.0;
                number2 = 0.0;
                sum = 0.0;
                checkNum = false;
                opCase = null;
                newText = false;
            }
        };

        clearButton.setOnClickListener(clearListener);
    }

}
