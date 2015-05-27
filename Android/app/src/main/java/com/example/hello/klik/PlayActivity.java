package com.example.hello.klik;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class PlayActivity extends ActionBarActivity {

    Button przycisk11;
    Button przycisk12;
    Button przycisk13;

    Button przycisk21;
    Button przycisk22;
    Button przycisk23;

    Button przycisk31;
    Button przycisk32;
    Button przycisk33;

    Button playgame;
    TextView licznik;
    TextView losegame;


    //losowe zmienne
    public Integer x;
    public Integer y;
    //licznik trafionych
    public Integer trafne=0;
    //napis trafionych
    TextView numberofhits;
     //zmienna save
    Integer score;
    //odliczanie czasu
    TextView time;


    @Override
    public void onBackPressed()
    {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);




        //zdefiniowanie
        przycisk11=(Button) findViewById(R.id.przycisk11);
        przycisk12=(Button) findViewById(R.id.przycisk12);
        przycisk13=(Button) findViewById(R.id.przycisk13);

        przycisk21=(Button) findViewById(R.id.przycisk21);
        przycisk22=(Button) findViewById(R.id.przycisk22);
        przycisk23=(Button) findViewById(R.id.przycisk23);

        przycisk31=(Button) findViewById(R.id.przycisk31);
        przycisk32=(Button) findViewById(R.id.przycisk32);
        przycisk33=(Button) findViewById(R.id.przycisk33);



        playgame=(Button) findViewById(R.id.startgame);

        licznik = (TextView) findViewById(R.id.licznik);

        losegame = (TextView) findViewById(R.id.losegame);

        numberofhits = (TextView) findViewById(R.id.numberofhits);

        time = (TextView) findViewById(R.id.time);




        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberofhits.setVisibility(View.VISIBLE);
                licznik.setVisibility(View.VISIBLE);

                seebuttons();
                cleanbutton();
                gra();
                //odpal watek z odliczamien
                odliczanie.start();





            }
        });






    }
    //czasowe
    CountDownTimer odliczanie = new CountDownTimer(15000, 10) {

        public void onTick(long millisUntilFinished) {

            int seconds = (int) ((millisUntilFinished / 10));

            time.setText("Time Left: " + millisUntilFinished / 10);

        }



        public void onFinish() {

            losegame.setText("Time's Up!");


            finish.start();

        }

    };
    CountDownTimer finish = new CountDownTimer(1500, 1000) {

        public void onTick(long millisUntilFinished) {
            save();
            int seconds = (int) ((millisUntilFinished / 10));



        }

        public void onFinish() {




                gokoniec();



        }

    };
    CountDownTimer pauseoncreate = new CountDownTimer(15, 10) {

        public void onTick(long millisUntilFinished) {



        }

        public void onFinish() {




            gra();



        }

    };




    private void seebuttons()
    {
        playgame.setVisibility(View.INVISIBLE);

        przycisk11.setVisibility(View.VISIBLE);
        przycisk12.setVisibility(View.VISIBLE);
        przycisk13.setVisibility(View.VISIBLE);

        przycisk21.setVisibility(View.VISIBLE);
        przycisk22.setVisibility(View.VISIBLE);
        przycisk23.setVisibility(View.VISIBLE);

        przycisk31.setVisibility(View.VISIBLE);
        przycisk32.setVisibility(View.VISIBLE);
        przycisk33.setVisibility(View.VISIBLE);


    }


    public void save()
    {
        odliczanie.cancel();
        przycisk11.setVisibility(View.INVISIBLE);
        przycisk12.setVisibility(View.INVISIBLE);
        przycisk13.setVisibility(View.INVISIBLE);

        przycisk21.setVisibility(View.INVISIBLE);
        przycisk22.setVisibility(View.INVISIBLE);
        przycisk23.setVisibility(View.INVISIBLE);

        przycisk31.setVisibility(View.INVISIBLE);
        przycisk32.setVisibility(View.INVISIBLE);
        przycisk33.setVisibility(View.INVISIBLE);

        przycisk11.setEnabled(false);
        przycisk12.setEnabled(false);
        przycisk13.setEnabled(false);

        przycisk21.setEnabled(false);
        przycisk22.setEnabled(false);
        przycisk23.setEnabled(false);

        przycisk31.setEnabled(false);
        przycisk32.setEnabled(false);
        przycisk33.setEnabled(false);




        losegame.setVisibility(View.VISIBLE);
        licznik.setVisibility(View.INVISIBLE);
        numberofhits.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);
        score=trafne;

    }

    public void cleanbutton()
    {
        przycisk11.setBackgroundColor(Color.BLUE);
        przycisk12.setBackgroundColor(Color.BLUE);
        przycisk13.setBackgroundColor(Color.BLUE);

        przycisk21.setBackgroundColor(Color.BLUE);
        przycisk22.setBackgroundColor(Color.BLUE);
        przycisk23.setBackgroundColor(Color.BLUE);

        przycisk31.setBackgroundColor(Color.BLUE);
        przycisk32.setBackgroundColor(Color.BLUE);
        przycisk33.setBackgroundColor(Color.BLUE);
    }
    public void gokoniec()
    {



        Intent intent2 = new Intent(PlayActivity.this, koniec.class);

        intent2.putExtra("score",score );
       startActivity(intent2);
    }

    public void kolorowanie()
    {
        if (x == 1 && y == 1) {
            przycisk11.setBackgroundColor(Color.GREEN);

        }
        if (x == 1 && y == 2) {
            przycisk12.setBackgroundColor(Color.GREEN);
        }
        if (x == 1 && y == 3) {
            przycisk13.setBackgroundColor(Color.GREEN);
        }


        if (x == 2 && y == 1) {
            przycisk21.setBackgroundColor(Color.GREEN);
        }
        if (x == 2 && y == 2) {
            przycisk22.setBackgroundColor(Color.GREEN);
        }
        if (x == 2 && y == 3) {
            przycisk23.setBackgroundColor(Color.GREEN);
        }


        if (x == 3 && y == 1) {
            przycisk31.setBackgroundColor(Color.GREEN);
        }
        if (x == 3 && y == 2) {
            przycisk32.setBackgroundColor(Color.GREEN);
        }
        if (x == 3 && y == 3) {
            przycisk33.setBackgroundColor(Color.GREEN);
        }
    }

    public void losowanie()
    {
        Random rand = new Random();
        x =rand.nextInt((3 - 1) + 1) + 1;


        y =rand.nextInt((3 - 1) + 1) + 1;
    }

    public void clickaction()
    {
        przycisk11.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==1&&y==1)
                                              {
                                                  trafne++;


                                                  licznik.setText( " " + trafne );
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();

                                              }



                                          }

                                      }
        );


        przycisk12.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==1&&y==2)
                                              {
                                                  trafne++;


                                                  licznik.setText(   " " + trafne );
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );

        przycisk13.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==1&&y==3)
                                              {
                                                  trafne++;


                                                  licznik.setText(  " " + trafne );
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );
        przycisk21.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==2&&y==1)
                                              {
                                                  trafne++;


                                                  licznik.setText(  " " + trafne );
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );

        przycisk22.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==2&&y==2)
                                              {
                                                  trafne++;


                                                  licznik.setText( " " + trafne );
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );

        przycisk23.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==2&&y==3)
                                              {
                                                  trafne++;


                                                  licznik.setText(  " " + trafne );
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );
        przycisk31.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==3&&y==1)
                                              {
                                                  trafne++;


                                                  licznik.setText(  " " + trafne);
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );
        przycisk32.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==3&&y==2)
                                              {
                                                  trafne++;


                                                  licznik.setText(  " " + trafne );
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );
        przycisk33.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if(x==3&&y==3)
                                              {
                                                  trafne++;


                                                  licznik.setText(  " " + trafne);
                                                  cleanbutton();
                                                  pauseoncreate.start();
                                                  //gra();
                                              }
                                              else
                                              {

                                                  finish.start();
                                              }



                                          }

                                      }
        );
    }
    public void gra() {



        losowanie();
        kolorowanie();
        clickaction();

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // if (id == R.id.action_settings) {
        //     return true;
        //  }

        return super.onOptionsItemSelected(item);


    }

}
