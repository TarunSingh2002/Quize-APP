package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class update_email extends AppCompatActivity {

    EditText new_email , pwd;
    TextView old_email ,  notAuth;
    TextInputLayout pwd_layout ,  new_email_layout;
    AppCompatButton authenticate , update_email;
    private ALoadingDialog aLoadingDialog;
    private  FirebaseAuth auth;
    private  FirebaseUser firebaseUser;
    private String userId , old_email_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        old_email = findViewById(R.id.email_string);
        pwd_layout= findViewById(R.id.password);
        pwd=findViewById(R.id.password_string);
        authenticate =findViewById(R.id.authentication);
        notAuth = findViewById(R.id.notAuth);
        new_email_layout = findViewById(R.id.email_new);
        new_email = findViewById(R.id.email_new_string);
        update_email = findViewById(R.id.ok);
        aLoadingDialog = new ALoadingDialog(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        userId=firebaseUser.getUid();
        aLoadingDialog.show();
        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("User Details");
        referenceProfile.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserDetails userDetails = snapshot.getValue(UserDetails.class);
                if(userDetails != null)
                {
                    //fetching data from data base
                    old_email_id = firebaseUser.getEmail();
                    // setting data in text view
                    old_email.setText(old_email_id);
                    aLoadingDialog.cancel();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(update_email.this, "something went wrong", Toast.LENGTH_LONG).show();
                aLoadingDialog.cancel();
            }
        });
        // now start
        authenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd_string = pwd.getText().toString();
                pwd_string=trimStartEndSpaces(pwd_string);
                if(validatePassword(pwd_string , pwd_layout))
                {

                }
            }
        });
        update_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private boolean validateEmail(String val , TextInputLayout val_new ) {
        if (val.isEmpty())
        {
            val_new.setError("Email address is required");
            val_new.requestFocus();
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(val).matches())
        {
            val_new.setError("Invalid email address");
            val_new.requestFocus();
            return false;
        }
        else
        {
            val_new.setError(null);
            return true;
        }

    }
    public static String trimStartEndSpaces(String input) {
        int start = 0;
        int end = input.length() - 1;

        // Trim leading spaces
        while (start <= end && Character.isWhitespace(input.charAt(start))) {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && Character.isWhitespace(input.charAt(end))) {
            end--;
        }

        return input.substring(start, end + 1);
    }
    private boolean validatePassword(String val , TextInputLayout val_new ) {
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (val.isEmpty()) {
            val_new.setError("Field cannot be empty");
            val_new.requestFocus();
            return false;
        } else if (!val.matches(passwordVal)) {
            val_new.setError("Password is too weak");
            val_new.requestFocus();
            return false;
        }else {
            val_new.setError(null);
            val_new.setErrorEnabled(false);
            return true;
        }
    }
}