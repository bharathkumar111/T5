package com.example.connect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE_REQUEST = 234;
    private ImageView imageView;
    private Button b1, b2, b3;
    private Uri filepath;
    StorageReference riversRef;
    private StorageReference storageReference;
    FirebaseStorage firebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        storageReference = FirebaseStorage.getInstance().getReference();
        imageView = findViewById(R.id.imageView);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        StorageReference riversRef;


    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("ïmage/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select an image"), PICK_IMAGE_REQUEST);

    }

    private void uploadFile() {


        if (filepath != null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("uploading..");
            progressDialog.show();
            final String filename = System.currentTimeMillis() + "";
            StorageReference riversRef = storageReference.child("sport").child("filename");


            riversRef.putFile(filepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Get a URL to the uploaded content

                            progressDialog.dismiss();
                            Toast.makeText(Main4Activity.this, "file uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {


                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                    progressDialog.setMessage((int) progress + "% uploaded");
                }
            });
        } else {

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filepath = data.getData();
            try {


                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onClick(View view) {
        if (view == b1) {
            showFileChooser();
        } else if (view == b2) {
            uploadFile();
        } else if (view == b3) {
            download();
        }

    }

    private void download() {
        storageReference = firebaseStorage.getInstance().getReference();
        riversRef = storageReference.child("Uploads").child("ipl.pdf");
        riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                String url=uri.toString();
                downloadfile(Main4Activity.this,"ipl","",DIRECTORY_DOWNLOADS,url);
                Toast.makeText(getApplicationContext(),"successfully downloaded! see notification bar",Toast.LENGTH_LONG).show();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"not downloaded! error",Toast.LENGTH_LONG).show();

            }
        });
    }

public void downloadfile(Context context,String filename,String fileExtension,String destinationDirectory,String url)
        {
            DownloadManager downloadManager= (DownloadManager) context.

                    getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri=Uri.parse(url);
            DownloadManager.Request request=new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalFilesDir(context,destinationDirectory,filename+fileExtension);
            downloadManager.enqueue(request);


        }










    }

