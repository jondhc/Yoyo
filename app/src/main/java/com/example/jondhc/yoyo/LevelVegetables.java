package com.example.jondhc.yoyo;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class LevelVegetables extends Activity {
    int cuenta_frutas = 0;
    int contadorR = 0;
    boolean lechugaYa = false;
    boolean papaYa = false;
    boolean tomateYa = false;

    View lechuga4;
    View lechuga1;
    View lechuga2;
    View lechuga3;
    View potato4;
    View potato1;
    View potato2;
    View potato3;
    View tomato4;
    View tomato2;
    View tomato1;
    View tomato3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.hide();   // Hide ActionBar
        setContentView(R.layout.activity_level_vegetables);

        TextView count = findViewById(R.id.tecst);
        count.setText(String.valueOf(cuenta_frutas));
        lechuga4 = findViewById(R.id.lechuga4);
        lechuga1 = findViewById(R.id.lechuga1);
        lechuga2 = findViewById(R.id.lechuga2);
        lechuga3 = findViewById(R.id.lechuga3);
        potato4 = findViewById(R.id.potato4);
        potato1 = findViewById(R.id.potato1);
        potato2 = findViewById(R.id.potato2);
        potato3 = findViewById(R.id.potato3);
        tomato4 = findViewById(R.id.tomato4);
        tomato2 = findViewById(R.id.tomato2);
        tomato1 = findViewById(R.id.tomato1);
        tomato3 = findViewById(R.id.tomato3);


        generaFrutas();


    }

    public void generaFrutas() {
        Random randomGenerator = new Random();
        int maxFrutas = 3;
        int minFrutas = 1;
        int range = maxFrutas - minFrutas + 1;
        int escoge_frutas = randomGenerator.nextInt(range) + 1;
        System.out.println("Frutas para escoger=" + escoge_frutas);

        switch (escoge_frutas) {
            case 1:
                System.out.println("Caso 1");
                if (!lechugaYa) {
                    lechugaYa = true;
                    contadorR = 0;
                    System.out.println("IF ejecutado");
                    lechuga4.setVisibility(View.VISIBLE);
                    lechuga1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                lechuga4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    lechuga2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                lechuga4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    lechuga3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                lechuga4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                } else if (lechugaYa) {
                    System.out.println("ELSE-IF ejecutado");
                    generaFrutas();
                }
                break;
            case 2:
                System.out.println("Caso 2");
                if (!papaYa) {
                    papaYa = true;
                    System.out.println("IF ejecutado");
                    contadorR = 0;
                    potato4.setVisibility(View.VISIBLE);
                    potato1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                potato4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    potato2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                potato4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    potato3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                potato4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });

                } else if (papaYa) {
                    System.out.println("ELSE-IF ejecutado");
                    generaFrutas();
                }
                break;
            case 3:
                System.out.println("Caso 3");
                if (!tomateYa) {
                    tomateYa = true;
                    System.out.println("IF ejecutado");
                    contadorR = 0;
                    tomato4.setVisibility(View.VISIBLE);
                    tomato1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                tomato4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    tomato2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                tomato4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                    tomato3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setVisibility(View.INVISIBLE);
                            cuenta_frutas++;
                            contadorR++;
                            TextView count = (TextView) findViewById(R.id.tecst);
                            count.setText(String.valueOf(cuenta_frutas));
                            if (contadorR == 3) {
                                generaFrutas();
                                tomato4.setVisibility(View.INVISIBLE);
                            }
                        }
                    });

                } else if (tomateYa) {
                    System.out.println("ELSE-IF ejecutado");
                    generaFrutas();
                }
                break;
        }
    }
}
