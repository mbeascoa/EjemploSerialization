package com.example.ejemploserialization;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Ventana2 extends AppCompatActivity {


    TextView horarioFormulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);


        Intent inta = getIntent();
        Datos data = (Datos) inta.getSerializableExtra("data");
        String datoJava=data.isJava()? "SI": "NO";
        String datoNet=data.isNet()? "SI": "NO";
        String datoOracle=data.isOracle()? "SI": "NO";

        horarioFormulario = findViewById(R.id.lbHorario);
        this.horarioFormulario.setText(Html.fromHtml("<BR/> Horario: " + data.getSchedule()+ "<BR/>" + "<BR/>" +
                        "<BR/>¿Quiere curso de Java? :  " + datoJava+"<BR/> <BR/> ¿Quiere curso de .NET?:  "+
                        datoNet+" <BR/> <BR/> ¿Quiere curso de Oracle? : "+datoOracle)
                , TextView.BufferType.SPANNABLE);

    }

    public void closeWindow(View view) {
        finish();
    }
}

