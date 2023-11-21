package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {

    private FirebaseAuth auth;
    ImageView circularImageView;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        circularImageView = findViewById(R.id.circularImageView);
        circularImageView.setImageResource(R.drawable.app_logo_with_name); // Set your image resource
        circularImageView.setBackgroundResource(R.drawable.circular_shape);
        auth=FirebaseAuth.getInstance();
        //auth.signOut();
        circularImageView =findViewById(R.id.circularImageView);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent = new Intent(profile.this, login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

    }
}