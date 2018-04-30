package edu.illinois.cs.cs125.ddtw;

import android.content.Context;
import android.content.DialogInterface;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.content.DialogInterface.OnClickListener;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public int score = 0;
    public int maxScore;
    private TextView time;

    SharedPreferences prefs;

    public Button buttonOne;
    public Button buttonTwo;
    public Button buttonThree;
    public Button buttonFour;
    public Button buttonFive;
    public Button buttonSix;
    public Button buttonSeven;
    public Button buttonEight;
    public Button buttonNine;
    public Button buttonTen;
    public Button buttonEleven;
    public Button buttonTwelve;

    public TextView scoreText;
    public TextView bestScore;

    final CountDownTimer timer = new CountDownTimer(20000, 1000) {

        public void onTick(long millisUntilFinished) {
            time.setText("Time: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            gameOver();
        }
    }.start();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.time);
        scoreText = findViewById(R.id.scoreText);
        bestScore = findViewById(R.id.bestScore);

        Random r = new Random();
        int column1 = (r.nextInt(4) + 1);
        int column2 = (r.nextInt(4) + 1);
        int column3 = (r.nextInt(4) + 1);

        prefs = getSharedPreferences("PREFS", MODE_PRIVATE);
        maxScore = prefs.getInt("highScore", 0);

        scoreText.setText("Score: 0");
        bestScore.setText("Best: " + maxScore);

        buttonOne = findViewById(R.id.button1);
        buttonTwo = findViewById(R.id.button2);
        buttonThree = findViewById(R.id.button3);
        buttonFour = findViewById(R.id.button4);
        buttonFive = findViewById(R.id.button5);
        buttonSix = findViewById(R.id.button6);
        buttonSeven = findViewById(R.id.button7);
        buttonEight = findViewById(R.id.button8);
        buttonNine = findViewById(R.id.button9);
        buttonTen = findViewById(R.id.button10);
        buttonEleven = findViewById(R.id.button11);
        buttonTwelve = findViewById(R.id.button12);

        buttonOne.setBackgroundColor(Color.WHITE);
        buttonTwo.setBackgroundColor(Color.WHITE);
        buttonThree.setBackgroundColor(Color.WHITE);
        buttonFour.setBackgroundColor(Color.WHITE);
        buttonFive.setBackgroundColor(Color.WHITE);
        buttonSix.setBackgroundColor(Color.WHITE);
        buttonSeven.setBackgroundColor(Color.WHITE);
        buttonEight.setBackgroundColor(Color.WHITE);
        buttonNine.setBackgroundColor(Color.WHITE);
        buttonTen.setBackgroundColor(Color.WHITE);
        buttonEleven.setBackgroundColor(Color.WHITE);
        buttonTwelve.setBackgroundColor(Color.WHITE);




        if (column1 == 1) {
            buttonOne.setBackgroundColor(Color.BLACK);
        } else if (column1 == 2) {
            buttonFour.setBackgroundColor(Color.BLACK);
        } else if (column1 == 3) {
            buttonSeven.setBackgroundColor(Color.BLACK);
        } else {
            buttonTen.setBackgroundColor(Color.BLACK);
        }

        if (column2 == 1) {
            buttonTwo.setBackgroundColor(Color.BLACK);
        } else if (column2 == 2) {
            buttonFive.setBackgroundColor(Color.BLACK);
        } else if (column2 == 3) {
            buttonEight.setBackgroundColor(Color.BLACK);
        } else {
            buttonEleven.setBackgroundColor(Color.BLACK);
        }

        if (column3 == 1) {
            buttonThree.setBackgroundColor(Color.BLACK);
        } else if (column3 == 2) {
            buttonSix.setBackgroundColor(Color.BLACK);
        } else if (column3 == 3) {
            buttonNine.setBackgroundColor(Color.BLACK);
        } else {
            buttonTwelve.setBackgroundColor(Color.BLACK);
        }

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 1", Toast.LENGTH_SHORT).show();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 2", Toast.LENGTH_SHORT).show();
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) buttonThree.getBackground();
                int colorID = buttonColor.getColor();
                if (colorID == Color.BLACK) {
                    score++;
                    if (score > maxScore) {
                        maxScore = score;
                        bestScore.setText("Best: " + maxScore);

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("highScore", maxScore);
                        editor.apply();

                    }
                    scoreText.setText("Score: " + score);

                    buttonThree.setBackgroundColor(Color.WHITE);
                    buttonSix.setBackgroundColor(Color.WHITE);
                    buttonNine.setBackgroundColor(Color.WHITE);
                    buttonTwelve.setBackgroundColor(Color.WHITE);

                    Random r = new Random();
                    int row1 = (r.nextInt(4) + 1);

                    ColorDrawable buttonColor1 = (ColorDrawable) buttonOne.getBackground();
                    int colorID1 = buttonColor1.getColor();

                    ColorDrawable buttonColor2 = (ColorDrawable) buttonTwo.getBackground();
                    int colorID2 = buttonColor2.getColor();

                    ColorDrawable buttonColor4 = (ColorDrawable) buttonFour.getBackground();
                    int colorID4 = buttonColor4.getColor();

                    ColorDrawable buttonColor5 = (ColorDrawable) buttonFive.getBackground();
                    int colorID5 = buttonColor5.getColor();

                    ColorDrawable buttonColor7 = (ColorDrawable) buttonSeven.getBackground();
                    int colorID7 = buttonColor7.getColor();

                    ColorDrawable buttonColor8 = (ColorDrawable) buttonEight.getBackground();
                    int colorID8 = buttonColor8.getColor();

                    ColorDrawable buttonColor10 = (ColorDrawable) buttonTen.getBackground();
                    int colorID10 = buttonColor10.getColor();

                    ColorDrawable buttonColor11 = (ColorDrawable) buttonEleven.getBackground();
                    int colorID11 = buttonColor11.getColor();

                    if (colorID2 == Color.BLACK) {
                        buttonThree.setBackgroundColor(Color.BLACK);
                    } else if (colorID5 == Color.BLACK) {
                        buttonSix.setBackgroundColor(Color.BLACK);
                    } else if (colorID8 == Color.BLACK) {
                        buttonNine.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTwelve.setBackgroundColor(Color.BLACK);
                    }

                    buttonTwo.setBackgroundColor(Color.WHITE);
                    buttonFive.setBackgroundColor(Color.WHITE);
                    buttonEight.setBackgroundColor(Color.WHITE);
                    buttonEleven.setBackgroundColor(Color.WHITE);


                    if (colorID1 == Color.BLACK) {
                        buttonTwo.setBackgroundColor(Color.BLACK);
                    } else if (colorID4 == Color.BLACK) {
                        buttonFive.setBackgroundColor(Color.BLACK);
                    } else if (colorID7 == Color.BLACK) {
                        buttonEight.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonEleven.setBackgroundColor(Color.BLACK);
                    }

                    buttonOne.setBackgroundColor(Color.WHITE);
                    buttonFour.setBackgroundColor(Color.WHITE);
                    buttonSeven.setBackgroundColor(Color.WHITE);
                    buttonTen.setBackgroundColor(Color.WHITE);

                    if (row1 == 1) {
                        buttonOne.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 2) {
                        buttonFour.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 3) {
                        buttonSeven.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTen.setBackgroundColor(Color.BLACK);
                    }


                } else if (colorID == Color.WHITE) {
                    buttonThree.setBackgroundColor(Color.RED);
//                    Toast.makeText(getApplicationContext(), "Game Over " + score , Toast.LENGTH_SHORT).show();
                    gameOver();
                }
