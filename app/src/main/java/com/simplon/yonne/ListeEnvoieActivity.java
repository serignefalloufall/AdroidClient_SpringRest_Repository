package com.simplon.yonne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListeEnvoieActivity extends AppCompatActivity {
    private TextView txt_title;

    ListView my_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_envoie);

        //CALL BACKEND
        String url = "http://192.168.1.71:8080/api/allEnvoie";
        txt_title = (TextView) findViewById(R.id.txt_envoie);

        RequestQueue requestQueue = Volley.newRequestQueue(ListeEnvoieActivity.this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String result = response.toString();
                        txt_title.setText(result);




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String result = error.toString();
                        txt_title.setText(result);
                    }
                }


        );

        requestQueue.add(objectRequest);


    }


    //Load listeview

//    private void loadIntoListView(String json) throws JSONException {
//        JSONArray jsonArray = new JSONArray(json);
//        String[] envoies = new String[jsonArray.length()];
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject obj = jsonArray.getJSONObject(i);
//            envoies[i] = obj.getString("name");
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, envoies);
//        my_list.setAdapter(arrayAdapter);
//    }

}