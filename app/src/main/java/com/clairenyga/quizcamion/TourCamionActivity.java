package com.clairenyga.quizcamion;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import androidx.appcompat.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import static com.clairenyga.quizcamion.MainActivity.EXTRA_VEHICULE;


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
    private Button mNextButton;


    private QuestionBank mQuestionBank;
    private List<Question> ListQuestions;
    private Question mCurrentQuestion;
    private CharSequence s;


    private int mScore;
    private int mNumberOfQuestions;
    private int mVehicule;

    public int i, j, b;

    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";


    private boolean mEnableTouchEvents;

    public ArrayList<CheckBox> myArrayList = new ArrayList<>();
    public ArrayList<String>ListData=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_camion);

        System.out.println("TourCamionActivity::onCreate()");

        startQuiz();

        Intent TourActivityIntent=getIntent();
        mVehicule= getIntent().getIntExtra(MainActivity.EXTRA_VEHICULE,0);

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
            //mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            //mScore = 0;
            if(mVehicule==1) {
                mNumberOfQuestions = 2;
            }
            if(mVehicule==2){
                mNumberOfQuestions=2;
            }
            if(mVehicule==3) {
                mNumberOfQuestions = 2;
            }
            if(mVehicule==4) {
                mNumberOfQuestions = 2;
            }
            if(mVehicule==5) {
                mNumberOfQuestions = 2;
            }
            if(mVehicule==6) {
                mNumberOfQuestions = 1;
            }
            if(mVehicule==7) {
                mNumberOfQuestions = 1;
            }
            if(mVehicule==8) {
                mNumberOfQuestions = 1;
            }
            if(mVehicule==9) {
                mNumberOfQuestions = 1;
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
        mNextButton = findViewById(R.id.activity_tour_camion_next_btn);

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


        mNextButton.setEnabled(false);
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

        /**if (mQuestionBank.mNextQuestionIndex == 2) {
            Toast.makeText(this, "N'oubliez pas de vérifier le chargement avant de prendre la route!", Toast.LENGTH_LONG).show();
        }*/


        mEnableTouchEvents = false;
        mNextButton.setEnabled(false);

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
                            manageCheckbox();
                            mCurrentQuestion = mQuestionBank.getQuestion();
                            displayQuestion(mCurrentQuestion);


                        }

                    }
                });


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
                ListData.add((String)(myArrayList.get(b)).getText());
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Voici les problèmes signalés:")
                //.setMessage("Your score is " + mScore)
                .setMessage("" +
                        ""+ListData)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // End the activity
                        Intent intent = new Intent();
                        //intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }

    private void startQuiz(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("IMPORATNT:")
                .setMessage("Afin de répondre correctement au questionnaire, vous devez faire un tour complet du véhicule, y compris regarder en dessous de celui-ci avant de prendre la route." +
                "De plus, vous devez impérativement vérifier que vous êtes en possession:" +
                "De la carte grise du tracteur,..." )
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
        Question question1=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null));
     Question question2 = new Question("Vérification de l'état de la remorque bachée",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Aile droite endommagée","Aile gauche endommagée","Bache endommagée",
                       "Les portes ne se ferment pas correctement","Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                        null,null,null,null,null,null,null,null,null,null));


        return new QuestionBank(Arrays.asList(question1,question2));
    }


    private QuestionBank generateQuestions2() {
        Question question1=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null));

        Question question2 = new Question("Vérification de l'état de la remorque avec hayon",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Aile droite endommagée","Aile gauche endommagée","Bache endommagée",
                       "Les portes ne se ferment pas correctement","Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                             "Hayon défaillant","Télécommande du hayon manquante","Clé hayon manquante","Cône de sécurité manquant","Validation du Hayon expiré",
                             "Il y a une fuite d'huile au niveau du hayon",null,null,null,null));


        return new QuestionBank(Arrays.asList(question1,question2));
    }

    private QuestionBank generateQuestions3(){
        Question question1=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null));
     Question question2 = new Question("Vérification de l'état de la remorque benne",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Aile droite endommagée","Aile gauche endommagée","Bache endommagée",
                      "Les portes ne se ferment pas correctement","Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                        null,null,null,null,null,null,null,null,null,null,null));

        return new QuestionBank(Arrays.asList(question1,question2));

    }

    private QuestionBank generateQuestions4(){
        Question question1=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null));
     Question question2 = new Question("Vérification de l'état de la remorque porte-conteneur",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Aile droite endommagée","Aile gauche endommagée",
                            "Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                            "Twistlock manquant","Prise conteneur manquante",null,null,null,null,null,null,null,null,null,null));
        return new QuestionBank(Arrays.asList(question1,question2));

    }

    private QuestionBank generateQuestions5(){
        Question question1=new Question("Vérification de l'état du tracteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null));
     Question question2 = new Question("Vérification de l'état de la remorque citerne",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé",
                                  "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé","Aile droite endommagée","Aile gauche endommagée","Cône de sécurité manquant",
                       "Bare anti-encastrement arrière endommagée","Bare anti-encastrement droite endommagée","Bare anti-encastrement gauche endommagée",
                        null,null,null,null,null,null,null,null,null,null,null));
        return new QuestionBank(Arrays.asList(question1,question2));

    }

    private QuestionBank generateQuestions6(){
        Question question1=new Question("Vérification de l'état de la toupie",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée","Truelle manquante","Massette manquante","Brosse de lavage manquante","Girophare cassé",
                     "Flacheur cassé","Bip de recul défaillant"));

        return new QuestionBank(Arrays.asList(question1));

    }


   private QuestionBank generateQuestions7(){
       Question question1=new Question("Vérification de l'état du porte-voiture",
                Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                               "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                    "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                    "Aile droite endommagée","Aile gauche endommagée","Sangles manquantes","Cale manquante","Mauvais fonctionnement des plateaux",null,null,null));
       return new QuestionBank(Arrays.asList(question1));

    }

    private QuestionBank generateQuestions8(){
        Question question1=new Question("Vérification de l'état du Camion Grue",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                     "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                     "Aile droite endommagée","Aile gauche endommagée","Validation de la grue expirée","Girophare cassé","Bip de recule défaillant",null,null,null));
        return new QuestionBank(Arrays.asList(question1));
    }


    private QuestionBank generateQuestions9(){
        Question question1=new Question("Vérification de l'état du porteur",
                 Arrays.asList("Rien à signaler","Pneu crevé","Pneus lisses","présence de hernies","Il y a une fuite d'huile","Il y a une fuite d'eau","Il y a une fuite de gazole",
                                "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé",
                 "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée",
                 "Aile droite endommagée","Aile gauche endommagée",null,null,null,null,null,null));
        return new QuestionBank(Arrays.asList(question1));
    }

    private void manageCheckbox() {

        for(b=1;b<myArrayList.size();b++){
            if((myArrayList.get(b)).isChecked()){
                ListData.add((String)(myArrayList.get(b)).getText());
            }
        }

        for(i =0; i<myArrayList.size();i++) {
        (myArrayList.get(i)).setChecked(false);
        mNextButton.setEnabled(false);

    }

}

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
