package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> calculate_list = new ArrayList<>();

    private boolean has_plus_been_clicked;
    private boolean has_divide_been_clicked;
    private boolean has_minus_been_clicked;
    private boolean has_multiply_been_clicked;
    private int counter = 0;

    public static final String EXTRA_MESSAGE = "Result from activity one is...: ";

    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_one = findViewById(R.id.button_one);
        Button button_two = findViewById(R.id.button_two);
        Button button_three = findViewById(R.id.button_three);
        Button button_four = findViewById(R.id.button_four);
        Button button_five = findViewById(R.id.button_five);
        Button button_six = findViewById(R.id.button_six);
        Button button_seven = findViewById(R.id.button_seven);
        Button button_eight = findViewById(R.id.button_eight);
        Button button_nine = findViewById(R.id.button_nine);
        Button button_zero = findViewById(R.id.button_zero);

        Button button_plus = findViewById(R.id.button_plus);
        Button button_minus = findViewById(R.id.button_minus);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divide = findViewById(R.id.button_division);

        Button button_ac = findViewById(R.id.button_clear);

        Button button_scientific = findViewById(R.id.button_scientific);

        Button button_equals = findViewById(R.id.button_equals);
        TextView result_text = findViewById(R.id.result_text_view);

        button_ac.setOnClickListener((view -> {
            result_text.setText("");
            counter = 0;
            has_minus_been_clicked = false;
            has_multiply_been_clicked = false;
            has_plus_been_clicked = false;
            has_divide_been_clicked = false;
            calculate_list.clear();
        }));

        //---BUTTONS
        button_one.setOnClickListener((view -> {
            calculate_list.add(button_one.getText().toString());
            result_text.setText(calculate_list.get(calculate_list.size()-1));
            counter++;
        }));

        button_two.setOnClickListener((view -> {
            calculate_list.add(button_two.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(calculate_list.size() - 1).toString());
        }));

        button_three.setOnClickListener((view ->{
            calculate_list.add(button_three.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(0).toString());
        }));

        button_four.setOnClickListener((view -> {
            calculate_list.add(button_four.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(calculate_list.size() - 1).toString());
        }));

        button_five.setOnClickListener((view ->{
            calculate_list.add(button_five.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(0).toString());
        }));

        button_six.setOnClickListener((view -> {
            calculate_list.add(button_six.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(calculate_list.size() - 1).toString());
        }));

        button_seven.setOnClickListener((view ->{
            calculate_list.add(button_seven.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(0).toString());
        }));

        button_eight.setOnClickListener((view -> {
            calculate_list.add(button_eight.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(calculate_list.size() - 1).toString());
        }));

        button_nine.setOnClickListener((view ->{
            calculate_list.add(button_nine.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(0).toString());
        }));

        button_zero.setOnClickListener((view -> {
            calculate_list.add(button_zero.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(calculate_list.size() - 1).toString());
        }));

        //---BUTTONS

        button_plus.setOnClickListener((view ->{
            has_plus_been_clicked = true;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(0).toString());
        }));

        button_divide.setOnClickListener((view -> {
            has_divide_been_clicked = true;
        }));

        button_multiply.setOnClickListener((view -> {
            has_multiply_been_clicked = true;
        }));

        button_minus.setOnClickListener((view ->  {
            has_minus_been_clicked = true;
        }));

        button_equals.setOnClickListener((view -> {
            if(has_plus_been_clicked && counter == 2)
            {
                result_text.setText("" + calculate_plus(calculate_list.get(0),calculate_list.get(1)));
                result = result_text.getText().toString();

            }
            if(has_divide_been_clicked && counter == 2)
            {
                result_text.setText("" + calculate_divide(calculate_list.get(0),calculate_list.get(1)));
                result = result_text.getText().toString();

            }
            if(has_minus_been_clicked && counter == 2)
            {
                result_text.setText("" + calculate_minus(calculate_list.get(0),calculate_list.get(1)));
                result = result_text.getText().toString();

            }
            if(has_multiply_been_clicked && counter == 2)
            {
                result_text.setText("" + calculate_multiply(calculate_list.get(0),calculate_list.get(1)));
                result = result_text.getText().toString();

            }
            counter = 0;

            sendMessage();
        }));

        /*if(has_plus_been_clicked && counter == 1)
        {
            result_text.setText(calculate_list.get(calculate_list.size() - 1));

        }*/

        button_scientific.setOnClickListener((view -> {
            Intent data = new Intent(this, SecondActivity.class);
            data.putExtra("Value1","data for second activity");
            data.putExtra("Value2", "data for second activity");
        }));
    }

    public void sendMessage()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE,result);

        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

    }

    public int calculate_plus(String one, String two){
        int tmpInt = Integer.parseInt(one);
        int tmpIntTwo = Integer.parseInt(two);

        return tmpInt + tmpIntTwo;
    }

    public int calculate_multiply(String one, String two){
        int tmpInt = Integer.parseInt(one);
        int tmpIntTwo = Integer.parseInt(two);

        return tmpInt * tmpIntTwo;
    }

    public double calculate_divide(String one, String two){
        int tmpInt = Integer.parseInt(one);
        int tmpIntTwo = Integer.parseInt(two);

        return !(tmpInt / tmpIntTwo == 0) ? 0 : (double)(tmpInt / tmpIntTwo);
    }

    public int calculate_minus(String one, String two){
        int tmpInt = Integer.parseInt(one);
        int tmpIntTwo = Integer.parseInt(two);

        return tmpInt - tmpIntTwo;
        //to return absolute values ie never negative
        //return tmpInt > tmpIntTwo ? tmpInt - tmpIntTwo : tmpIntTwo - tmpInt;
    }



}
