package com.example.humberto.toserverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = findViewById(R.id.btn_submit);
        final EditText nome = findViewById(R.id.nome);
        final EditText idade = findViewById(R.id.idade);
        final EditText endereco = findViewById(R.id.endereco);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject postData = new JSONObject();
                try {
                    postData.put("name", nome.getText().toString());
                    postData.put("age", idade.getText().toString());
                    postData.put("address", endereco.getText().toString());


                    new SendDeviceDetails().execute("<server_address>", postData.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                nome.setText("");
                idade.setText("");
                endereco.setText("");
            }
        });

    }
}
