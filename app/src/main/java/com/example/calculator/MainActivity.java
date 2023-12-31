package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R.layout;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

public final class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resultTv, calcTv;
    MaterialButton clear, negate, percent, period, equals;
    MaterialButton divide, multiply, subtract, addition;
    MaterialButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
            buttonSeven, buttonEight, buttonNine, buttonZero;
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
        helperID(buttonZero, R.id.buttonZero);
    }

    void helperID(MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String text = button.getText().toString();
        if(text.equals("C")){
            resultTv.setText("0");
            calcTv.setText("");
            return;
        }
        String toAdd = calcTv.getText().toString();
        String added = toAdd + text;
        calcTv.setText(added);
        String finalResult = getResult(added);
        if(!finalResult.equals("Error")){
            resultTv.setText(finalResult);
        }
        if(text.equals("=")){
            calcTv.setText(resultTv.getText());
            return;
        }
    }

    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "JavaScript", 1, null).toString();
            return finalResult;
        }catch (Exception e){
            return "Error";
        }

    }
}
