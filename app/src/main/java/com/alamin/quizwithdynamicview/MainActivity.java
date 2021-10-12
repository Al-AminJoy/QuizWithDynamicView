package com.alamin.quizwithdynamicview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    EditText ed;
    List<EditText> allEds = new ArrayList<EditText>();
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5,5,5,5);

        for (int i = 0; i < 5; i++) {
            textView = new TextView(MainActivity.this);
            textView.setText("Question No. "+i);
            textView.setPadding(10,20,10,10);
            linearLayout.addView(textView);

            ed = new EditText(MainActivity.this);
            allEds.add(ed);
            ed.setBackgroundResource(R.color.teal_200);
            ed.setHint("Type");
            ed.setId(i);
            ed.setPadding(10,20,10,10);
            ed.setLayoutParams(layoutParams);
            linearLayout.addView(ed);
        }
        button.setOnClickListener(v -> {
            for (int i = 0; i < allEds.size(); i++) {
                Toast.makeText(this, "Data of "+i+" : "+allEds.get(i).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}