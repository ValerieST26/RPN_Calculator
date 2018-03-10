package com.rpn_calculator.valerie.rpn_calculator.adapter;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Operations {

    List<String> History=new ArrayList<String>();
    Queue<String> queue = new LinkedList<String>();
    private double result;

    protected void OperationAdd(double num1, double num2) {
        result = num1 +num2;
        Log.d("Operations", "Addition Made");
    }

    protected void OperationSub(double num1, double num2){
        if (num2 > num1){
            result= num2-num1;
            Log.d("Operations", "Subtracts Made");
        }
        else {
            result= num1-num2;
            //Toast.makeText(this,"Negative Number", Toast.LENGTH_LONG).show();
            Log.e("Operations", "Numero negativo");
        }
    }

    protected void OperationTimes(double num1, double num2){
        result = num1 * num2;
        Log.d("Operations", "Times Made" );
    }

    protected void OperationDivide(double num1, double num2){
        if (num1 == 0||num2==0){
            Log.e("Operations", "Number 0 inserted - Operation Not Possible");
        }
        else {
            result = num2/num1;
            //java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("0.##");
            //result = decimalFormat.format(resul);
            //if (result=)
        }
    }

    protected Double getResult(){
        Log.d("Operations", "Get Result");
        return result;
    }

    public void addToHistory(String value) {
        queue.add(value);
        if (queue.size() == 6)
            queue.remove();
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < queue.size(); i++) {
            data.add(queue.peek());
            queue.add(queue.remove());
        }
        History=data;
    }

    public List<String> getHistory(){
        return History;
    }

}