//                Toast.makeText(getApplicationContext(), "Button 3 " , Toast.LENGTH_SHORT).show();
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 4", Toast.LENGTH_SHORT).show();
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 5", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) buttonSix.getBackground();
                int colorID = buttonColor.getColor();
                if (colorID == Color.BLACK) {
                    score++;
                    if (score > maxScore) {
                        maxScore = score;
                        bestScore.setText("Best: " + maxScore);

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("highScore", maxScore);
                        editor.apply();
                    }
                    scoreText.setText("Score: " + score);

                    buttonThree.setBackgroundColor(Color.WHITE);
                    buttonSix.setBackgroundColor(Color.WHITE);
                    buttonNine.setBackgroundColor(Color.WHITE);
                    buttonTwelve.setBackgroundColor(Color.WHITE);

                    Random r = new Random();
                    int row1 = (r.nextInt(4) + 1);

                    ColorDrawable buttonColor1 = (ColorDrawable) buttonOne.getBackground();
                    int colorID1 = buttonColor1.getColor();

                    ColorDrawable buttonColor2 = (ColorDrawable) buttonTwo.getBackground();
                    int colorID2 = buttonColor2.getColor();

                    ColorDrawable buttonColor4 = (ColorDrawable) buttonFour.getBackground();
                    int colorID4 = buttonColor4.getColor();

                    ColorDrawable buttonColor5 = (ColorDrawable) buttonFive.getBackground();
                    int colorID5 = buttonColor5.getColor();

                    ColorDrawable buttonColor7 = (ColorDrawable) buttonSeven.getBackground();
                    int colorID7 = buttonColor7.getColor();

                    ColorDrawable buttonColor8 = (ColorDrawable) buttonEight.getBackground();
                    int colorID8 = buttonColor8.getColor();

                    ColorDrawable buttonColor10 = (ColorDrawable) buttonTen.getBackground();
                    int colorID10 = buttonColor10.getColor();

                    ColorDrawable buttonColor11 = (ColorDrawable) buttonEleven.getBackground();
                    int colorID11 = buttonColor11.getColor();

                    if (colorID2 == Color.BLACK) {
                        buttonThree.setBackgroundColor(Color.BLACK);
                    } else if (colorID5 == Color.BLACK) {
                        buttonSix.setBackgroundColor(Color.BLACK);
                    } else if (colorID8 == Color.BLACK) {
                        buttonNine.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTwelve.setBackgroundColor(Color.BLACK);
                    }

                    buttonTwo.setBackgroundColor(Color.WHITE);
                    buttonFive.setBackgroundColor(Color.WHITE);
                    buttonEight.setBackgroundColor(Color.WHITE);
                    buttonEleven.setBackgroundColor(Color.WHITE);


                    if (colorID1 == Color.BLACK) {
                        buttonTwo.setBackgroundColor(Color.BLACK);
                    } else if (colorID4 == Color.BLACK) {
                        buttonFive.setBackgroundColor(Color.BLACK);
                    } else if (colorID7 == Color.BLACK) {
                        buttonEight.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonEleven.setBackgroundColor(Color.BLACK);
                    }

                    buttonOne.setBackgroundColor(Color.WHITE);
                    buttonFour.setBackgroundColor(Color.WHITE);
                    buttonSeven.setBackgroundColor(Color.WHITE);
                    buttonTen.setBackgroundColor(Color.WHITE);

                    if (row1 == 1) {
                        buttonOne.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 2) {
                        buttonFour.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 3) {
                        buttonSeven.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTen.setBackgroundColor(Color.BLACK);
                    }


                } else if (colorID == Color.WHITE) {
                    buttonSix.setBackgroundColor(Color.RED);
//                    Toast.makeText(getApplicationContext(), "Game Over " + score , Toast.LENGTH_SHORT).show();
                    gameOver();
                }
