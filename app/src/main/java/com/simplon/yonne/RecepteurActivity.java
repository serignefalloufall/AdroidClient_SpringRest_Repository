package com.simplon.yonne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entities.Emeteur;
import entities.Recepteur;

public class RecepteurActivity extends AppCompatActivity {

    //Declaration des variable qu'on avait definie comme id au niveaau des interface
    private EditText txt_nomRecepteur;
    private EditText txt_prenomRecepteur;
    private EditText txt_telRecepteur;
    //private TextView txt_recepteur;
    private Button btn_suiv_recepteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepteur);//Apres le chargement de notre interface

        //Recuperation de l'objet emeteur
        Emeteur emeteur = (Emeteur) getIntent().getSerializableExtra("emeteurObject");

        //Ici on va linker nos variable avec nos id
        txt_nomRecepteur = (EditText) findViewById(R.id.txt_nomRecepteur);
        txt_prenomRecepteur = (EditText) findViewById(R.id.txt_prenomRecepteur);
        txt_telRecepteur = (EditText) findViewById(R.id.txt_telRecepteur);

        //txt_recepteur = (TextView) findViewById(R.id.txt_recepteur);
        //txt_recepteur.setText(emeteur.getNom());


        btn_suiv_recepteur = findViewById(R.id.btn_suiv_recepteur);
        btn_suiv_recepteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Recepteur recepteur = new Recepteur();
                recepteur.setNom(txt_nomRecepteur.getText().toString());
                recepteur.setPrenom(txt_prenomRecepteur.getText().toString());
                recepteur.setTel(txt_telRecepteur.getText().toString());


                Intent intent = new Intent(RecepteurActivity.this,EnvoieActivity.class);

                //Pour passer l'objet emeteur a l'activite suivant
                intent.putExtra("emeteurObject", emeteur);
                intent.putExtra("recepteurObject", recepteur);


                startActivity(intent);

            }
        });




    }
}