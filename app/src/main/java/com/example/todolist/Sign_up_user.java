package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Sign_up_user extends AppCompatActivity {
boolean isChecked=false;
LottieAnimationView checkBoxAnimation;
TextView login_page , login_page_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);
        checkBoxAnimation = findViewById(R.id.anima);
        login_page=findViewById(R.id.login_page_transfer);
        login_page_two=findViewById(R.id.login_page_transfer_two);
        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_up_user.this, login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        login_page_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_up_user.this, login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
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