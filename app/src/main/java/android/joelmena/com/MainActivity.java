package android.joelmena.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_CONTEO = "android.joelmena.com.mainactivity.conteo";
    private int conteo;
    private EditText mCampoPeso;
    private EditText mCampoEstatura;
    private Button mBotonCalcular;
    private Button mBotonLimpiar;
    private TextView mEtiquetaImc;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTEO, conteo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //programacion que guarda los datos al cambiar de orientacion
        if(savedInstanceState == null) {
            conteo = 0;
        }
        else{
            conteo = savedInstanceState.getInt(KEY_CONTEO);
        }


        mCampoPeso = (EditText) findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText) findViewById(R.id.campo_estatura);
        mBotonCalcular = (Button) findViewById(R.id.boton_calcular);
        mBotonLimpiar = (Button) findViewById(R.id.boton_limpiar);
        mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);

    mBotonCalcular.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = mCampoPeso.getText().toString();
            double peso = Double.parseDouble(s);
            s = mCampoEstatura.getText().toString();
            double estatura = Double.parseDouble(s);
            double imc = peso/ (estatura * estatura);
            s = String.format("%2.2f", imc);
            mEtiquetaImc.setText(s);
        }
    });

    mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mCampoPeso.setText(" ");
            mCampoEstatura.setText(" ");
            mEtiquetaImc.setText("0.0");
        }
    });


    }
}


