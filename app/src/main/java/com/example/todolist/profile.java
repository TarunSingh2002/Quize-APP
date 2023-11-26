package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    private FirebaseAuth auth;
    AppCompatButton btn;
    private ALoadingDialog aLoadingDialog;
    private AppCompatTextView name_view , email_view , dob_view  , gender_view , number_view;
    private AppCompatButton name_change , email_change , dob_change  , gender_change , number_change;
    private String name , email , dob , password , gender , phone_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        aLoadingDialog = new ALoadingDialog(this);
        //button
        btn=findViewById(R.id.loginOut);
        name_change = findViewById(R.id.buttonEnd);
        email_change = findViewById(R.id.buttonEnd2);
        dob_change = findViewById(R.id.buttonEnd4);
        gender_change = findViewById(R.id.buttonEnd5);
        number_change = findViewById(R.id.buttonEnd6);
        //Textview
        name_view = findViewById(R.id.name);
        email_view = findViewById(R.id.email);
        dob_view  = findViewById(R.id.dob);
        gender_view  = findViewById(R.id.gender);
        number_view  = findViewById(R.id.number);
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
        if(firebaseUser == null)
        {
            Toast.makeText(this, "something went wrong", Toast.LENGTH_LONG).show();
        }
        else
        {
            aLoadingDialog.show();
            showUserProfile(firebaseUser);
        }
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userId = firebaseUser.getUid();
        // extracting user reference from db form class named "UserDetails" and node "User details"
        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("User Details");
        referenceProfile.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserDetails userDetails = snapshot.getValue(UserDetails.class);
                if(userDetails != null)
                {
                    //fetching data from data base
                    name = firebaseUser.getDisplayName();
                    email = firebaseUser.getEmail();
                    dob = userDetails.dateOfBirth;
                    gender =userDetails.gender;
                    phone_number =userDetails.number;
                    // setting data in text view
                    name_view.setText(name);
                    email_view.setText(email);
                    dob_view.setText(dob);
                    gender_view.setText(gender);
                    number_view.setText(phone_number);
                    aLoadingDialog.cancel();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(profile.this, "something went wrong", Toast.LENGTH_LONG).show();
                aLoadingDialog.cancel();
            }
        });
    }
}