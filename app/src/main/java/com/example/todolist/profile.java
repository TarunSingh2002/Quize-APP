package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.DialogInterface;
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

    ImageView circularImageView;
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
        //change button click listener
        email_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, update_email.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        circularImageView = findViewById(R.id.circularImageView);
        circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAvatarPickerDialog();
            }
        });
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

    private void showAvatarPickerDialog() {
        // Inflate the custom dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.avatar, null);
        // Create a dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setView(dialogView);
        // Find ImageViews and set click listeners for avatars
        ImageView avatar1 = dialogView.findViewById(R.id.avatar1);
        ImageView avatar2 = dialogView.findViewById(R.id.avatar2);
        // Add click listeners to ImageViews to select avatars
        avatar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set avatar 1 as selected
                // Handle selection or store the selected avatar
                Toast.makeText(profile.this, "avatar1", Toast.LENGTH_SHORT).show();
            }
        });
        avatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set avatar 2 as selected
                // Handle selection or store the selected avatar
                Toast.makeText(profile.this, "avatar2", Toast.LENGTH_SHORT).show();
            }
        });

        // Set OK button click listener
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Retrieve the selected avatar and set it as the user's profile picture
                // Implement logic to set the selected avatar
                // For example:
                // userProfilePicImageView.setImageResource(selectedAvatarResource);
                Toast.makeText(profile.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.create().show(); // Show the dialog
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