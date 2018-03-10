package com.rpn_calculator.valerie.rpn_calculator.model;

import android.util.Log;
import com.rpn_calculator.valerie.rpn_calculator.adapter.Operations;
import java.util.Stack;


public class CalcStack extends Operations {

    private Stack<Double> stack;

    public CalcStack() {
        this.stack = new Stack<>();
        Log.d("CalcStack","Instance CalcStack: Done");
    }

    public String operationsStack(String input) {
        double acc = 0;
        String[] part = input.split(" ");
        for (String dig : part) {
            try {
                double temp = Double.parseDouble(dig);
                stack.push(temp);
                Log.d("CalcStack.opStack","PUSH");
            } catch (Exception e) {
                if(stack.size() >= 2) {
                    switch (dig) {
                        case "+":
                            OperationAdd((Double) stack.pop(), (Double) stack.pop());
                            Log.d("CalcStack.opStack","Add DONE");
                            stack.push(getResult());
                            Log.d("CalcStack.opStack","PUSH Result");
                            break;
                        case "-":
                            OperationSub((Double) stack.pop(), (Double) stack.pop());
                            Log.d("CalcStack.opStack","Sub DONE");
                            stack.push(getResult());
                            Log.d("CalcStack.opStack","PUSH Result");
                            break;
                        case "x":
                            OperationTimes((Double) stack.pop(), (Double) stack.pop());
                            Log.d("CalcStack.opStack","Sub DONE");
                            stack.push(getResult());
                            Log.d("CalcStack.opStack","PUSH Result");
                            break;
                        case "÷":
                            OperationDivide((Double) stack.pop(), (Double) stack.pop());
                            Log.d("CalcStack.opStack","Sub DONE");
                            stack.push(getResult());
                            Log.d("CalcStack.opStack","PUSH Result");
                            break;
                        default:
                            Log.d("CalcStack.opStack","ERROR IN STACK");
                            return null;
                    }
                }
                else return null;
            }
            acc = getResult();
            Log.d("CalcStack.opStack","Set acc= Result");
        }
        Log.d("CalcStack.opStack","Return Result");
        return Double.toString(acc);
    }
}
