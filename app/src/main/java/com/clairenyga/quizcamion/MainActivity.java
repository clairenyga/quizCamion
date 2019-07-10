package com.clairenyga.quizcamion;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.clairenyga.quizcamion.model.User;
//import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNomInput;
    private EditText mPrenomInput;
    private TextView mVehiculeText;
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private CheckBox mCheckBox4;
    private EditText mImmattracteurInput;
    private EditText mImmatremorqueInput;
    private Button mStartButton;
    private User mUser;
    private ArrayList<CheckBox> ArrayVehicule= new ArrayList<>();
    //ok1

    public static final int TOUR_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences mPreferences;
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_PRENOM";
    public static final String PREF_KEY_NAME = "PREF_KEY_NOM";
    public static final String PREF_KEY_IMMATTRACTEUR = "PREF_KEY_IMMATTRACTEUR";
    public static final String PREF_KEY_IMMATREMORQUE= "PREF_KEY_IMMATREMORQUE";
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    //ok2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MainActivity::onCreate()");

        mUser = new User();
        mPreferences = getPreferences(MODE_PRIVATE);
        mGreetingText = findViewById(R.id.activity_main_greeting_txt);
        mNomInput = findViewById(R.id.activity_main_nom_input);
        mPrenomInput = findViewById(R.id.activity_main_prenom_input);
        mVehiculeText=findViewById(R.id.activity_main_vehicule_txt);
        mCheckBox1 = findViewById(R.id.checkBox1);
        mCheckBox2 = findViewById(R.id.checkBox2);
        mCheckBox3 = findViewById(R.id.checkBox3);
        mCheckBox4 = findViewById(R.id.checkBox4);
        mImmattracteurInput = findViewById(R.id.activity_main_immattracteur_input);
        mImmatremorqueInput = findViewById(R.id.activity_main_immatremorque_input);
        mStartButton = findViewById(R.id.activity_main_play_btn);

        mStartButton.setEnabled(false);

        greetUser();
        //ok3
        mCheckBox1.setTag(0);
        mCheckBox2.setTag(1);
        mCheckBox3.setTag(2);
        mCheckBox4.setTag(3);

        mImmattracteurInput.setVisibility((View.GONE));
        mImmatremorqueInput.setVisibility(View.GONE);

        mCheckBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);

            }
        });

        mCheckBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmatremorqueInput.setVisibility(View.VISIBLE);

            }
        });

        mCheckBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);
                mImmatremorqueInput.setVisibility(View.GONE);
            }
        });

        mCheckBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);
                mImmatremorqueInput.setVisibility(View.GONE);
            }
        });

        ArrayVehicule.add(mCheckBox1);
        ArrayVehicule.add(mCheckBox2);
        ArrayVehicule.add(mCheckBox3);
        ArrayVehicule.add(mCheckBox4);
        

        mImmattracteurInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mStartButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //ok4

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = mNomInput.getText().toString();
                String prenom = mPrenomInput.getText().toString();
                String immattracteur = mImmattracteurInput.getText().toString();
                String immatremorque = mImmatremorqueInput.getText().toString();

                mUser.setFirstname(prenom);
                mUser.setNom(nom);
                mUser.setImmattracteur(immattracteur);
                mUser.setImmatremorque(immatremorque);

                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstname()).apply();
                mPreferences.edit().putString(PREF_KEY_NAME, mUser.getNom()).apply();
                mPreferences.edit().putString(PREF_KEY_IMMATTRACTEUR, mUser.getImmattracteur()).apply();
                mPreferences.edit().putString(PREF_KEY_IMMATREMORQUE, mUser.getImmatremorque()).apply();

                // User clicked the button

                Intent TourActivityIntent = new Intent(MainActivity.this, TourCamionActivity.class);
                startActivityForResult(TourActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);
            }
        });


    }
    //ok5
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (TOUR_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            int score = data.getIntExtra(TourCamionActivity.BUNDLE_EXTRA_SCORE, 0);

            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            greetUser();
        }
    }
    //ok6

    private void greetUser() {
        String prenom = mPreferences.getString(PREF_KEY_FIRSTNAME, null);
        String nom = mPreferences.getString(PREF_KEY_NAME, null);
        String Immattracteur = mPreferences.getString(PREF_KEY_IMMATTRACTEUR, null);
        String Immatremorque = mPreferences.getString(PREF_KEY_IMMATREMORQUE, null);

        if (null != prenom) {
            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Bonjour, nous allons commencer le tour du Camion";
            mGreetingText.setText(fulltext);
            mPrenomInput.setText(prenom);
            //mPrenomInput.setSelection(nom.length());
            mNomInput.setText(nom);
            //mNomInput.setSelection(nom.length());
            mImmattracteurInput.setText(Immattracteur);
            //mImmattracteurInput.setSelection(nom.length());
            mImmatremorqueInput.setText(Immatremorque);
            //mImmatremorqueInput.setSelection(nom.length());
            mStartButton.setEnabled(true);
        }
    }
    //ok7

    @Override
    protected void onStart() {
        super.onStart();

        out.println("MainActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        out.println("MainActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        out.println("MainActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        out.println("MainActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        out.println("MainActivity::onDestroy()");
    }
}
//ok8
