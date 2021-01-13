package com.example.connect;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Main3Activity extends AppCompatActivity {
Button  select,upload,fetch;
TextView notification;
FirebaseStorage storage;
FirebaseDatabase database;
Uri pdfUri;
ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        storage=FirebaseStorage.getInstance();
        database= FirebaseDatabase.getInstance();
        select=findViewById(R.id.button6);
        upload=findViewById(R.id.button7);
        notification=findViewById(R.id.textView2);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Main3Activity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                {
                    selectPdf();
                }
                else
                    ActivityCompat.requestPermissions(Main3Activity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
            }
        });
              upload.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if(pdfUri!=null)
                      uploadFile(pdfUri);
                      else
                          Toast.makeText(Main3Activity.this,"select the file",Toast.LENGTH_SHORT).show();
                  }
              });


    }
private void uploadFile(Uri pdfUri)
{
    progressDialog=new ProgressDialog(this);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    progressDialog.setTitle("uploading file..");

    progressDialog.show();
    final String filename=System.currentTimeMillis()+"";
  StorageReference storageReference=storage.getReference();
    storageReference.child("Uploads").child(filename).putFile(pdfUri);


}
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }
        else
            Toast.makeText(Main3Activity.this, "please provide permission", Toast.LENGTH_SHORT).show();
    }

    private void selectPdf()
    {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==86 && resultCode==RESULT_OK && data!=null)
        {
           pdfUri=data.getData();
           notification.setText("file is selected"+data.getData().getLastPathSegment());
        }
        else
        {
            Toast.makeText(Main3Activity.this, "please select the file", Toast.LENGTH_SHORT).show();
        }
    }
}
