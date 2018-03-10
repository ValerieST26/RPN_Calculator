package com.rpn_calculator.valerie.rpn_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rpn_calculator.valerie.rpn_calculator.adapter.Operations;
import com.rpn_calculator.valerie.rpn_calculator.model.CalcStack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView vinput;
    CalcStack stack;
    String data ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stack = new CalcStack();
        findViewById(R.id.No0).setOnClickListener(this);
        findViewById(R.id.No1).setOnClickListener(this);
        findViewById(R.id.No2).setOnClickListener(this);
        findViewById(R.id.No3).setOnClickListener(this);
        findViewById(R.id.No4).setOnClickListener(this);
        findViewById(R.id.No5).setOnClickListener(this);
        findViewById(R.id.No6).setOnClickListener(this);
        findViewById(R.id.No7).setOnClickListener(this);
        findViewById(R.id.No8).setOnClickListener(this);
        findViewById(R.id.No9).setOnClickListener(this);
        findViewById(R.id.inputButton).setOnClickListener(this);
        findViewById(R.id.OpAdd).setOnClickListener(this);
        findViewById(R.id.OpSub).setOnClickListener(this);
        findViewById(R.id.OpTimes).setOnClickListener(this);
        findViewById(R.id.OpDivide).setOnClickListener(this);
        findViewById(R.id.OpResult).setOnClickListener(this);
        findViewById(R.id.ClearButtom).setOnClickListener(this);
        findViewById(R.id.myOperationList).setOnClickListener(this);
        //input= (EditText)findViewById(R.id.editText);
        vinput= findViewById(R.id.textView);

    }

    @Override
    public void onClick(View button) {
        String digit = ((Button)button).getText().toString();
        switch (digit) {
            case "Enter":
                if ((vinput.getText().toString()).isEmpty()){
                    Log.d("MainActivity","Empty String");
                }
                else{
                    vinput.setText(vinput.getText().toString() + " ");
                    Log.d("MainActivity", "Enter Click");
                }
                //Toast.makeText(this, "Explota", Toast.LENGTH_LONG).show();
                break;
            case "=":
                //Toast.makeText(this, "Explota", Toast.LENGTH_LONG).show();
                Log.d("MainActivity", "Equal Click");
                if ((vinput.getText().toString()).equals(" ") ||
                        (vinput.getText().toString().isEmpty())){
                    Log.d("MainActivity","Empty String");
                }else {
                    stack.operationsStack(digit);
                    vinput.setText(stack.operationsStack(vinput.getText().toString()));
                    stack.addToHistory(vinput.getText().toString());
                }
                break;
            case "C":
                Log.d("MainActivity", "Clear Click");
                String temp = vinput.getText().toString();
                if (temp.length() != 0)
                    vinput.setText(temp.substring(0, temp.length() - 1));
                Log.d("MainActivity", "Digit Deleted");
                break;
            case "Last Operations":
                Intent intent = new Intent(this, LastOperationsListView.class);
                String [] arr = new String[stack.getHistory().size()];
                arr =stack.getHistory().toArray(arr);
                intent.putExtra("List",arr);
                startActivity(intent);
                break;
            default:
                vinput.setText(vinput.getText().toString() + digit);
                Log.d("MainActivity", "Show Digid");
                break;
        }
        //return;
    }
}