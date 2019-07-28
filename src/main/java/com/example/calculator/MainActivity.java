package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one, two, three, four, five, six, seven, eight, nine, zero, clear, divide, multiply,
                    subtract, equals, add;

    TextView info, result;

    private final char ADDITION = '+';
    private final char SUBSTRACTION = '-';
    private final char DIVIDE = '÷';
    private final char MULTIPLY = '•';
    private final char EQUALS = '=';
    private final char EQU = '0';
    private double val1  = Double.NaN;
    private double val2 = Double.NaN;
    private char action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                compute();
                action = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);

            }

        });

        subtract.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                compute();
                action = SUBSTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);

            }

        });

        multiply.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                compute();
                action = MULTIPLY;
                result.setText(String.valueOf(val1) + "•");
                info.setText(null);

            }

        });

        divide.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                compute();
                action = DIVIDE;
                result.setText(String.valueOf(val1) + "÷");
                info.setText(null);

            }

        });

        equals.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                compute();
                action = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                /*
                *  5 + 4 = 9 -- 5 is val1
                *
                * */
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(info.getText().length() > 0){

                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));

                }else{

                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    private void setUpViews(){

        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four  = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        zero = (Button)findViewById(R.id.btn0);
        clear =  (Button)findViewById(R.id.btnClear);
        divide = (Button)findViewById(R.id.btnDiv);
        multiply = (Button)findViewById(R.id.btnMult);
        subtract = (Button)findViewById(R.id.btnSub);
        equals = (Button)findViewById(R.id.btnEquals);
        info = (TextView) findViewById(R.id.tvControl);
        result = (TextView) findViewById(R.id.tvResults);

    }


    private void compute(){

        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch (action){

                case ADDITION:

                    val1 += val2;
                    break;

                case SUBSTRACTION:
                    val1 -= val2;
                    break;

                case MULTIPLY:
                    val1 *= val2;
                    break;

                case DIVIDE:
                    val1 /= val2;
                    break;

                case EQU:
                    break;
            }
        }else{

            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}
