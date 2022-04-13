package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randNum;
    public void randNumGenerator(){
        Random rand = new Random();
        randNum = rand.nextInt(20) + 1;
    }

    public void guessNum(View view){
        try {
            String message;
            EditText number = (EditText) findViewById(R.id.editTextNumber);
            int guessedNum = Integer.parseInt(number.getText().toString());
            if(guessedNum > 0 && guessedNum < 21){
                if (guessedNum < randNum){
                    message = "Higer !!";
                } else if (guessedNum > randNum){
                    message = "Lower !!";
                } else {
                    message = "WOW !! , you're correct !!";
                    randNumGenerator();
                }
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please input a number between 1 to 20 !!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            Toast.makeText(this, "Please input a number !!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randNum = rand.nextInt(20) + 1;
    }
}