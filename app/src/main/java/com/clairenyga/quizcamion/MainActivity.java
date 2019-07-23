package com.clairenyga.quizcamion;

import android.content.DialogInterface;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.clairenyga.quizcamion.model.User;
//import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.IOException;
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
    private CheckBox mCheckBox5;
    private CheckBox mCheckBox6;
    private CheckBox mCheckBox7;
    private CheckBox mCheckBox8;
    private CheckBox mCheckBox9;
    private EditText mImmattracteurInput;
    private EditText mImmatremorqueInput;
    private EditText mImmatvehiculeInput;
    private Button mStartButton;
    private User mUser;
    private ArrayList<CheckBox> ArrayVehicule= new ArrayList<>();
    private ArrayList<String> ArrayFormulaire=new ArrayList<>();
    private int mVehicule;
    public int i,k;

    //ok1

    public static final int TOUR_ACTIVITY_REQUEST_CODE = 42;
    //private SharedPreferences mPreferences;
    public static final String EXTRA_VEHICULE="EXTRA_VEHICULE";
    public static final String EXTRA_NOM="EXTRA_NOM";
    public static final String EXTRA_PRENOM="EXTRA_PRENOM";
    public static final String EXTRA_IMMATTRACTEUR="EXTRA_IMMATTRACTEUR";
    public static final String EXTRA_IMMATREMORQUE="EXTRA_IMMATREMORQUE";
    public static final String EXTRA_IMMATVEHICULE="EXTRA_IMMATVEHICULE";
    //ok2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MainActivity::onCreate()");

        mUser = new User();
        //mPreferences = getPreferences(MODE_PRIVATE);
        mGreetingText = findViewById(R.id.activity_main_greeting_txt);
        mNomInput = findViewById(R.id.activity_main_nom_input);
        mPrenomInput = findViewById(R.id.activity_main_prenom_input);
        mVehiculeText=findViewById(R.id.activity_main_vehicule_txt);
        mCheckBox1 = findViewById(R.id.checkBox1);
        mCheckBox2 = findViewById(R.id.checkBox2);
        mCheckBox3 = findViewById(R.id.checkBox3);
        mCheckBox4 = findViewById(R.id.checkBox4);
        mCheckBox5 = findViewById(R.id.checkBox5);
        mCheckBox6 = findViewById(R.id.checkBox6);
        mCheckBox7 = findViewById(R.id.checkBox7);
        mCheckBox8 = findViewById(R.id.checkBox8);
        mCheckBox9 = findViewById(R.id.checkBox9);
        mImmattracteurInput = findViewById(R.id.activity_main_immattracteur_input);
        mImmatremorqueInput = findViewById(R.id.activity_main_immatremorque_input);
        mImmatvehiculeInput = findViewById(R.id.activity_main_immatvehicule_input);
        mStartButton = findViewById(R.id.activity_main_play_btn);

        mStartButton.setEnabled(false);


        //ok3

        mCheckBox1.setTag(0);
        mCheckBox2.setTag(1);
        mCheckBox3.setTag(2);
        mCheckBox4.setTag(3);
        mCheckBox5.setTag(4);
        mCheckBox6.setTag(5);
        mCheckBox7.setTag(6);
        mCheckBox8.setTag(7);
        mCheckBox9.setTag(8);


        ArrayVehicule.add(mCheckBox1);
        ArrayVehicule.add(mCheckBox2);
        ArrayVehicule.add(mCheckBox3);
        ArrayVehicule.add(mCheckBox4);
        ArrayVehicule.add(mCheckBox5);
        ArrayVehicule.add(mCheckBox6);
        ArrayVehicule.add(mCheckBox7);
        ArrayVehicule.add(mCheckBox8);
        ArrayVehicule.add(mCheckBox9);

        mImmattracteurInput.setVisibility((View.GONE));
        mImmatremorqueInput.setVisibility(View.GONE);
        mImmatvehiculeInput.setVisibility(View.GONE);
        mVehicule=0;



        mCheckBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);
                mImmatremorqueInput.setVisibility(View.VISIBLE);
                mImmatvehiculeInput.setVisibility(View.GONE);
                mVehicule=1;
                OneChoice();
            }
        });


        mCheckBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);
                mImmatremorqueInput.setVisibility(View.VISIBLE);
                mImmatvehiculeInput.setVisibility(View.GONE);
                mVehicule=2;
                OneChoice();
            }
        });

        mCheckBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);
                mImmatremorqueInput.setVisibility(View.VISIBLE);
                mImmatvehiculeInput.setVisibility(View.GONE);
                mVehicule=3;
                OneChoice();
            }
        });

        mCheckBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);
                mImmatremorqueInput.setVisibility(View.VISIBLE);
                mImmatvehiculeInput.setVisibility(View.GONE);
                mVehicule=4;
                OneChoice();
            }
        });

        mCheckBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.VISIBLE);
                mImmatremorqueInput.setVisibility(View.VISIBLE);
                mImmatvehiculeInput.setVisibility(View.GONE);
                mVehicule=5;
                OneChoice();
            }
        });

        mCheckBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.GONE);
                mImmatremorqueInput.setVisibility(View.GONE);
                mImmatvehiculeInput.setVisibility(View.VISIBLE);
                mVehicule=6;
                OneChoice();
            }
        });

        mCheckBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.GONE);
                mImmatremorqueInput.setVisibility(View.GONE);
                mImmatvehiculeInput.setVisibility(View.VISIBLE);
                mVehicule=7;
                OneChoice();
            }
        });

        mCheckBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.GONE);
                mImmatremorqueInput.setVisibility(View.GONE);
                mImmatvehiculeInput.setVisibility(View.VISIBLE);
                mVehicule=8;
                OneChoice();
            }
        });

        mCheckBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmattracteurInput.setVisibility(View.GONE);
                mImmatremorqueInput.setVisibility(View.GONE);
                mImmatvehiculeInput.setVisibility(View.VISIBLE);
                mVehicule=9;
                OneChoice();
            }
        });

        mNomInput.addTextChangedListener(InfoAccueilWatcher);
        mPrenomInput.addTextChangedListener(InfoAccueilWatcher);
        mImmattracteurInput.addTextChangedListener(InfoAccueilWatcher);
        mImmatremorqueInput.addTextChangedListener(InfoAccueilWatcher);
        mImmatvehiculeInput.addTextChangedListener(InfoAccueilWatcher);


        //ok4

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = mNomInput.getText().toString();
                String prenom = mPrenomInput.getText().toString();
                String immattracteur = mImmattracteurInput.getText().toString();
                String immatremorque = mImmatremorqueInput.getText().toString();
                String immatvehicule=mImmatvehiculeInput.getText().toString();

                mUser.setFirstname(prenom);
                mUser.setNom(nom);
                mUser.setImmattracteur(immattracteur);
                mUser.setImmatremorque(immatremorque);
                mUser.setImmatvehicule(immatvehicule);

                ArrayFormulaire.add(nom);
                ArrayFormulaire.add(prenom);
                if(mVehicule==1||mVehicule==2||mVehicule==3||mVehicule==4||mVehicule==5){
                    ArrayFormulaire.add(immattracteur);
                    ArrayFormulaire.add(immatremorque);
                }
                else{
                    ArrayFormulaire.add(immatvehicule);
                }

                // User clicked the button

                Intent TourActivityIntent = new Intent(MainActivity.this, TourCamionActivity.class);
                TourActivityIntent.putExtra(EXTRA_VEHICULE,mVehicule);
                TourActivityIntent.putExtra(EXTRA_NOM,nom);
                TourActivityIntent.putExtra(EXTRA_PRENOM,prenom);
                TourActivityIntent.putExtra(EXTRA_IMMATTRACTEUR,immattracteur);
                TourActivityIntent.putExtra(EXTRA_IMMATREMORQUE,immatremorque);
                TourActivityIntent.putExtra(EXTRA_IMMATVEHICULE,immatvehicule);
                startActivityForResult(TourActivityIntent, TOUR_ACTIVITY_REQUEST_CODE);
            }
        });


    }

    private void OneChoice(){
        for(i=0;i<ArrayVehicule.size();i++){
            if(mVehicule==i+1){
                for(k=0;k<ArrayVehicule.size();k++){
                    if(k!=i){
                        (ArrayVehicule.get(k)).setChecked(false);
                    }

                }
            }
        }
    }
    private TextWatcher InfoAccueilWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nomInput=mNomInput.getText().toString().trim();
            String prenomInput=mPrenomInput.getText().toString().trim();
            String immatTracteurInput=mImmattracteurInput.getText().toString().trim();
            String immatRemorqueInput=mImmatremorqueInput.getText().toString().trim();
            String immatVehiculeInput=mImmatvehiculeInput.getText().toString().trim();
            mStartButton.setEnabled((!nomInput.isEmpty() && !prenomInput.isEmpty() && !immatTracteurInput.isEmpty() && !immatRemorqueInput.isEmpty())||
                    (!nomInput.isEmpty() && !prenomInput.isEmpty() && !immatVehiculeInput.isEmpty()));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

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
