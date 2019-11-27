package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostarMensaje(View view){
        Toast.makeText(this, "Hola mundo", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, DatosActivity.class);
        startActivity(intent);
    }

}
