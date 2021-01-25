package com.simplon.yonne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import entities.Emeteur;

public class EmetteurActivity extends AppCompatActivity {

    //Declaration des variable qu'on avait definie comme id au niveaau des interface
    private EditText txt_nom;
    private EditText txt_prenom;
    private EditText txt_tel;
    private EditText txt_cni;
    private Button btn_suiv_emetteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emetteur);//Apres le chargement de notre interface

        //Ici on va linker nos variable avec nos id
        txt_nom = (EditText) findViewById(R.id.txt_nom);
        txt_prenom = (EditText) findViewById(R.id.txt_prenom);
        txt_tel = (EditText) findViewById(R.id.txt_tel);
        txt_cni = (EditText) findViewById(R.id.txt_cni);

        btn_suiv_emetteur = findViewById(R.id.btn_suiv_emetteur);
        btn_suiv_emetteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Emeteur emeteur = new Emeteur();
                emeteur.setNom(txt_nom.getText().toString());
                emeteur.setPrenom(txt_prenom.getText().toString());
                emeteur.setTel(txt_tel.getText().toString());
                emeteur.setCni(txt_cni.getText().toString());


                Intent intent = new Intent(EmetteurActivity.this,RecepteurActivity.class);

                //Pour passer l'objet emeteur a l'activite suivant
                intent.putExtra("emeteurObject", emeteur);
                startActivity(intent);


            }
        });
    }
}