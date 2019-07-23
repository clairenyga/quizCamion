package com.clairenyga.quizcamion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class PhotoActivity extends AppCompatActivity {

    /**private Button mPhotoButton;
    private ImageView mimageView;
    private File f;

    public File getAlbumDir()
    {

        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES
                ),
                "BAC/"
        );
        // Create directories if needed
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }

        return storageDir;
    }
    private File createImageFile() throws IOException {
        // Create an image file name

        String imageFileName =getAlbumDir().toString() +"/image.jpg";
        File image = new File(imageFileName);
        return image;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        mimageView=findViewById(R.id.imageview);
        mPhotoButton=findViewById(R.id.button_image);

        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    f = createImageFile();
                    Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent,0);
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        mimageView.setImageBitmap(bitmap);

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"clairenyga@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Prima poza");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");

        Uri uri = Uri.fromFile(f);
        i.putExtra(Intent.EXTRA_STREAM, uri);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(PhotoActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }*/

     private static final int CAMERA_REQUEST = 0;
    private ImageView mimageView;
    private File f;
    private Button mPhotoButton;
    public File getAlbumDir()
    {

        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES
                ),
                "BAC/"
        );
        // Create directories if needed
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }

        return storageDir;
    }
    private File createImageFile() throws IOException {
        // Create an image file name

        String imageFileName =getAlbumDir().toString() +"/image.jpg";
        File image = new File(imageFileName);
        return image;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        mimageView=findViewById(R.id.imageview);
        mPhotoButton=findViewById(R.id.button_image);
        //StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        //StrictMode.setVmPolicy(builder.build());
        mPhotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    f = createImageFile();
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            Bitmap photo = BitmapFactory.decodeFile(f.getAbsolutePath());
            mimageView.setImageBitmap(photo);

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"clairenyga@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Prima poza");
            i.putExtra(Intent.EXTRA_TEXT   , "body of email");

            Uri uri = Uri.fromFile(f);
            i.putExtra(Intent.EXTRA_STREAM, uri);
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(PhotoActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}


