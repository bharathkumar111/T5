package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main333Activity extends AppCompatActivity {
EditText e1,e2;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main333);
        e1=findViewById(R.id.editText6);
        e2=findViewById(R.id.editText7);
        b=findViewById(R.id.button22);
        String bk=e1.getText().toString();
        String pass=e2.getText().toString();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bk.equals("bharath\n")&& pass.equals("123\n"))
                {

                }
                else
                {
                    Intent i99=new Intent(Main333Activity.this,Main555Activity.class);
                    startActivity(i99);

                }
            }
        });

    }
}