//                Toast.makeText(getApplicationContext(), "Button 6 " , Toast.LENGTH_SHORT).show();
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 7", Toast.LENGTH_SHORT).show();
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 8", Toast.LENGTH_SHORT).show();
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) buttonNine.getBackground();
                int colorID = buttonColor.getColor();
                if (colorID == Color.BLACK) {
                    score++;
                    if (score > maxScore) {
                        maxScore = score;
                        bestScore.setText("Best: " + maxScore);

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("highScore", maxScore);
                        editor.apply();
                    }
                    scoreText.setText("Score: " + score);

                    buttonThree.setBackgroundColor(Color.WHITE);
                    buttonSix.setBackgroundColor(Color.WHITE);
                    buttonNine.setBackgroundColor(Color.WHITE);
                    buttonTwelve.setBackgroundColor(Color.WHITE);

                    Random r = new Random();
                    int row1 = (r.nextInt(4) + 1);

                    ColorDrawable buttonColor1 = (ColorDrawable) buttonOne.getBackground();
                    int colorID1 = buttonColor1.getColor();

                    ColorDrawable buttonColor2 = (ColorDrawable) buttonTwo.getBackground();
                    int colorID2 = buttonColor2.getColor();

                    ColorDrawable buttonColor4 = (ColorDrawable) buttonFour.getBackground();
                    int colorID4 = buttonColor4.getColor();

                    ColorDrawable buttonColor5 = (ColorDrawable) buttonFive.getBackground();
                    int colorID5 = buttonColor5.getColor();

                    ColorDrawable buttonColor7 = (ColorDrawable) buttonSeven.getBackground();
                    int colorID7 = buttonColor7.getColor();

                    ColorDrawable buttonColor8 = (ColorDrawable) buttonEight.getBackground();
                    int colorID8 = buttonColor8.getColor();

                    ColorDrawable buttonColor10 = (ColorDrawable) buttonTen.getBackground();
                    int colorID10 = buttonColor10.getColor();

                    ColorDrawable buttonColor11 = (ColorDrawable) buttonEleven.getBackground();
                    int colorID11 = buttonColor11.getColor();

                    if (colorID2 == Color.BLACK) {
                        buttonThree.setBackgroundColor(Color.BLACK);
                    } else if (colorID5 == Color.BLACK) {
                        buttonSix.setBackgroundColor(Color.BLACK);
                    } else if (colorID8 == Color.BLACK) {
                        buttonNine.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTwelve.setBackgroundColor(Color.BLACK);
                    }

                    buttonTwo.setBackgroundColor(Color.WHITE);
                    buttonFive.setBackgroundColor(Color.WHITE);
                    buttonEight.setBackgroundColor(Color.WHITE);
                    buttonEleven.setBackgroundColor(Color.WHITE);


                    if (colorID1 == Color.BLACK) {
                        buttonTwo.setBackgroundColor(Color.BLACK);
                    } else if (colorID4 == Color.BLACK) {
                        buttonFive.setBackgroundColor(Color.BLACK);
                    } else if (colorID7 == Color.BLACK) {
                        buttonEight.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonEleven.setBackgroundColor(Color.BLACK);
                    }

                    buttonOne.setBackgroundColor(Color.WHITE);
                    buttonFour.setBackgroundColor(Color.WHITE);
                    buttonSeven.setBackgroundColor(Color.WHITE);
                    buttonTen.setBackgroundColor(Color.WHITE);

                    if (row1 == 1) {
                        buttonOne.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 2) {
                        buttonFour.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 3) {
                        buttonSeven.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTen.setBackgroundColor(Color.BLACK);
                    }


                } else if (colorID == Color.WHITE) {
                    buttonNine.setBackgroundColor(Color.RED);
//                    Toast.makeText(getApplicationContext(), "Game Over " + score , Toast.LENGTH_SHORT).show();
                    gameOver();
                }
