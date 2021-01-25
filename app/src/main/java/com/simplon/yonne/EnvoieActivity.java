package com.simplon.yonne;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;


import entities.Emeteur;
import entities.Envoie;
import entities.Info;
import entities.Recepteur;

public class EnvoieActivity extends AppCompatActivity {
    private Button btn_envoyer;
    private TextView txt_envoie;
    //Declaration des variable qu'on avait definie comme id au niveaau des interface
    private EditText txt_montant;
    private EditText txt_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoie);

        //Recuperation de l'objet emeteur
        Emeteur emeteur = (Emeteur) getIntent().getSerializableExtra("emeteurObject");
        //Recuperation de l'objet recepteur
        Recepteur recepteur = (Recepteur) getIntent().getSerializableExtra("recepteurObject");

        //txt_envoie = (TextView) findViewById(R.id.txt_envoie);

        btn_envoyer = findViewById(R.id.btn_envoyer);
        btn_envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Ici on va linker nos variable avec nos id
                txt_montant = (EditText) findViewById(R.id.txt_montant);
                txt_date = (EditText) findViewById(R.id.txt_date);

                Envoie envoie = new Envoie();
                envoie.setEmeteur(emeteur);
                envoie.setRecepteur(recepteur);
                int montant = Integer.parseInt(txt_montant.getText().toString());
                envoie.setMontant(montant);
                envoie.setDate(txt_date.getText().toString());

                Info info = new Info();
                info.setEmeteur(emeteur);
                info.setRecepteur(recepteur);
                info.setEnvoie(envoie);

                //txt_envoie.setText("String Response : " + info.getEmeteur().getNom()+info.getRecepteur().getNom());


                postData(info);


                               //CALL BACKEND



//                //CALL BACKEND
//                String url = "http://192.168.1.43:8080/api/allEnvoie";
//                txt_envoie = (TextView) findViewById(R.id.txt_envoie);
//
//                RequestQueue requestQueue = Volley.newRequestQueue(EnvoieActivity.this);
//                JsonObjectRequest objectRequest = new JsonObjectRequest(
//                        Request.Method.GET,
//                        url,
//                        null,
//                        new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//
//                                String result = response.toString();
//                                txt_envoie.setText(result);
//
//
//                            }
//                        },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                String result = error.toString();
//                                txt_envoie.setText(result);
//                            }
//                        }
//
//
//                );
//
//                requestQueue.add(objectRequest);

               // Intent intent = new Intent(EnvoieActivity.this,ListeEnvoieActivity.class);
               // Toast.makeText(EnvoieActivity.this, "Envoie effectue avec succe", Toast.LENGTH_LONG).show();
                //startActivity(intent);




            }
        });
    }




    // Cette fonction nous permet de poster des donnes a notre api
    public void postData(Info info) {



        txt_envoie = (TextView) findViewById(R.id.txt_envoie);

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            //C'est ici qu'on va preciser les param qu'on envoie a la partie back-end
            object.put("info",info);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // URL pour acceder a l'api
        String url = "http://192.168.1.71:8080/api/add";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        txt_envoie.setText("String Response : "+ response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txt_envoie.setText("Error getting response");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }





}