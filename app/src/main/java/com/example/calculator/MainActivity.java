package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R.layout;
import com.google.android.material.button.MaterialButton;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

public final class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resultTv, calcTv;
    MaterialButton clear, negate, percent, period, equals;
    MaterialButton divide, multiply, subtract, addition;
    MaterialButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
            buttonSeven, buttonEight, buttonNine;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);
        resultTv = findViewById(R.id.finalText);
        calcTv = findViewById(R.id.calculationText);
        helperID(clear, R.id.clearButton);
        helperID(negate, R.id.negateButton);
        helperID(percent, R.id.percentButton);
        helperID(period, R.id.periodButton);
        helperID(equals, R.id.equalsButton);
        helperID(divide, R.id.divideButton);
        helperID(multiply, R.id.multiplyButton);
        helperID(subtract, R.id.subtractButton);
        helperID(addition, R.id.addButton);
        helperID(buttonOne, R.id.buttonOne);
        helperID(buttonTwo, R.id.buttonTwo);
        helperID(buttonThree, R.id.buttonThree);
        helperID(buttonFour, R.id.buttonFour);
        helperID(buttonFive, R.id.buttonFive);
        helperID(buttonSix, R.id.buttonSix);
        helperID(buttonSeven, R.id.buttonSeven);
        helperID(buttonEight, R.id.buttonEight);
        helperID(buttonNine, R.id.buttonNine);
    }

    void helperID(MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String text = button.getText().toString();
        String toAdd = calcTv.getText().toString();
        String added = toAdd + text;
        calcTv.setText(added);
    }
}
