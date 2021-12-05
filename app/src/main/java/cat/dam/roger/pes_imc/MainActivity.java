package cat.dam.roger.pes_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView At_peskg, At_altura;
    private TextView Resposta;
    private Button bt_calcular;
    private LinearLayout LinLay_1, LinLay_2, LinLay_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicialitzem

        At_peskg = (AutoCompleteTextView) findViewById(R.id.At_peskg);
        At_altura = (AutoCompleteTextView) findViewById(R.id.At_altura);
        Resposta = (TextView) findViewById(R.id.Resposta);
        bt_calcular = (Button) findViewById(R.id.bt_calcular);

        LinLay_1=(LinearLayout) findViewById(R.id.LinLay_1);
        LinLay_2=(LinearLayout) findViewById(R.id.LinLay_2);
        LinLay_3=(LinearLayout) findViewById(R.id.LinLay_3);

    }

    public void Buttons(View view) {

        String toString;

        double pes = Double.parseDouble(String.valueOf(At_peskg.getText()));
        double altura = Double.parseDouble(String.valueOf(At_altura.getText()));

        double IMC = pes/(altura*altura);
        String comestas = "";

        if(IMC<18.5){
            comestas = "Pes insuficient";
        }else if(IMC>=18.5 && IMC<=24.9){
            comestas = "Pes normal";
        }else if(IMC>=25 && IMC<=26.9){
            comestas = "Sobrepès grau I";
        }else if(IMC>=27 && IMC<=29.9){
            comestas = "Sobrepès grau II";
        }else if(IMC>=30 && IMC<=34.9){
            comestas = "Obesitat de tipus I";
        }else if(IMC>=35 && IMC<=39.9){
            comestas = "Obesitat de tipus II";
        }else if(IMC>=40 && IMC<=49.9){
            comestas = "Obesitat de tipus III";
        }else if(IMC>=50){
            comestas = "Obesitat de tipus IV";
        }


        LinLay_1.setVisibility(View.GONE);
        LinLay_2.setVisibility(View.GONE);
        LinLay_3.setVisibility(View.VISIBLE);
        //Arrodonint a decimal
        DecimalFormat f = new DecimalFormat("##.00");

        String pesfinal = String.valueOf(pes);
        String alturafinal = String.valueOf(altura);
        String IMCfinal = String.valueOf(f.format(IMC));



        toString = "Per un pes de " + pesfinal + " quilograms i una alçada de " + alturafinal + " metres. \n el seu IMC es de: " + IMCfinal +
        "\n Voste es troba en el grup: " + comestas;
        Resposta.setText(toString);

    }

}