//                Toast.makeText(getApplicationContext(), "Button 9 " , Toast.LENGTH_SHORT).show();
            }
        });

        buttonTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 10", Toast.LENGTH_SHORT).show();
            }
        });

        buttonEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Button 11", Toast.LENGTH_SHORT).show();
            }
        });

        buttonTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttonColor = (ColorDrawable) buttonTwelve.getBackground();
                int colorID = buttonColor.getColor();
                if (colorID == Color.BLACK) {
                    score++;
                    if (score > maxScore) {
                        maxScore = score;
                        bestScore.setText("Best: " + maxScore);

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("highScore", maxScore);
                        editor.apply();
                    }
                    scoreText.setText("Score: " + score);

                    buttonThree.setBackgroundColor(Color.WHITE);
                    buttonSix.setBackgroundColor(Color.WHITE);
                    buttonNine.setBackgroundColor(Color.WHITE);
                    buttonTwelve.setBackgroundColor(Color.WHITE);

                    Random r = new Random();
                    int row1 = (r.nextInt(4) + 1);

                    ColorDrawable buttonColor1 = (ColorDrawable) buttonOne.getBackground();
                    int colorID1 = buttonColor1.getColor();

                    ColorDrawable buttonColor2 = (ColorDrawable) buttonTwo.getBackground();
                    int colorID2 = buttonColor2.getColor();

                    ColorDrawable buttonColor4 = (ColorDrawable) buttonFour.getBackground();
                    int colorID4 = buttonColor4.getColor();

                    ColorDrawable buttonColor5 = (ColorDrawable) buttonFive.getBackground();
                    int colorID5 = buttonColor5.getColor();

                    ColorDrawable buttonColor7 = (ColorDrawable) buttonSeven.getBackground();
                    int colorID7 = buttonColor7.getColor();

                    ColorDrawable buttonColor8 = (ColorDrawable) buttonEight.getBackground();
                    int colorID8 = buttonColor8.getColor();

                    ColorDrawable buttonColor10 = (ColorDrawable) buttonTen.getBackground();
                    int colorID10 = buttonColor10.getColor();

                    ColorDrawable buttonColor11 = (ColorDrawable) buttonEleven.getBackground();
                    int colorID11 = buttonColor11.getColor();

                    if (colorID2 == Color.BLACK) {
                        buttonThree.setBackgroundColor(Color.BLACK);
                    } else if (colorID5 == Color.BLACK) {
                        buttonSix.setBackgroundColor(Color.BLACK);
                    } else if (colorID8 == Color.BLACK) {
                        buttonNine.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTwelve.setBackgroundColor(Color.BLACK);
                    }

                    buttonTwo.setBackgroundColor(Color.WHITE);
                    buttonFive.setBackgroundColor(Color.WHITE);
                    buttonEight.setBackgroundColor(Color.WHITE);
                    buttonEleven.setBackgroundColor(Color.WHITE);


                    if (colorID1 == Color.BLACK) {
                        buttonTwo.setBackgroundColor(Color.BLACK);
                    } else if (colorID4 == Color.BLACK) {
                        buttonFive.setBackgroundColor(Color.BLACK);
                    } else if (colorID7 == Color.BLACK) {
                        buttonEight.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonEleven.setBackgroundColor(Color.BLACK);
                    }

                    buttonOne.setBackgroundColor(Color.WHITE);
                    buttonFour.setBackgroundColor(Color.WHITE);
                    buttonSeven.setBackgroundColor(Color.WHITE);
                    buttonTen.setBackgroundColor(Color.WHITE);

                    if (row1 == 1) {
                        buttonOne.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 2) {
                        buttonFour.setBackgroundColor(Color.BLACK);
                    } else if (row1 == 3) {
                        buttonSeven.setBackgroundColor(Color.BLACK);
                    } else {
                        buttonTen.setBackgroundColor(Color.BLACK);
                    }


                } else if (colorID == Color.WHITE) {
                    buttonTwelve.setBackgroundColor(Color.RED);
//                    Toast.makeText(getApplicationContext(), "Game Over " + score , Toast.LENGTH_SHORT).show();
                    gameOver();
                }
