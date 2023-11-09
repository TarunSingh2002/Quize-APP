package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class Sign_up_user extends AppCompatActivity {
boolean isChecked=false;
LottieAnimationView checkBoxAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);
        checkBoxAnimation = findViewById(R.id.anima);
        checkBoxAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isChecked){
                    checkBoxAnimation.setSpeed(-2);
                    checkBoxAnimation.playAnimation();
                    isChecked=!isChecked;
                }
                else{
                    checkBoxAnimation.setSpeed(2);
                    checkBoxAnimation.playAnimation();
                    isChecked=!isChecked;
                }
            }
        });

    }
}