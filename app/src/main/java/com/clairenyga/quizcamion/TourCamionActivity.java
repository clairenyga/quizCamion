package com.clairenyga.quizcamion;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
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



    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;


    private int mScore;
    private int mNumberOfQuestions;

    //private int indexQuestion;

    public int i,j;


    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

    private boolean mEnableTouchEvents;

    public ArrayList myArrayList;


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

        ArrayList<CheckBox> myArrayList;
        myArrayList= new ArrayList<>();
        myArrayList.add(mCheckBox1);
        myArrayList.add(mCheckBox2);
        myArrayList.add(mCheckBox3);
        myArrayList.add(mCheckBox4);
        myArrayList.add(mCheckBox5);
        myArrayList.add(mCheckBox6);
        myArrayList.add(mCheckBox7);


        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

        /**ArrayList<CheckBox> myArrayList;
        myArrayList= new ArrayList<>();
        myArrayList.add(mCheckBox1);
        myArrayList.add(mCheckBox2);
        myArrayList.add(mCheckBox3);
        myArrayList.add(mCheckBox4);
        myArrayList.add(mCheckBox5);
        myArrayList.add(mCheckBox6);
        myArrayList.add(mCheckBox7);*/

        /**for (j=0;j<=5;j++){
         if(QuestionList==j){
         for(i = 1; i<=myArrayList.size(); i++){
         CheckBox mCheckBox8=(CheckBox)myArrayList.get(i);
         if(mCheckBox8.isChecked()){
         mCheckBox8.setChecked(false);

         }
         }
         }
         }*/
        for(i = 1; i<=myArrayList.size(); i++){
            CheckBox mCheckBox8=(CheckBox)myArrayList.get(i);
            if(mCheckBox8.isChecked()){
                mCheckBox8.setChecked(false);

            }

        }




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

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // Good answer
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            // Wrong answer
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        mEnableTouchEvents = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mEnableTouchEvents = true;
                /**for(i = 1; i<=myArrayList.size(); i++){
                    CheckBox mCheckBox8=(CheckBox)myArrayList.get(i);
                    if(mCheckBox8.isChecked()){
                        mCheckBox8.setChecked(false);

                    }

                }*/


                // If this is the last question, ends the game.
                // Else, display the next question.
                if (--mNumberOfQuestions == 0) {
                    // End the game
                    endGame();}
                else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    /**for(i = 1; i<=myArrayList.size(); i++){
                        CheckBox mCheckBox8=(CheckBox)myArrayList.get(i);
                        if(mCheckBox8.isChecked()){
                            mCheckBox8.setChecked(false);

                        }

                    }*/
                    displayQuestion(mCurrentQuestion);

                    /**for(i = 1; i<=myArrayList.size(); i++){
                        CheckBox mCheckBox8=(CheckBox)myArrayList.get(i);
                        if(mCheckBox8.isChecked()){
                            mCheckBox8.setChecked(false);

                        }

                    }*/



                }

            }

        }, 2000); // LENGTH_SHORT is usually 2 second long

      /** ArrayList<CheckBox> myArrayList;
        myArrayList= new ArrayList<>();
        myArrayList.add(mCheckBox1);
        myArrayList.add(mCheckBox2);
        myArrayList.add(mCheckBox3);
        myArrayList.add(mCheckBox4);
        myArrayList.add(mCheckBox5);
        myArrayList.add(mCheckBox6);
        myArrayList.add(mCheckBox7);


        for(i = 1; i<=myArrayList.size(); i++){
            CheckBox mCheckBox8=myArrayList.get(i);
            if(mCheckBox8.isChecked()){
                mCheckBox8.setChecked(false);

            }

        }*/



    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);

    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // End the activity
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
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
        mCheckBox1.setText(question.getChoiceList().get(0));
        mCheckBox2.setText(question.getChoiceList().get(1));
        mCheckBox3.setText(question.getChoiceList().get(2));
        mCheckBox4.setText(question.getChoiceList().get(3));
        mCheckBox5.setText(question.getChoiceList().get(4));
        mCheckBox6.setText(question.getChoiceList().get(5));
        mCheckBox7.setText(question.getChoiceList().get(6));




    }


    private QuestionBank generateQuestions() {
        Question question1 = new Question("Vérification de l'état des pneus",
                Arrays.asList("Rien à signaler", "Crevaison", "pneus lisses", "présence d'hernies", "2", null, null),
                1);

        Question question2 = new Question("Verification porte arrière",
                Arrays.asList("Rien à signaler", "Ne se ferme pas", "4", "5", "6", "7", "8"),
                2);

        Question question3 = new Question("Voyez-vous un tâche sous le tracteur? Si oui, vous devez contrôler les niveaux.",
                Arrays.asList("Rien à signaler", "Oui, c'est une fuite d'huile", "Oui,c'est une fuite...", "Oui, c'est une fuite...","9","10","11"),
                0);

        Question question4 = new Question("Vérification des feux",
                Arrays.asList("Rien à signaler", "feu avant gauche cassé", "feu avant droit cassé", "feu arrière gauche cassé","feu arrière droit cassé","feu latéral gauche cassé","feu latéral droit cassé"),
                3);

        Question question5 = new Question("Vérification de la carrosserie",
                Arrays.asList("Rien à signaler", "marche pied gauche cassé", "marche pied droit cassé", "pare-choc avant endommagé","déflecteur gauche cassé","déflecteur droit cassé","calandre endommagée"),
                0);


        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5));
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