//                Toast.makeText(getApplicationContext(), "Button 12 " , Toast.LENGTH_SHORT).show();
            }
        });


    }



    public void gameOver () {
        timer.cancel();
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Score: " + score);
        dlgAlert.setTitle("Game Over! ");

        dlgAlert.setPositiveButton("Restart",  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                reset();
            }
        });
        dlgAlert.setNegativeButton("Reset Best",  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                maxScore = 0;
                bestScore.setText("Best: " + maxScore);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("highScore", maxScore);
                editor.apply();

                reset();
            }
        });

        dlgAlert.setCancelable(false);
        dlgAlert.create().show();

    }
    public void reset() {

        timer.start();

        score = 0;
        scoreText.setText("Score: " + score);

        Random r = new Random();

        int column1 = (r.nextInt(4) + 1);
        int column2 = (r.nextInt(4) + 1);
        int column3 = (r.nextInt(4) + 1);

        buttonOne.setBackgroundColor(Color.WHITE);
        buttonTwo.setBackgroundColor(Color.WHITE);
        buttonThree.setBackgroundColor(Color.WHITE);
        buttonFour.setBackgroundColor(Color.WHITE);
        buttonFive.setBackgroundColor(Color.WHITE);
        buttonSix.setBackgroundColor(Color.WHITE);
        buttonSeven.setBackgroundColor(Color.WHITE);
        buttonEight.setBackgroundColor(Color.WHITE);
        buttonNine.setBackgroundColor(Color.WHITE);
        buttonTen.setBackgroundColor(Color.WHITE);
        buttonEleven.setBackgroundColor(Color.WHITE);
        buttonTwelve.setBackgroundColor(Color.WHITE);

        if (column1 == 1) {
            buttonOne.setBackgroundColor(Color.BLACK);
        } else if (column1 == 2) {
            buttonFour.setBackgroundColor(Color.BLACK);
        } else if (column1 == 3) {
            buttonSeven.setBackgroundColor(Color.BLACK);
        } else {
            buttonTen.setBackgroundColor(Color.BLACK);
        }

        if (column2 == 1) {
            buttonTwo.setBackgroundColor(Color.BLACK);
        } else if (column2 == 2) {
            buttonFive.setBackgroundColor(Color.BLACK);
        } else if (column2 == 3) {
            buttonEight.setBackgroundColor(Color.BLACK);
        } else {
            buttonEleven.setBackgroundColor(Color.BLACK);
        }

        if (column3 == 1) {
            buttonThree.setBackgroundColor(Color.BLACK);
        } else if (column3 == 2) {
            buttonSix.setBackgroundColor(Color.BLACK);
        } else if (column3 == 3) {
            buttonNine.setBackgroundColor(Color.BLACK);
        } else {
            buttonTwelve.setBackgroundColor(Color.BLACK);
        }
    }
}
