package com.example.jorge.p2texto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText enviar,enviar2,enviar3;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar=(EditText)findViewById(R.id.texto1);
        enviar2=(EditText)findViewById(R.id.texto2);
        enviar3=(EditText)findViewById(R.id.texto3);
        boton=(Button)findViewById(R.id.boton);


       

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String para = enviar.getText().toString();
                String asunto = enviar2.getText().toString();
                String mensaje = enviar3.getText().toString();



                Intent emailIntent=new Intent(Intent.ACTION_SEND);

                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{para});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);


                //emailIntent.putExtra(Intent.EXTRA_EMAIL, new String []{enviar.getText().toString()});
                //emailIntent.putExtra(Intent.EXTRA_SUBJECT, enviar2.getText().toString());
                //emailIntent.putExtra(Intent.EXTRA_TEXT, enviar3.getText().toString());

                //bundle.putString("texto1",enviar.getText().toString());
                //bundle.putString("texto2",enviar2.getText().toString());
                //bundle.putString("texto3",enviar3.getText().toString());
                //emailIntent.setType("text/plain");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"selecciona"));




            }
        });


    }
}
