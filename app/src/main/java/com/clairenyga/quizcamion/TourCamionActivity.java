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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import androidx.appcompat.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


public class TourCamionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private CheckBox mCheckBox4;
    private CheckBox mCheckBox5;
    private CheckBox mCheckBox6;
    private CheckBox mCheckBox7;
    private Button mNextButton;


    private QuestionBank mQuestionBank;
    private List<Question> ListQuestions;
    private Question mCurrentQuestion;
    private CharSequence s;


    private int mScore;
    private int mNumberOfQuestions;

    //private int indexQuestion;

    public int i, j, b;


    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

    private boolean mEnableTouchEvents;

    public ArrayList<CheckBox> myArrayList = new ArrayList<>();
    public ArrayList<String>ListData=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_camion);

        System.out.println("TourCamionActivity::onCreate()");

        mQuestionBank = this.generateQuestions();

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 5;
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
        mNextButton = findViewById(R.id.activity_tour_camion_next_btn);

        // Use the tag property to 'name' the buttons
        mCheckBox1.setTag(0);
        mCheckBox2.setTag(1);
        mCheckBox3.setTag(2);
        mCheckBox4.setTag(3);
        mCheckBox5.setTag(4);
        mCheckBox6.setTag(5);
        mCheckBox7.setTag(6);

        mCheckBox1.setOnClickListener(this);
        mCheckBox2.setOnClickListener(this);
        mCheckBox3.setOnClickListener(this);
        mCheckBox4.setOnClickListener(this);
        mCheckBox5.setOnClickListener(this);
        mCheckBox6.setOnClickListener(this);
        mCheckBox7.setOnClickListener(this);
        mNextButton.setOnClickListener(this);

        myArrayList.add(mCheckBox1);
        myArrayList.add(mCheckBox2);
        myArrayList.add(mCheckBox3);
        myArrayList.add(mCheckBox4);
        myArrayList.add(mCheckBox5);
        myArrayList.add(mCheckBox6);
        myArrayList.add(mCheckBox7);


        mNextButton.setEnabled(false);
        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState(outState);
    }


    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (mQuestionBank.mNextQuestionIndex == 2) {
            Toast.makeText(this, "N'oubliez pas de vérifier le chargement avant de prendre la route!", Toast.LENGTH_LONG).show();
        }


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


    private QuestionBank generateQuestions() {
        Question question1 = new Question("Vérification de l'état des pneus",
                Arrays.asList("Rien à signaler", "pneu crevé", "pneus lisses", "présence d'hernies", null, null, null));

        Question question2 = new Question("Verification porte arrière",
                Arrays.asList("Rien à signaler", "La porte ne se ferme pas", null, null, null, null, null));

        Question question3 = new Question("Voyez-vous un tâche sous le tracteur? Si oui, vous devez contrôler les niveaux.",
                Arrays.asList("Rien à signaler", "Il y a une fuite d'huile", "Il y a une fuite d'eau", "Il y a une fuite de gazole", null, null, null));

        Question question4 = new Question("Vérification des feux",
                Arrays.asList("Rien à signaler", "Feu avant gauche cassé", "Feu avant droit cassé", "Feu arrière gauche cassé", "Feu arrière droit cassé", "Feu latéral gauche cassé", "Feu latéral droit cassé"));

        Question question5 = new Question("Vérification de la carrosserie",
                Arrays.asList("Rien à signaler", "Marche pied gauche cassé", "Marche pied droit cassé", "Pare-choc avant endommagé", "Déflecteur gauche cassé", "Déflecteur droit cassé", "Calandre endommagée"));


        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5));
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
