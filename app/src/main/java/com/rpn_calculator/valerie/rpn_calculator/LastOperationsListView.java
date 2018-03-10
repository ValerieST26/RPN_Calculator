package com.rpn_calculator.valerie.rpn_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;

public class LastOperationsListView extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_operations_list_view);

        ListView listView= findViewById(R.id.ListViewComponent);

        List<String> stringList = Arrays.asList(getIntent().getStringArrayExtra("List"));

        listView.setAdapter(new ArrayAdapter<>(this, R.layout.my_text_view,stringList));

    }
}