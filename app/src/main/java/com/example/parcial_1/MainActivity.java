package com.example.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TabHost tbh;
TextView tempVal;
Spinner spn;
Button btn;

conversores objConversor = new conversores();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("AREA").setContent(R.id.tabArea).setIndicator("AREA", null));


        btn = findViewById(R.id.btnAreaConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnAreaDe);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAreaA);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtAreaCantidad);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = objConversor.convertir(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " +
                        resp, Toast.LENGTH_LONG).show();

            }
        });
    }
}
class conversores{
    double[][] valores = {
            {1, 9.2903e-8,0.092903,0.11111106327111108794,0.09290299999966707134,9.290299999966706326e-6,
                    3.58700488349403e-8, }
    };

    public double convertir(int opcion, int de, int a, double cantidad){
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}
