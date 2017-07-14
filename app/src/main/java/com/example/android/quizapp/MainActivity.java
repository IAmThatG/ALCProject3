package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import services.Examiner;

public class MainActivity extends AppCompatActivity
{
    EditText question2InputText;
    RadioGroup question1RadioGroup;
    RadioGroup question3RadioGroup;
    CheckBox question4CheckBox1;
    CheckBox question4CheckBox2;
    CheckBox question4CheckBox3;
    CheckBox question4CheckBox4;
    Button submitButton;

    Examiner examiner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find all views by id
        question1RadioGroup = (RadioGroup) findViewById(R.id.question_1_options);
        question2InputText = (EditText) findViewById(R.id.question_2_answer);
        question3RadioGroup = (RadioGroup) findViewById(R.id.question_3_options);
        question4CheckBox1 = (CheckBox) findViewById(R.id.eto_checkbox);
        question4CheckBox2 = (CheckBox) findViewById(R.id.pogba_checkbox);
        question4CheckBox3 = (CheckBox) findViewById(R.id.ibrahimovic_checkbox);
        question4CheckBox4 = (CheckBox) findViewById(R.id.bale_checkbox);
        submitButton = (Button) findViewById(R.id.submit_button);

        //set the submit button listener
        addListenerOnSubmitButton();
    }

    private void addListenerOnSubmitButton()
    {
        //set onClick listener
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create an examiner object
                examiner = new Examiner();

                //evaluate question1
                examiner.evaluateRadioOption(getSelectedOption(question1RadioGroup), null);

                //evaluate question2
                examiner.evaluateTextAnswer(question2InputText.getText().toString());

                //evaluate question3
                examiner.evaluateRadioOption(getSelectedOption(question3RadioGroup), null);

                //evaluate question4
                examiner.evaluateRadioOption(null, getCheckedOptions());

                //display total mark
                Toast.makeText(MainActivity.this, result(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /** Gets the selected radio button from a radio button group */
    private String getSelectedOption(RadioGroup radioGroup)
    {
        //find the selected radio button by id
        RadioButton selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

        //return its text
        return selectedRadioButton.getText().toString();
    }

    private ArrayList<String> getCheckedOptions()
    {
        //create an ArrayList object that holds the checked options
        ArrayList<String> checkedOptions = new ArrayList<>();

        //get the text of a checkbox if it is checked and store the text in the ArrayList
        if (question4CheckBox1.isChecked())
            checkedOptions.add(question4CheckBox1.getText().toString());
        if (question4CheckBox2.isChecked())
            checkedOptions.add(question4CheckBox2.getText().toString());
        if (question4CheckBox3.isChecked())
            checkedOptions.add(question4CheckBox3.getText().toString());
        if (question4CheckBox4.isChecked())
            checkedOptions.add(question4CheckBox4.getText().toString());
        return checkedOptions;
    }

    public String result()
    {
        String resultText = "You got ";
        resultText += String.valueOf(examiner.getTotalMark());
        resultText += "/5";
        return resultText;
    }
}
