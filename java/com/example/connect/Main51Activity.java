package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



        public class Main51Activity extends AppCompatActivity implements View.OnClickListener {
            EditText e1,e2,e3;
            Button b1,b2;
            SQLiteDatabase db=null;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main51);
                e1=findViewById(R.id.editText);
                e2=findViewById(R.id.editText2);
                e3=findViewById(R.id.editText3);
                b1=findViewById(R.id.button17);
                b2=findViewById(R.id.button18);
                b1.setOnClickListener(this);
                b2.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

                String name,age,add;
                name=e1.getText().toString();
                age=e2.getText().toString();
                add=e3.getText().toString();
                try
                {
                    db=this.openOrCreateDatabase("stud1",MODE_PRIVATE,null);
                    db.execSQL("create table  if not exists bk1(name varchar(20),phone varchar(20),comments varchar(20))");

                    if(v.getId()==b1.getId())
                    {
                        db.execSQL("insert into bk1" +
                                " values('"+name+"','"+age+"','"+add+"')");
                        Toast.makeText(getApplicationContext(),"submitted thank u! ",Toast.LENGTH_SHORT).show();
                    }
                    String all="";
                    if(v.getId()==b2.getId())

                    {
                        Cursor c=db.rawQuery("select * from bk1",null);

                        if(c!=null)

                        {
                            if(c.moveToFirst()) {
                                do {
                                    name=c.getString(c.getColumnIndex("name"));
                                    age=c.getString(c.getColumnIndex("phone"));
                                    add=c.getString(c.getColumnIndex("comments"));
                                    all=all+"you name is :"+name+"\n your age is\t\t"+age+"\nyour comment is : \t\t"+add+"\n";
                                    Toast.makeText(getApplicationContext(),all,Toast.LENGTH_LONG).show();
                                }while(c.moveToNext());


                            }
                        }
                    }
                }catch(SQLException sq)
                {
                    Toast.makeText(getApplicationContext(),"error ",Toast.LENGTH_SHORT).show();


                }
                finally {
                    if(db!=null)
                        db.close();
                }



            }
        }

