package com.example.viajesxyz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jetcantidad;
    RadioButton jrbcartagena,jrbleticia,jrbpuntacana;
    TextView jtvtotal,jtvciudad,jtvguia,jtvvehiculo;
    CheckBox jcbguia,jcbvehiculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar barra de titulo
        getSupportActionBar().hide();

        //Asociar objetos Java y Xml
        jetcantidad=findViewById(R.id.etcantidad);
        jrbcartagena=findViewById(R.id.rbcartagena);
        jrbleticia=findViewById(R.id.rbleticia);
        jrbpuntacana=findViewById(R.id.rbpuntacana);
        jtvciudad=findViewById(R.id.tvciudad);
        jtvguia=findViewById(R.id.tvguia);
        jtvtotal=findViewById(R.id.tvtotal);
        jtvvehiculo=findViewById(R.id.tvvehiculo);
        jcbguia=findViewById(R.id.cbguia);
        jcbvehiculo=findViewById(R.id.cbvehiculo);

    }

    public void Calcular_valor_viaje(View view){
        String cantidad_personas=jetcantidad.getText().toString();
        if (cantidad_personas.isEmpty()){
            Toast.makeText(this, "La cantidad de personas es requerida", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }
        else{
            int cantidad,valor_ciudad,valor_guia,valor_vehiculo,valor_total;
            cantidad= Integer.parseInt(cantidad_personas);
            if (cantidad < 1){
                Toast.makeText(this, "La cantidad de personas debe ser mayor o igual a 1", Toast.LENGTH_SHORT).show();
            }
            else{
                if (jrbcartagena.isChecked()){
                    jtvciudad.setText("900000");
                    valor_ciudad= 900000;
                }
                else{
                    if (jrbleticia.isChecked()){
                        jtvciudad.setText("2000000");
                        valor_ciudad= 2000000;
                    }
                    else{
                        jtvciudad.setText("3000000");
                        valor_ciudad= 3000000;
                    }
                }

                if (jcbvehiculo.isChecked()){
                    jtvvehiculo.setText("300000");
                    valor_vehiculo= 300000;
                }
                else{
                    jtvvehiculo.setText("0");
                    valor_vehiculo= 0;
                }

                if (jcbguia.isChecked()){
                    jtvguia.setText("100000");
                    valor_guia= 100000;
                }
                else{
                    jtvguia.setText("0");
                    valor_guia= 0;
                }

                valor_total= cantidad * valor_ciudad + valor_guia + valor_vehiculo;
                jtvtotal.setText(String.valueOf(valor_total));
            }
        }
    }

    public void Limpiar(View view){
        jrbcartagena.setChecked(true);
        jcbguia.setChecked(false);
        jcbvehiculo.setChecked(false);
        jtvguia.setText("0");
        jtvvehiculo.setText("0");
        jtvtotal.setText("0");
        jtvciudad.setText("900000");
        jetcantidad.setText("");
        jetcantidad.requestFocus();
    }

}