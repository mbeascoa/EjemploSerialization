package com.example.ejemploserialization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    CheckBox chkNet, chkJava, chkOracle;
    RadioGroup rgSchedule;
    RadioButton rdMorning, rdAfternoon, rdIndifferent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgSchedule = findViewById(R.id.rgSchedule);

        rdMorning = findViewById(R.id.rdMorning);
        rdAfternoon = findViewById(R.id.rdAfternoon);
        rdIndifferent = findViewById(R.id.rdIndifferent);

        chkJava = findViewById(R.id.chkJava);
        chkNet = findViewById(R.id.chkNet);
        chkOracle = findViewById(R.id.chkOracle);

    }

    public void saveOptions(View view) {
        //Recojo el valor de los radio button que ha seleccionado el usuario.
        //Si es indiferente, bloqueo los checks.
        int selectedSchedule = rgSchedule.getCheckedRadioButtonId();
        String scheduleString = "";
        switch (selectedSchedule) {
            case R.id.rdMorning:
                scheduleString = "Mañanas";
                break;
            case R.id.rdAfternoon:
                scheduleString = "Tardes";
                break;
            case R.id.rdIndifferent:
                scheduleString = "Indiferente";
                //lockCheckOptions();
                break;
        }
        //recojo los valores de los checkbox
        boolean chkJavaValue = chkJava.isChecked();
        boolean chkNetValue = chkNet.isChecked();
        boolean chkOracleValue = chkOracle.isChecked();

        Datos dataCourse = new Datos(chkNetValue, chkJavaValue, chkOracleValue, scheduleString);

        Intent i = new Intent(this, Ventana2.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("data", dataCourse);
        i.putExtras(bundle);
        startActivity(i);
    }


    public void lockCheckOptions(View view) {
        //Habilita los checks para que puedan usarse cuando seleccionas "Mañana" o "Tarde"
        checkOptionsClickableFunction(false);
        checkOptionsEnableFunction(false);
        checkOptionsCheckedFunction(false);
    }

    public void unlockCheckOptions(View view) {
        //Metodo principal cuando seleccionas una opcion que bloquea los checks
        checkOptionsEnableFunction(true);
        checkOptionsClickableFunction(true);
    }

    public void checkOptionsEnableFunction(boolean b) {
        //Metodo que controla el que los checks esten habilitados (true) o desabilitados (false)
        chkJava.setEnabled(b);
        chkNet.setEnabled(b);
        chkOracle.setEnabled(b);
    }

    public void checkOptionsCheckedFunction(boolean b) {
        //Metodo que controla el que los checks esten marcados (true) o desmarcados (false)

        chkJava.setChecked(b);
        chkNet.setChecked(b);
        chkOracle.setChecked(b);
    }

    public void checkOptionsClickableFunction(boolean b) {
        //Metodo que controla el que los checks puedan ser clickables (true) o no (false)
        chkJava.setClickable(b);
        chkNet.setClickable(b);
        chkOracle.setClickable(b);
    }

}
