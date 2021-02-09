package com.example.tableappforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    private ListView listView;
    private EditText numberText;
    private Button submitButton;

    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        listView = findViewById(R.id.list_view);
        numberText = findViewById(R.id.enter_number);
        submitButton = findViewById(R.id.submit_btn);
        list = new ArrayList<>();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberText.getText().toString().trim().isEmpty()){
                    Toast.makeText(Dashboard.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
                else{
                    int getNum = Integer.parseInt(numberText.getText().toString().trim());
                    if (!list.isEmpty()){
                        list.clear();
                        printTable(getNum);
                    }
                    printTable(getNum);
                    closekeyboard();
                    numberText.getText().clear();
                }
            }
        });
    }

    private void printTable(int number) {
        for (int i = 1; i <= 10; i++){
            String result = number + "   X   " +i+ "  =  " +number * i;
            list.add(result);
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_list, R.id.text,list);
            listView.setAdapter(adapter);
        }

    }
    public void closekeyboard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}