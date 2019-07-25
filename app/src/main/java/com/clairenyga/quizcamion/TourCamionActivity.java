package com.clairenyga.quizcamion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.clairenyga.quizcamion.R;
//import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.Toast;
import com.clairenyga.quizcamion.model.Question;
import com.clairenyga.quizcamion.model.QuestionBank;
import com.clairenyga.quizcamion.MainActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import androidx.appcompat.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import static com.clairenyga.quizcamion.MainActivity.EXTRA_IMMATREMORQUE;
import static com.clairenyga.quizcamion.MainActivity.EXTRA_IMMATTRACTEUR;
import static com.clairenyga.quizcamion.MainActivity.EXTRA_IMMATVEHICULE;
import static com.clairenyga.quizcamion.MainActivity.EXTRA_NOM;
import static com.clairenyga.quizcamion.MainActivity.EXTRA_PRENOM;
import static com.clairenyga.quizcamion.MainActivity.EXTRA_VEHICULE;
import static com.clairenyga.quizcamion.MainActivity.TOUR_ACTIVITY_REQUEST_CODE;


public class TourCamionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private CheckBox mCheckBox4;
    private CheckBox mCheckBox5;
    private CheckBox mCheckBox6;
    private CheckBox mCheckBox7;
    private CheckBox mCheckBox8;
    private CheckBox mCheckBox9;
    private CheckBox mCheckBox10;
    private CheckBox mCheckBox11;
    private CheckBox mCheckBox12;
    private CheckBox mCheckBox13;
    private CheckBox mCheckBox14;
    private CheckBox mCheckBox15;
    private CheckBox mCheckBox16;
    private CheckBox mCheckBox17;
    private CheckBox mCheckBox18;
    private CheckBox mCheckBox19;
    private CheckBox mCheckBox20;
    private CheckBox mCheckBox21;
    private CheckBox mCheckBox22;
    private CheckBox mCheckBox23;
    private CheckBox mCheckBox24;
    private CheckBox mCheckBox25;
    private CheckBox mCheckBox26;
    private CheckBox mCheckBox27;
    private CheckBox mCheckBox28;
    private Button mNextButton;
    //private EditText mVoyant;


    private QuestionBank mQuestionBank;
    private List<Question> ListQuestions;
    private Question mCurrentQuestion;
    private CharSequence s;


    private int mScore;
    private int mNumberOfQuestions;
    private int mVehicule;
    public int mUrgence;
    private CharSequence mNom;
    private CharSequence mPrenom;
    private CharSequence mImmatTracteur;
    private CharSequence mImmatRemorque;
    private CharSequence mImmatVehicule;
    private int send;

    public int i, j, b;

    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";


    private boolean mEnableTouchEvents;

    public ArrayList<CheckBox> myArrayList = new ArrayList<>();
    public ArrayList<String>ListData=new ArrayList<>();
    public ArrayList<String>ListData2=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_camion);


        System.out.println("TourCamionActivity::onCreate()");

        //startQuiz();

        Intent TourActivityIntent=getIntent();
        mVehicule= getIntent().getIntExtra(MainActivity.EXTRA_VEHICULE,0);
        mNom=getIntent().getCharSequenceExtra(MainActivity.EXTRA_NOM);
        mPrenom=getIntent().getCharSequenceExtra(MainActivity.EXTRA_PRENOM);
        mImmatTracteur=getIntent().getCharSequenceExtra(MainActivity.EXTRA_IMMATTRACTEUR);
        mImmatRemorque=getIntent().getCharSequenceExtra(MainActivity.EXTRA_IMMATREMORQUE);
        mImmatVehicule=getIntent().getCharSequenceExtra(EXTRA_IMMATVEHICULE);


        if(mVehicule==1){
            mQuestionBank = this.generateQuestions1();
        }
        if(mVehicule==2){
            mQuestionBank = this.generateQuestions2();
        }
        if(mVehicule==3){
            mQuestionBank = this.generateQuestions3();
        }
        if(mVehicule==4){
            mQuestionBank = this.generateQuestions4();
        }
        if(mVehicule==5){
            mQuestionBank = this.generateQuestions5();
        }
        if(mVehicule==6){
            mQuestionBank = this.generateQuestions6();
        }
        if(mVehicule==7){
            mQuestionBank = this.generateQuestions7();
        }
        if(mVehicule==8) {
            mQuestionBank = this.generateQuestions8();
        }
        if(mVehicule==9){
            mQuestionBank = this.generateQuestions9();
        }


        if (savedInstanceState != null) {
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            //mScore = 0;
            if(mVehicule==1) {
                mNumberOfQuestions = 3;
            }
            if(mVehicule==2){
                mNumberOfQuestions=3;
            }
            if(mVehicule==3) {
                mNumberOfQuestions = 3;
            }
            if(mVehicule==4) {
                mNumberOfQuestions = 3;
            }
            if(mVehicule==5) {
                mNumberOfQuestions = 3;
            }
            if(mVehicule==6) {
                mNumberOfQuestions = 2;
            }
            if(mVehicule==7) {
                mNumberOfQuestions = 2;
            }
            if(mVehicule==8) {
                mNumberOfQuestions = 2;
            }
            if(mVehicule==9) {
                mNumberOfQuestions = 2;
            }
        }

        mEnableTouchEvents = true;


        // Wire widgets
        mQuestionTextView = findViewById(R.id.activity_tour_camion_question_txt);
        mCheckBox1 = findViewById(R.id.checkBox1);
        mCheckBox2 = findViewById(R.id.checkBox2);
        mCheckBox3 = findViewById(R.id.checkBox3);
        mCheckBox4 = findViewById(R.id.checkBox4);
        mCheckBox5 = findViewById(R.id.checkBox5);
        mCheckBox6 = findViewById(R.id.checkBox6);
        mCheckBox7 = findViewById(R.id.checkBox7);
        mCheckBox8 = findViewById(R.id.checkBox8);
        mCheckBox9 = findViewById(R.id.checkBox9);
        mCheckBox10 = findViewById(R.id.checkBox10);
        mCheckBox11 = findViewById(R.id.checkBox11);
        mCheckBox12 = findViewById(R.id.checkBox12);
        mCheckBox13 = findViewById(R.id.checkBox13);
        mCheckBox14 = findViewById(R.id.checkBox14);
        mCheckBox15 = findViewById(R.id.checkBox15);
        mCheckBox16 = findViewById(R.id.checkBox16);
        mCheckBox17 = findViewById(R.id.checkBox17);
        mCheckBox18 = findViewById(R.id.checkBox18);
        mCheckBox19 = findViewById(R.id.checkBox19);
        mCheckBox20 = findViewById(R.id.checkBox20);
        mCheckBox21 = findViewById(R.id.checkBox21);
        mCheckBox22 = findViewById(R.id.checkBox22);
        mCheckBox23 = findViewById(R.id.checkBox23);
        mCheckBox24 = findViewById(R.id.checkBox24);
        mCheckBox25 = findViewById(R.id.checkBox25);
        mCheckBox26 = findViewById(R.id.checkBox26);
        mCheckBox27 = findViewById(R.id.checkBox27);
        mCheckBox28 = findViewById(R.id.checkBox28);
        mNextButton = findViewById(R.id.activity_tour_camion_next_btn);
        //mVoyant = findViewById(R.id.activity_tour_camion_voyant_input);

        // Use the tag property to 'name' the buttons
        mCheckBox1.setTag(0);
        mCheckBox2.setTag(1);
        mCheckBox3.setTag(2);
        mCheckBox4.setTag(3);
        mCheckBox5.setTag(4);
        mCheckBox6.setTag(5);
        mCheckBox7.setTag(6);
        mCheckBox8.setTag(7);
        mCheckBox9.setTag(8);
        mCheckBox10.setTag(9);
        mCheckBox11.setTag(10);
        mCheckBox12.setTag(11);
        mCheckBox13.setTag(12);
        mCheckBox14.setTag(13);
        mCheckBox15.setTag(14);
        mCheckBox16.setTag(15);
        mCheckBox17.setTag(16);
        mCheckBox18.setTag(17);
        mCheckBox19.setTag(18);
        mCheckBox20.setTag(19);
        mCheckBox21.setTag(20);
        mCheckBox22.setTag(21);
        mCheckBox23.setTag(22);
        mCheckBox24.setTag(23);
        mCheckBox25.setTag(24);
        mCheckBox26.setTag(25);
        mCheckBox27.setTag(26);
        mCheckBox28.setTag(27);

        mCheckBox1.setOnClickListener(this);
        mCheckBox2.setOnClickListener(this);
        mCheckBox3.setOnClickListener(this);
        mCheckBox4.setOnClickListener(this);
        mCheckBox5.setOnClickListener(this);
        mCheckBox6.setOnClickListener(this);
        mCheckBox7.setOnClickListener(this);
        mCheckBox8.setOnClickListener(this);
        mCheckBox9.setOnClickListener(this);
        mCheckBox10.setOnClickListener(this);
        mCheckBox11.setOnClickListener(this);
        mCheckBox12.setOnClickListener(this);
        mCheckBox13.setOnClickListener(this);
        mCheckBox14.setOnClickListener(this);
        mCheckBox15.setOnClickListener(this);
        mCheckBox16.setOnClickListener(this);
        mCheckBox17.setOnClickListener(this);
        mCheckBox18.setOnClickListener(this);
        mCheckBox19.setOnClickListener(this);
        mCheckBox20.setOnClickListener(this);
        mCheckBox21.setOnClickListener(this);
        mCheckBox22.setOnClickListener(this);
        mCheckBox23.setOnClickListener(this);
        mCheckBox24.setOnClickListener(this);
        mCheckBox25.setOnClickListener(this);
        mCheckBox26.setOnClickListener(this);
        mCheckBox27.setOnClickListener(this);
        mCheckBox28.setOnClickListener(this);
        mNextButton.setOnClickListener(this);

        myArrayList.add(mCheckBox1);
        myArrayList.add(mCheckBox2);
        myArrayList.add(mCheckBox3);
        myArrayList.add(mCheckBox4);
        myArrayList.add(mCheckBox5);
        myArrayList.add(mCheckBox6);
        myArrayList.add(mCheckBox7);
        myArrayList.add(mCheckBox8);
        myArrayList.add(mCheckBox9);
        myArrayList.add(mCheckBox10);
        myArrayList.add(mCheckBox11);
        myArrayList.add(mCheckBox12);
        myArrayList.add(mCheckBox13);
        myArrayList.add(mCheckBox14);
        myArrayList.add(mCheckBox15);
        myArrayList.add(mCheckBox16);
        myArrayList.add(mCheckBox17);
        myArrayList.add(mCheckBox18);
        myArrayList.add(mCheckBox19);
        myArrayList.add(mCheckBox20);
        myArrayList.add(mCheckBox21);
        myArrayList.add(mCheckBox22);
        myArrayList.add(mCheckBox23);
        myArrayList.add(mCheckBox24);
        myArrayList.add(mCheckBox25);
        myArrayList.add(mCheckBox26);
        myArrayList.add(mCheckBox27);
        myArrayList.add(mCheckBox28);


        mNextButton.setEnabled(false);
        //mVoyant.setVisibility(View.GONE);
        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);
        super.onSaveInstanceState(outState);
    }


        @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        mEnableTouchEvents = false;
        mNextButton.setEnabled(false);
        //mVoyant.setVisibility(View.GONE);

        new Handler().postAtFrontOfQueue(new Runnable() {
            @Override
            public void run() {

                mEnableTouchEvents = true;
                mNextButton.setEnabled(true);

                mNextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // If this is the last question, ends the game.
                        // Else, display the next question.
                        if (--mNumberOfQuestions == 0) {
                            // End the game
                            endGame();
                        } else {
                            //startQuiz();
                            manageCheckbox();
                            mCurrentQuestion = mQuestionBank.getQuestion();
                            displayQuestion(mCurrentQuestion);
                            //
                            /**if((mVehicule==1||mVehicule==2||mVehicule==3||mVehicule==4||mVehicule==5)&& mNumberOfQuestions==2){
                                mCheckBox2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        mVoyant.setVisibility(View.VISIBLE);
                                        mEnableTouchEvents = true;
                                        mNextButton.setEnabled(true);
                                    }
                                });
                            }*/

                        }

                    }
                });


                /**if((mVehicule==6||mVehicule==7||mVehicule==8||mVehicule==9)&& mNumberOfQuestions==1){
                    mCheckBox2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mVoyant.setVisibility(View.VISIBLE);
                            mEnableTouchEvents = true;
                            mNextButton.setEnabled(true);
                        }
                    });
                }*/
                //

            }


        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);

    }

    private void endGame() {

        for(b=1;b<myArrayList.size();b++){
            if((myArrayList.get(b)).isChecked()){
                ListData2.add((String)(myArrayList.get(b)).getText());
            }
        }
    if(mVehicule==1||mVehicule==2||mVehicule==3||mVehicule==4||mVehicule==5){
        if((ListData2.isEmpty()==true)&&(ListData.isEmpty()==true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Vous n'avez signalé aucun problème sur votre remorque!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                            startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);

                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();

        }

        if((ListData2.isEmpty()==true)&&(ListData.isEmpty()==false)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Vous n'avez signalé aucun problème sur votre remorque!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            send=1;
                            Intent PhotoActivityIntent = new Intent(TourCamionActivity.this, PhotoActivity.class);
                            PhotoActivityIntent.putStringArrayListExtra("ListData",ListData);
                            PhotoActivityIntent.putStringArrayListExtra("ListData2",ListData2);
                            PhotoActivityIntent.putExtra("mUrgence",mUrgence);
                            PhotoActivityIntent.putExtra("mVehicule",mVehicule);
                            PhotoActivityIntent.putExtra("mNom",mNom);
                            PhotoActivityIntent.putExtra("mPrenom",mPrenom);
                            PhotoActivityIntent.putExtra("mImmatTracteur",mImmatTracteur);
                            PhotoActivityIntent.putExtra("mImmatRemorque",mImmatRemorque);
                            PhotoActivityIntent.putExtra("mImmatVehicule",mImmatVehicule);
                            PhotoActivityIntent.putExtra("send",send);
                            startActivityForResult(PhotoActivityIntent,0);
                            //sendEmail();
                            finish();
                        }
                    })
                    .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                            startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);

                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();

        }

        if((ListData.isEmpty()==false)&&(ListData2.isEmpty()==false)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Voici les problèmes signalés sur votre remorque:")

                    .setMessage("" +
                            "" + ListData2)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            send=1;
                            Intent PhotoActivityIntent = new Intent(TourCamionActivity.this, PhotoActivity.class);
                            PhotoActivityIntent.putStringArrayListExtra("ListData",ListData);
                            PhotoActivityIntent.putStringArrayListExtra("ListData2",ListData2);
                            PhotoActivityIntent.putExtra("mUrgence",mUrgence);
                            PhotoActivityIntent.putExtra("mVehicule",mVehicule);
                            PhotoActivityIntent.putExtra("mNom",mNom);
                            PhotoActivityIntent.putExtra("mPrenom",mPrenom);
                            PhotoActivityIntent.putExtra("mImmatTracteur",mImmatTracteur);
                            PhotoActivityIntent.putExtra("mImmatRemorque",mImmatRemorque);
                            PhotoActivityIntent.putExtra("mImmatVehicule",mImmatVehicule);
                            PhotoActivityIntent.putExtra("send",send);
                            startActivityForResult(PhotoActivityIntent,0);
                            //sendEmail();
                            finish();
                        }
                    })
                    .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.clear();
                            Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                            startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);

                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
        if((ListData.isEmpty()==true)&&(ListData2.isEmpty()==false)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Voici les problèmes signalés sur votre remorque:")

                    .setMessage("" +
                            "" + ListData2)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            send=1;
                            Intent PhotoActivityIntent = new Intent(TourCamionActivity.this, PhotoActivity.class);
                            PhotoActivityIntent.putStringArrayListExtra("ListData",ListData);
                            PhotoActivityIntent.putStringArrayListExtra("ListData2",ListData2);
                            PhotoActivityIntent.putExtra("mUrgence",mUrgence);
                            PhotoActivityIntent.putExtra("mVehicule",mVehicule);
                            PhotoActivityIntent.putExtra("mNom",mNom);
                            PhotoActivityIntent.putExtra("mPrenom",mPrenom);
                            PhotoActivityIntent.putExtra("mImmatTracteur",mImmatTracteur);
                            PhotoActivityIntent.putExtra("mImmatRemorque",mImmatRemorque);
                            PhotoActivityIntent.putExtra("mImmatVehicule",mImmatVehicule);
                            PhotoActivityIntent.putExtra("send",send);
                            startActivityForResult(PhotoActivityIntent,0);
                            //sendEmail();
                            finish();
                        }
                    })
                    .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.clear();
                            Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                            startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);

                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
    }
    else{
        if(ListData2.isEmpty()==true){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Vous n'avez signalé aucun problème sur votre véhicule!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                            startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();

        }

        if(ListData2.isEmpty()==false){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Voici les problèmes signalés sur votre véhicule:")
                    .setMessage("" +
                            "" + ListData2)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            send=2;
                            Intent PhotoActivityIntent = new Intent(TourCamionActivity.this, PhotoActivity.class);
                            PhotoActivityIntent.putStringArrayListExtra("ListData",ListData);
                            PhotoActivityIntent.putStringArrayListExtra("ListData2",ListData2);
                            PhotoActivityIntent.putExtra("mUrgence",mUrgence);
                            PhotoActivityIntent.putExtra("mVehicule",mVehicule);
                            PhotoActivityIntent.putExtra("mNom",mNom);
                            PhotoActivityIntent.putExtra("mPrenom",mPrenom);
                            PhotoActivityIntent.putExtra("mImmatTracteur",mImmatTracteur);
                            PhotoActivityIntent.putExtra("mImmatRemorque",mImmatRemorque);
                            PhotoActivityIntent.putExtra("mImmatVehicule",mImmatVehicule);
                            PhotoActivityIntent.putExtra("send",send);
                            startActivityForResult(PhotoActivityIntent,0);
                            //sendEmail2();
                            finish();
                        }
                    })
                    .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.clear();
                            Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                            startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);

                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
    }


    }



    private void displayQuestion(final Question question) {
        mQuestionTextView.setText(question.getQuestion());

        for (j = 0; j < myArrayList.size(); j++) {
            if (question.getChoiceList().get(j) != null) {
                myArrayList.get(j).setVisibility(View.VISIBLE);
                (myArrayList.get(j)).setText(question.getChoiceList().get(j));



            } else {
                myArrayList.get(j).setVisibility(View.GONE);
            }

        }


    }

    private QuestionBank generateQuestions1() {
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null,null));
     Question question3 = new Question("Vérification de l'état de la remorque bachée",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Ailes droite endommagées","Ailes gauche endommagées","Bâche endommagée",
                       "Les portes ne se ferment pas correctement","Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                        null,null,null,null,null,null,null,null,null,null,null));


        return new QuestionBank(Arrays.asList(question1,question2,question3));
    }


    private QuestionBank generateQuestions2() {
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null,null));

        Question question3 = new Question("Vérification de l'état de la remorque avec hayon",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Ailes droite endommagées","Ailes gauche endommagées","Bâche endommagée",
                       "Les portes ne se ferment pas correctement","Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                             "Validation du Hayon expiré","Fuite d'huile au niveau du hayon",null,null,null,null,null,null,null,null,null));


        return new QuestionBank(Arrays.asList(question1,question2,question3));
    }

    private QuestionBank generateQuestions3(){
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null,null));
     Question question3 = new Question("Vérification de l'état de la remorque benne",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Ailes droite endommagées","Ailes gauche endommagées","Bâche endommagée",
                      "Les portes ne se ferment pas correctement","Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                        null,null,null,null,null,null,null,null,null,null,null,null));

        return new QuestionBank(Arrays.asList(question1,question2,question3));

    }

    private QuestionBank generateQuestions4(){
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null,null));
     Question question3 = new Question("Vérification de l'état de la remorque porte-conteneur",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Ailes droite endommagées","Ailes gauche endommagées",
                            "Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                            "Twistlock manquant","Prise conteneur manquante",null,null,null,null,null,null,null,null,null,null,null));
        return new QuestionBank(Arrays.asList(question1,question2,question3));

    }

    private QuestionBank generateQuestions5(){
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null,null));
     Question question3 = new Question("Vérification de l'état de la remorque citerne",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Ailes droite endommagées","Ailes gauche endommagées","Cône de sécurité manquant",
                       "Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                        null,null,null,null,null,null,null,null,null,null,null,null));
        return new QuestionBank(Arrays.asList(question1,question2,question3));

    }

    private QuestionBank generateQuestions6(){
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état de la toupie",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée","Truelle manquante","Massette manquante","Brosse de lavage manquante","Girophare cassé",
                     "Flacheur cassé","Bip de recul défaillant","Caméra de recul cassée"));

        return new QuestionBank(Arrays.asList(question1,question2));

    }


   private QuestionBank generateQuestions7(){
       Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
               null,null,null,null,null,null,null,null,null));
       Question question2=new Question("Vérification de l'état du porte-voiture",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                               "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                    "Aile droite endommagée","Aile gauche endommagée","Sangles manquantes","Cale manquante","Mauvais fonctionnement des plateaux",null,null,null,null));
       return new QuestionBank(Arrays.asList(question1,question2));

    }

    private QuestionBank generateQuestions8(){
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état du Camion Grue",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée","Validation de la grue expirée","Girophare cassé","Bip de recule défaillant","Caméra de recul cassée","Fuite sur la grue",null,null));
        return new QuestionBank(Arrays.asList(question1,question2));
    }


    private QuestionBank generateQuestions9(){
        Question question1=new Question("Est-ce que votre camion est en état de rouler?",Arrays.asList("Oui","Non",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null));
        Question question2=new Question("Vérification de l'état du porteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","Présence d'hernies","Fuite d'huile","Fuite d'eau","Fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                 "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                 "Aile droite endommagée","Aile gauche endommagée","Les portes ne se ferment pas correctement","Hayon défaillant","Télécommande du hayon manquante","Clé hayon manquante","Cône de sécurité manquant",
                         "Validation du Hayon expiré","Fuite d'huile au niveau du hayon"));
        return new QuestionBank(Arrays.asList(question1,question2));
    }

    private void manageCheckbox() {
        //mVoyant.setVisibility(View.GONE);

        if((mVehicule==1||mVehicule==2||mVehicule==3||mVehicule==4||mVehicule==5)&& mNumberOfQuestions==2){
            if(myArrayList.get(0).isChecked()){
                mUrgence=0;
            }
            else{
                mUrgence=1;
            }
            startQuiz();
        }
        if((mVehicule==6||mVehicule==7||mVehicule==8||mVehicule==9)&&mNumberOfQuestions==1){
            if(myArrayList.get(0).isChecked()){
                mUrgence=0;
            }
            else{
                mUrgence=1;
            }
            startQuiz();
        }

        if((mVehicule==1||mVehicule==2||mVehicule==3||mVehicule==4||mVehicule==5)&& mNumberOfQuestions==1){
            remorqueQuiz();
            for(b=1;b<myArrayList.size();b++){
                if((myArrayList.get(b)).isChecked()){
                    ListData.add((String)(myArrayList.get(b)).getText());
                }
            }
            if(ListData.isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Vous n'avez signalé aucun problème sur votre tracteur!")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ListData.clear();
                                Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                                startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);

                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            }
            else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Voici les problèmes signalés sur le tracteur:")
                        .setMessage("" +
                                "" + ListData)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }

                        })
                        .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ListData.clear();
                                Intent MainActivityIntent = new Intent(TourCamionActivity.this, MainActivity.class);
                                startActivityForResult(MainActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);

                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            }
        }


        for(i =0; i<myArrayList.size();i++) {
        (myArrayList.get(i)).setChecked(false);
        mNextButton.setEnabled(false);

    }

}
    private void startQuiz(){
        if(mVehicule==1||mVehicule==2||mVehicule==3||mVehicule==4||mVehicule==5||mVehicule==6) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("IMPORTANT:")
                    .setMessage("Pour ce tracteur, vous devez impérativement vérifier que vous êtes en possession de: " +
                            "la carte grise, la liscence de transport, la taxe à l'essieu, l'assurance et le PV des mines (si le véhicule est luxembourgeois)")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
        if(mVehicule==7){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("IMPORTANT:")
                    .setMessage("Pour ce véhicule, vous devez impérativement vérifier que vous êtes en possession de: " +
                            "la carte grise, la liscence de transport, la taxe à l'essieu, l'assurance et le PV des mines (si le véhicule est luxembourgeois)")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
        if(mVehicule==8){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("IMPORTANT:")
                    .setMessage("Pour ce véhicule, vous devez impérativement vérifier que vous êtes en possession de: " +
                            "la carte grise, la liscence de transport, la taxe à l'essieu, l'assurance, le certificat de contrôle de la grue et le PV des mines (si le véhicule est luxembourgeois)")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
        if(mVehicule==9){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("IMPORTANT:")
                    .setMessage("Pour ce véhicule, vous devez impérativement vérifier que vous êtes en possession de: " +
                            "la carte grise, la liscence de transport, la taxe à l'essieu, l'assurance, le certificat de contrôle du hayon et le PV des mines (si le véhicule est luxembourgeois)")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
    }

    private void remorqueQuiz(){
        if(mVehicule==1||mVehicule==3||mVehicule==4||mVehicule==5){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("IMPORTANT:")
                    .setMessage("Pour ce type de remorque, vous devez impérativement vérifier que vous êtes en possession de: " +
                            "la carte grise, l'assurance et le PV des mines (si le véhicule est luxembourgeois)" )
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }
        if(mVehicule==2){
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle("Avez-vous votre clé hayon?")
                    .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.add("clé hayon manquante");
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle("Avez-vous votre télécommande hayon?")
                    .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.add("télécommande hayon manquante");
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
            AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
            builder4.setTitle("Avez-vous vos cônes de sécurité?")
                    .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.add("cônes de sécurité manquants");
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
            AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
            builder5.setTitle("Est-ce que votre hayon fonctionne?")
                    .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.add("hayon défaillant");
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
            AlertDialog.Builder builder6 = new AlertDialog.Builder(this);
            builder6.setTitle("Est-ce que votre alarme fonctionne?")
                    .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ListData2.add("alarme défaillante");
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("IMPORTANT:")
                    .setMessage("Pour ce type de remorque, vous devez impérativement vérifier que vous êtes en possession de: " +
                            "la carte grise, l'assurance, le certificat de contrôle du hayon et le PV des mines (si le véhicule est luxembourgeois)" )
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        }

    }

    /**protected void sendEmail() {
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
            }
            if(mUrgence==0){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                        "Cependant, sur le tracteur "+mImmatTracteur+" les problèmes sont: "+ListData+". Et sur la remorque "+mImmatRemorque+
                        " les problèmes sont: "+ListData2+".");
            }
        }
        if((ListData.isEmpty()==false)&&(ListData2.isEmpty()==true)){
            if(mUrgence==1){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "URGENCE CAMION");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et  mon camion n'est pas en état de rouler. " +
                        "Sur le tracteur "+mImmatTracteur+" les problèmes sont: "+ListData+".");
            }
            if(mUrgence==0){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                        "Cependant, sur le tracteur "+mImmatTracteur+" les problèmes sont: "+ListData+".");
            }
        }
        if((ListData.isEmpty()==true)&&(ListData2.isEmpty()==false)){
            if(mUrgence==1){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "URGENCE CAMION");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et  mon camion n'est pas en état de rouler. " +
                        "Sur la remorque "+mImmatRemorque+" les problèmes sont: "+ListData2+".");
            }
            if(mUrgence==0){
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                        "Cependant, sur la remorque "+mImmatRemorque+" les problèmes sont: "+ListData2+".");
            }
        }

        try {
            startActivity(Intent.createChooser(emailIntent, "Comment envoyer le mail?"));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(TourCamionActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
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
        }
        if(mUrgence==0){
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problème véhicule");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Bonjour, je suis "+mNom+" "+mPrenom+" et mon camion est en état de rouler. " +
                    "Cependant, sur le véhicule "+mImmatVehicule+" les problèmes sont: "+ListData2+".");
        }

        try {
            startActivity(Intent.createChooser(emailIntent, "Comment envoyer le mail?"));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(TourCamionActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }/*

   /** private void VoyantCheck(){
        if((mVehicule==1||mVehicule==2||mVehicule==3||mVehicule==4||mVehicule==5)&& mNumberOfQuestions==2){
            mCheckBox3.setVisibility(View.GONE);
            mCheckBox2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCheckBox3.setVisibility(View.VISIBLE);
                }
            });
        }
    }*/


    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("TourCamionActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("TourCamionActivity::onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("TourCamionActivity::onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("TourCamionActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("TourCamionActivity::onDestroy()");

    }
}
