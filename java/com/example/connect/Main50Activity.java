package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main50Activity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main50);
        b1=findViewById(R.id.button4);
        b2=findViewById(R.id.button5);
        b3=findViewById(R.id.button8);
        b4=findViewById(R.id.button11);
        b5=findViewById(R.id.button9);
        b6=findViewById(R.id.button10);
        b7=findViewById(R.id.button12);
        b8=findViewById(R.id.button13);
        b9=findViewById(R.id.button14);
        b10=findViewById(R.id.button15);
        b11=findViewById(R.id.button16);
        b21=findViewById(R.id.button21);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main50Activity.this,Main2Activity.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Main50Activity.this,Main22Activity.class);
                startActivity(i2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i22=new Intent(Main50Activity.this,Main23Activity.class);
                startActivity(i22);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Main50Activity.this,Main24Activity.class);
                startActivity(i3);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(Main50Activity.this,Main27Activity.class);
                startActivity(i4);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Main50Activity.this,Main26Activity.class);
                startActivity(i5);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(Main50Activity.this,Main29Activity.class);
                startActivity(i6);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i66=new Intent(Main50Activity.this,Main25Activity.class);
                startActivity(i66);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i66=new Intent(Main50Activity.this,Main28Activity.class);
                startActivity(i66);
            }
        });





        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i66=new Intent(Main50Activity.this,Main4Activity.class);
                startActivity(i66);
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i666=new Intent(Main50Activity.this,Main51Activity.class);
                startActivity(i666);
            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6661=new Intent(Main50Activity.this,Main333Activity.class);
                startActivity(i6661);
            }
        });





    }
}
