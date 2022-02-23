package com.example.sistema_de_recomendacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Spinner spinn1, spinn2, spinn3, spinn4;
    private Button btn;
    private TextView mensaje;
    //Inicializamos los arrays que vamos a usar
    String[] usuario = new String[6];
    String[] historial1 = {"Samuel", "Guantes", "Moby Dick (novela)", "Audífonos", "Lentes para sol", "Café"};
    String[] historial2 = {"Juan", "Franela deportiva", "Café", "Cafetera", "Café", "Café"};
    String[] historial3 = {"Janina", "Lentes para sol", "Zapatos deportivos", "Franela deportiva", "Zapatos deportivos", "Calcetines"};
    String[] historial4 = {"Henrique", "2001: A Space Odyssey (dvd)", "Audífonos", "Franela deportiva", "Guantes", "Sandalias"};
    String[] historial5 = {"Víctor", "Franela deportiva", "Sandalias", "Lentes para sol", "Moby Dick (novela)", "Protector solar"};
    String[] historial6 = {"Tobías", "Moby Dick (novela)", "Café", "2001: A Space Odyssey (dvd)", "Audífonos", "Café"};
    String[] articulos = {"Guantes", "Moby Dick (novela)", "Audífonos", "Lentes para sol", "Franela deportiva",
            "Café", "Cafetera", "Zapatos deportivos", "2001: A Space Odyssey (dvd)", "Sandalias","Té verde"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conectamos la parte lógica con la parte gráfica
        this.spinn1 = (Spinner) findViewById(R.id.spinner1);
        this.spinn2 = (Spinner) findViewById(R.id.spinner2);
        this.spinn3 = (Spinner) findViewById(R.id.spinner3);
        this.spinn4 = (Spinner) findViewById(R.id.spinner4);
        this.nombre = (EditText) findViewById(R.id.plainUsuario);
        this.btn = (Button) findViewById(R.id.button);
        this.mensaje = (TextView) findViewById(R.id.txtMensaje);

        //Mostramos el array de artículos dentro de los Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item_Chris, articulos);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_iten_dropdown);
        spinn1.setAdapter(spinnerAdapter);
        spinn2.setAdapter(spinnerAdapter);
        spinn3.setAdapter(spinnerAdapter);
        spinn4.setAdapter(spinnerAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validación de nombre
                String validacion = nombre.getText().toString();
                if (validacion.length() == 0) {
                    Toast.makeText(MainActivity.this, "Ingrese nombre para continuar", Toast.LENGTH_LONG).show();
                } else {

                    //Pasamos el nombre ingresado al array
                    usuario[0] = nombre.getText().toString();

                    //Traemos las opciones de los spinner para llenar el array del nuevo usuario
                    usuario[1] = spinn1.getSelectedItem().toString();
                    usuario[2] = spinn2.getSelectedItem().toString();
                    usuario[3] = spinn3.getSelectedItem().toString();
                    usuario[4] = spinn4.getSelectedItem().toString();
                    int m = 0, a = 0, b = 0, c = 0, d = 0, e = 0;

                    //Comparación usuario-usuario del historial de compra 1
                    for (int i = 1; i < usuario.length - 1; i++) {
                        for (int j = 1; j < historial1.length - 1; j++) {
                            if (usuario[i].equals(historial1[j])) {
                                m++;
                                break;
                            }
                        }
                    }
                    //Comparación usuario-usuario del historial de compra 2
                    for (int i = 1; i < usuario.length - 1; i++) {
                        for (int j = 1; j < historial2.length - 1; j++) {
                            if (usuario[i].equals(historial2[j])) {
                                a++;
                                break;
                            }
                        }
                    }
                    //Comparación usuario-usuario del historial de compra 3
                    for (int i = 1; i < usuario.length - 1; i++) {
                        for (int j = 1; j < historial3.length - 1; j++) {
                            if (usuario[i].equals(historial3[j])) {
                                b++;
                                break;
                            }
                        }
                    }
                    //Comparación usuario-usuario del historial de compra 4
                    for (int i = 1; i < usuario.length - 1; i++) {
                        for (int j = 1; j < historial4.length - 1; j++) {
                            if (usuario[i].equals(historial4[j])) {
                                c++;
                                break;
                            }
                        }
                    }
                    //Comparación usuario-usuario del historial de compra 5
                    for (int i = 1; i < usuario.length - 1; i++) {
                        for (int j = 1; j < historial5.length - 1; j++) {
                            if (usuario[i].equals(historial5[j])) {
                                d++;
                                break;
                            }
                        }
                    }
                    //Comparación usuario-usuario del historial de compra 6
                    for (int i = 1; i < usuario.length - 1; i++) {
                        for (int j = 1; j < historial6.length - 1; j++) {
                            if (usuario[i].equals(historial6[j])) {
                                e++;
                                break;
                            }
                        }
                    }
                    //IF ANIDADOS DE HISTORIAL 1
                    if (m == 4) {
                        String msj = usuario[0] + " tiene un historial de compra parecido a " + historial1[0]
                                + ", su próxima compra posiblemente sea: " + historial1[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((m == 3) && (a <= 2) && (b <= 2) && (c <= 2) && (d <= 2) && (e <= 2)) {
                        String msj = usuario[0] + " tiene más match con " + historial1[0]
                                + ", su próxima compra posiblemente sea: " + historial1[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((m == 3 && a == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial1[5] + " o " + historial2[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((m == 3 && b == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial1[5] + " o " + historial3[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((m == 3 && c == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial1[5] + " o " + historial4[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((m == 3 && d == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial1[5] + " o " + historial5[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((m == 3 && e == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial1[5] + " o " + historial6[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                    //IF ANIDADOS DE HISTORIAL 2
                    if (a == 4) {
                        String msj = usuario[0] + " tiene un historial de compra parecido a " + historial2[0]
                                + ", su próxima compra posiblemente sea: " + historial2[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((a == 3) && (m <= 2) && (b <= 2) && (c <= 2) && (d <= 2) && (e <= 2)) {
                        String msj = usuario[0] + " tiene más match con " + historial2[0]
                                + ", su próxima compra posiblemente sea: " + historial2[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((a == 3 && b == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial2[5] + " o " + historial3[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((a == 3 && c == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial2[5] + " o " + historial4[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((a == 3 && d == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial2[5] + " o " + historial5[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((a == 3 && e == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial2[5] + " o " + historial6[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                    //IF ANIDADOS DE HISTORIAL 3
                    if (b == 4) {
                        String msj = usuario[0] + " tiene un historial de compra parecido a " + historial3[0]
                                + ", su próxima compra posiblemente sea: " + historial3[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((b == 3) && (m <= 2) && (a <= 2) && (c <= 2) && (d <= 2) && (e <= 2)) {
                        String msj = usuario[0] + " tiene más match con " + historial3[0]
                                + ", su próxima compra posiblemente sea: " + historial3[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((b == 3 && c == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial3[5] + " o " + historial4[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((b == 3 && d == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial3[5] + " o " + historial5[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((b == 3 && e == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial3[5] + " o " + historial6[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                    //IF ANIDADOS DE HISTORIAL 4
                    if (c == 4) {
                        String msj = usuario[0] + " tiene un historial de compra parecido a " + historial4[0]
                                + ", su próxima compra posiblemente sea: " + historial4[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((c == 3) && (m <= 2) && (a <= 2) && (b <= 2) && (d <= 2) && (e <= 2)) {
                        String msj = usuario[0] + " tiene más match con " + historial4[0]
                                + ", su próxima compra posiblemente sea: " + historial4[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((c == 3 && d == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial4[5] + " o " + historial5[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((c == 3 && e == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial4[5] + " o " + historial6[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                    //IF ANIDADOS DE HISTORIAL 5
                    if (d == 4) {
                        String msj = usuario[0] + " tiene un historial de compra parecido a " + historial5[0]
                                + ", su próxima compra posiblemente sea: " + historial5[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((d == 3) && (m <= 2) && (a <= 2) && (b <= 2) && (c <= 2) && (e <= 2)) {
                        String msj = usuario[0] + " tiene más match con " + historial5[0]
                                + ", su próxima compra posiblemente sea: " + historial5[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((d == 3 && e == 3)) {
                        String msj = usuario[0] + " tiene más de un match. Tiene dos posibles compras: "
                                + historial5[5] + " o " + historial6[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                    //IF ANIDADOS DE HISTORIAL 6
                    if (e == 4) {
                        String msj = usuario[0] + " tiene un historial de compra parecido a " + historial6[0]
                                + ", su próxima compra posiblemente sea: " + historial6[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    } else if ((e == 3) && (m <= 2) && (a <= 2) && (b <= 2) && (c <= 2) && (d <= 2)) {
                        String msj = usuario[0] + " tiene más match con " + historial6[0]
                                + ", su próxima compra posiblemente sea: " + historial6[5];
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                    //EN CASO DE QUE NO HAYAN SUFICIENTES PUNTOS
                    if ((m <= 2) && (a <= 2) && (b <= 2) && (c <= 2) && (d <= 2) && (e <= 2)) {
                        String msj = "¡No hay suficientes matchs para recomendar! ¡Lo sentimos!";
                        mensaje.setText(msj);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}