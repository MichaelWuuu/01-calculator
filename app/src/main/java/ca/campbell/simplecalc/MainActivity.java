package ca.campbell.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//  TODO: add buttons & methods for subtract, multiply, divide
//  TODO: extra input validation: no divide by zero

//  TODO: add a clear button that will clear the result & input fields

//  TODO: the hint for the result widget is hard coded, put it in the strings file

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView result;
    String errorMsg;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get a handle on the text fields
        etNum1 = (EditText) findViewById(R.id.num1);
        etNum2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
        errorMsg = getString(R.string.empty);
    }  //onCreate()

    // TODO: input validation: set text to show error
    public void addNums(View v) {
        String sNum1 = etNum1.getText().toString();
        String sNum2 = etNum2.getText().toString();
        if (validateInput(sNum1) && validateInput(sNum2)) {
            num1 = Double.parseDouble(sNum1);
            num2 = Double.parseDouble(sNum2);
            result.setText(Double.toString(num1 + num2));
        }
        else {
            result.setText(errorMsg);
        }
    }  //addNums()

    public void subtractNums(View v) {
        String sNum1 = etNum1.getText().toString();
        String sNum2 = etNum2.getText().toString();
        if (validateInput(sNum1) && validateInput(sNum2)) {
            num1 = Double.parseDouble(sNum1);
            num2 = Double.parseDouble(sNum2);
            result.setText(Double.toString(num1 - num2));
        }
        else {
            result.setText(errorMsg);
        }
    }   //subtractNums()

    public void multiplyNums(View v) {
        String sNum1 = etNum1.getText().toString();
        String sNum2 = etNum2.getText().toString();
        if (validateInput(sNum1) && validateInput(sNum2)) {
            num1 = Double.parseDouble(sNum1);
            num2 = Double.parseDouble(sNum2);
            result.setText(Double.toString(num1 * num2));
        }
        else {
            result.setText(errorMsg);
        }
    }   //multiplyNums()

    public void divideNums(View v) {
        String sNum1 = etNum1.getText().toString();
        String sNum2 = etNum2.getText().toString();
        if (validateInput(sNum1) && validateInput(sNum2)) {
            num1 = Double.parseDouble(sNum1);
            num2 = Double.parseDouble(sNum2);
            if (num2 == 0) {
                result.setText(getString(R.string.error_msg_zero));
            }
            else {
                result.setText(Double.toString(num1 / num2));
            }
        }
        else {
            result.setText(errorMsg);
        }
    }

    public void clearFields(View v) {
        etNum1.setText(getString(R.string.empty));
        etNum2.setText(getString(R.string.empty));
        result.setText(getString(R.string.default_result));
    }

    private boolean validateInput(String s) {
        boolean valid = false;
        try {
            Double.parseDouble(s);
            valid = true;
        }
        catch (NullPointerException npe) {
            errorMsg = getString(R.string.error_msg_empty);
        }
        catch (NumberFormatException nfe) {
            errorMsg = getString(R.string.error_msg_not_num);
        }
        return valid;
    }

}