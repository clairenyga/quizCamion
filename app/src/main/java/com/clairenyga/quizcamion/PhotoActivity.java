package com.clairenyga.quizcamion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PhotoActivity extends AppCompatActivity {

    private static final int RETOUR_PRENDRE_PHOTO=1;

    private Button btnPrendrePhoto;
    private ImageView imgAffichePhoto;
    private String photoPath =null;

    private int mVehicule;
    private CharSequence mNom;
    private CharSequence mPrenom;
    private CharSequence mImmatTracteur;
    private CharSequence mImmatRemorque;
    private CharSequence mImmatVehicule;
    private List<String> ListData;
    private List<String> ListData2;
    private int mUrgence;
    private int send;
    private File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Intent PhotoActivityIntent=getIntent();
        ListData=getIntent().getStringArrayListExtra("ListData");
        ListData2=getIntent().getStringArrayListExtra("ListData2");
        mUrgence=getIntent().getIntExtra("mUrgence",0);
        mVehicule= getIntent().getIntExtra("mVehicule",0);
        mNom=getIntent().getCharSequenceExtra("mNom");
        mPrenom=getIntent().getCharSequenceExtra("mPrenom");
        mImmatTracteur=getIntent().getCharSequenceExtra("mImmatTracteur");
        mImmatRemorque=getIntent().getCharSequenceExtra("mImmatRemorque");
        mImmatVehicule=getIntent().getCharSequenceExtra("mImmatVehicule");
        send=getIntent().getIntExtra("send",0);
        initActivity();

    }

    private void initActivity(){
        btnPrendrePhoto=findViewById(R.id.btnPrendrePhoto);
        imgAffichePhoto=findViewById(R.id.imgAffichePhoto);
        createOnClicBtnPrendrePhoto();
    }

    private void createOnClicBtnPrendrePhoto(){
        btnPrendrePhoto.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                prendreUnePhoto();
            }
        });

    }

    private void prendreUnePhoto(){
        Intent intent4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent4.resolveActivity(getPackageManager()) !=null){
            String time;
            time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File photoDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            try {
                photoFile=File.createTempFile("photo"+time,".jpg",photoDir);
                photoPath=photoFile.getAbsolutePath();
                Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                        photoFile);
                intent4.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(intent4,RETOUR_PRENDRE_PHOTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RETOUR_PRENDRE_PHOTO&&resultCode==RESULT_OK){
            Bitmap image = BitmapFactory.decodeFile(photoPath);
            imgAffichePhoto.setImageBitmap(image);
            if(send==1){
                sendEmail();
            }
            if(send==2){
                sendEmail2();
            }

        }
    }
    protected void sendEmail() {
        Log.i("Comment envoyer le mail", "");
        String[]TO={"romain.jacquemart@di-egidio.com","yasin.gurbuz@di-egidio.com","franco.dicerto@di-egidio.com","atelier@di-egidio.com"};
        String[] CC = {"gauthier.lesser@di-egidio.com"};
        String[]CC2={"gauthier.lesser@di-egidio.com","gregory.imhoff@di-egidio.com"};
        String[]CC3={"gauthier.lesser@di-egidio.com","gauthier.laborde@di-egidio.com","vincent.lepetit@di-egidio.com"};
        String[]CC4 = {"gauthier.laborde@di-egidio.com"};
        String[]CC5={"gauthier.lesser@di-egidio.com","vincent.lepetit@di-egidio.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        if(mVehicule==1){
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
        }
        if(mVehicule==2){
            emailIntent.putExtra(Intent.EXTRA_CC, CC2);
        }
        if(mVehicule==3){
            emailIntent.putExtra(Intent.EXTRA_CC, CC3);
        }
        if(mVehicule==4){
            emailIntent.putExtra(Intent.EXTRA_CC, CC4);
        }
        if(mVehicule==5){
            emailIntent.putExtra(Intent.EXTRA_CC, CC5);
        }
        if((ListData.isEmpty()==false)&&(ListData2.isEmpty()==false)){
            if(mUrgence==1) {
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "URGENCE CAMION");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis " + mNom + " " + mPrenom + " et  mon camion n'est pas en état de rouler. " +
                        "Sur le tracteur " + mImmatTracteur + " les problèmes sont: " + ListData + ". Sur la remorque " + mImmatRemorque +
                        " les problèmes sont: " + ListData2 + ".");
                Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                        photoFile);

                emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
            }
            if(mUrgence==0){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                        "Cependant, sur le tracteur "+mImmatTracteur+" les problèmes sont: "+ListData+". Et sur la remorque "+mImmatRemorque+
                        " les problèmes sont: "+ListData2+".");
                Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                        photoFile);

                emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
            }
        }
        if((ListData.isEmpty()==false)&&(ListData2.isEmpty()==true)){
            if(mUrgence==1){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "URGENCE CAMION");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et  mon camion n'est pas en état de rouler. " +
                        "Sur le tracteur "+mImmatTracteur+" les problèmes sont: "+ListData+".");
                Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                        photoFile);

                emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
            }
            if(mUrgence==0){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                        "Cependant, sur le tracteur "+mImmatTracteur+" les problèmes sont: "+ListData+".");
                Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                        photoFile);

                emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
            }
        }
        if((ListData.isEmpty()==true)&&(ListData2.isEmpty()==false)){
            if(mUrgence==1){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "URGENCE CAMION");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et  mon camion n'est pas en état de rouler. " +
                        "Sur la remorque "+mImmatRemorque+" les problèmes sont: "+ListData2+".");
                Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                        photoFile);

                emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
            }
            if(mUrgence==0){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                        "Cependant, sur la remorque "+mImmatRemorque+" les problèmes sont: "+ListData2+".");
                Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                        photoFile);

                emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
            }
        }

        try {
            startActivity(Intent.createChooser(emailIntent, "Comment envoyer le mail?"));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(PhotoActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void sendEmail2() {
        Log.i("Comment envoyer le mail", "");
        String[]TO={"romain.jacquemart@di-egidio.com","yasin.gurbuz@di-egidio.com","franco.dicerto@di-egidio.com","atelier@di-egidio.com"};
        String[]CC = {"gauthier.laborde@di-egidio.com"};
        String[]CC2={"gauthier.lesser@di-egidio.com","vincent.lepetit@di-egidio.com"};
        String[]CC3={"gauthier.lesser@di-egidio.com","gauthier.laborde@di-egidio.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        if(mVehicule==6||mVehicule==7){
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
        }
        if(mVehicule==8){
            emailIntent.putExtra(Intent.EXTRA_CC, CC2);
        }
        if(mVehicule==9){
            emailIntent.putExtra(Intent.EXTRA_CC, CC3);
        }
        if(mUrgence==1){
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "URGENCE CAMION");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion n'est pas en état de rouler. " +
                    "Sur le véhicule "+mImmatVehicule+" les problèmes sont: "+ListData2+".");
            Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                    photoFile);

            emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
        }
        if(mUrgence==0){
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                    "Cependant, sur le véhicule "+mImmatVehicule+" les problèmes sont: "+ListData2+".");
            Uri photoUri=FileProvider.getUriForFile(PhotoActivity.this,PhotoActivity.this.getApplicationContext().getPackageName()+".provider",
                    photoFile);

            emailIntent.putExtra(Intent.EXTRA_STREAM,photoUri);
        }

        try {
            startActivity(Intent.createChooser(emailIntent, "Comment envoyer le mail?"));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(PhotoActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("PhotoActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("PhotoActivity::onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("PhotoActivity::onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("PhotoActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("PhotoActivity::onDestroy()");

    }
}




