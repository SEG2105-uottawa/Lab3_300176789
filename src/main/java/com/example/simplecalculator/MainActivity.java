package com.example.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends Activity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });

    }

    private void updateText (String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }


    }


    public void btn00 (View view) {
        updateText ( "0");
    }

    public void btn01 (View view) {
        updateText ( "1");
    }

    public void btn02 (View view) {
        updateText ( "2");
    }

    public void btn03 (View view) {
        updateText ( "3");
    }

    public void btn04 (View view) {
        updateText ( "4");
    }

    public void btn05 (View view) {
        updateText ( "5");
    }

    public void btn06 (View view) {
        updateText ( "6");
    }

    public void btn07 (View view) {
        updateText ( "7");
    }

    public void btn08 (View view) {
        updateText ( "8");
    }

    public void btn09 (View view) {
        updateText ( "9");
    }

    public void btnAddClick (View view) {
        updateText ( "+");
    }

    public void btnMinusClick (View view) {
        updateText ( "-");
    }

    public void btnMultiplyClick (View view) {
        updateText ( "X");
    }

    public void btnDivideClick (View view) {
        updateText ( "/");
    }

    public void btnClearClick (View view) {
        display.setText("");
    }

    public void btnDotClick (View view) {
        updateText ( ".");
    }

    public void btnResult (View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("X", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void btnBackspace (View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

}