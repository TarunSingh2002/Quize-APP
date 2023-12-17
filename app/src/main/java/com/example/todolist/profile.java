package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    ImageView previousAvatarForStroke , currentAvatarForStroke;
    ImageView circularImageView,
            avatar1 , avatar2 , avatar3 , avatar4 , avatar5 , avatar6 , avatar7 , avatar8 , avatar9 , avatar10,
            avatar11 , avatar12 , avatar13 , avatar14 , avatar15 , avatar16 , avatar17 , avatar18 , avatar19 , avatar20 ,
            avatar21 , avatar22 , avatar23 , avatar24 , avatar25 , avatar26 , avatar27 , avatar28 , avatar29 , avatar30,
            avatar31 , avatar32 , avatar33 , avatar34 , avatar35 , avatar36 , avatar37 , avatar38 , avatar39 , avatar40,
            avatar41 , avatar42 , avatar43 , avatar44 , avatar45 , avatar46 , avatar47 , avatar48 , avatar49 , avatar50;
    private FirebaseAuth auth;
    AppCompatButton btn;
    private ALoadingDialog aLoadingDialog;
    private AppCompatTextView name_view , email_view , dob_view  , gender_view , number_view;
    private AppCompatButton name_change , email_change , dob_change  , gender_change , number_change;
    private String name , email , dob  , gender , phone_number;
    private String currentAvatar , previousAvatar;
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

        View dialogView = getLayoutInflater().inflate(R.layout.avatar, null);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        dialogBuilder.setView(dialogView);
        switch(previousAvatar)
        {
            case "avatar1":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar1);
                break;
            case "avatar2":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar2);
                break;
            case "avatar3":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar3);
                break;
            case "avatar4":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar4);
                break;
            case "avatar5":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar5);
                break;
            case "avatar6":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar6);
                break;
            case "avatar7":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar7);
                break;
            case "avatar8":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar8);
                break;
            case "avatar9":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar9);
                break;
            case "avatar10":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar10);
                break;
            case "avatar11":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar11);
                break;
            case "avatar12":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar12);
                break;
            case "avatar13":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar13);
                break;
            case "avatar14":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar14);
                break;
            case "avatar15":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar15);
                break;
            case "avatar16":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar16);
                break;
            case "avatar17":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar17);
                break;
            case "avatar18":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar18);
                break;
            case "avatar19":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar19);
                break;
            case "avatar20":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar20);
                break;
            case "avatar21":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar21);
                break;
            case "avatar22":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar22);
                break;
            case "avatar23":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar23);
                break;
            case "avatar24":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar24);
                break;
            case "avatar25":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar25);
                break;
            case "avatar26":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar26);
                break;
            case "avatar27":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar27);
                break;
            case "avatar28":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar28);
                break;
            case "avatar29":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar29);
                break;
            case "avatar30":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar30);
                break;
            case "avatar31":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar31);
                break;
            case "avatar32":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar32);
                break;
            case "avatar33":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar33);
                break;
            case "avatar34":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar34);
                break;
            case "avatar35":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar35);
                break;
            case "avatar36":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar36);
                break;
            case "avatar37":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar37);
                break;
            case "avatar38":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar38);
                break;
            case "avatar39":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar39);
                break;
            case "avatar40":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar40);
                break;
            case "avatar41":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar41);
                break;
            case "avatar42":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar42);
                break;
            case "avatar43":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar43);
                break;
            case "avatar44":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar44);
                break;
            case "avatar45":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar45);
                break;
            case "avatar46":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar46);
                break;
            case "avatar47":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar47);
                break;
            case "avatar48":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar48);
                break;
            case "avatar49":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar49);
                break;
            case "avatar50":
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar50);
                break;
            default:
                previousAvatarForStroke = dialogView.findViewById(R.id.avatar6);
        }
        previousAvatarForStroke.setBackgroundResource(R.drawable.background_image_view);
        avatar1 = dialogView.findViewById(R.id.avatar1);
        avatar2 = dialogView.findViewById(R.id.avatar2);
        avatar3 = dialogView.findViewById(R.id.avatar3);
        avatar4 = dialogView.findViewById(R.id.avatar4);
        avatar5 = dialogView.findViewById(R.id.avatar5);
        avatar6 = dialogView.findViewById(R.id.avatar6);
        avatar7 = dialogView.findViewById(R.id.avatar7);
        avatar8 = dialogView.findViewById(R.id.avatar8);
        avatar9 = dialogView.findViewById(R.id.avatar9);
        avatar10 = dialogView.findViewById(R.id.avatar10);

        avatar11 = dialogView.findViewById(R.id.avatar11);
        avatar12 = dialogView.findViewById(R.id.avatar12);
        avatar13 = dialogView.findViewById(R.id.avatar13);
        avatar14 = dialogView.findViewById(R.id.avatar14);
        avatar15 = dialogView.findViewById(R.id.avatar15);
        avatar16 = dialogView.findViewById(R.id.avatar16);
        avatar17 = dialogView.findViewById(R.id.avatar17);
        avatar18 = dialogView.findViewById(R.id.avatar18);
        avatar19 = dialogView.findViewById(R.id.avatar19);
        avatar20 = dialogView.findViewById(R.id.avatar20);

        avatar21 = dialogView.findViewById(R.id.avatar21);
        avatar22 = dialogView.findViewById(R.id.avatar22);
        avatar23 = dialogView.findViewById(R.id.avatar23);
        avatar24 = dialogView.findViewById(R.id.avatar24);
        avatar25 = dialogView.findViewById(R.id.avatar25);
        avatar26 = dialogView.findViewById(R.id.avatar26);
        avatar27 = dialogView.findViewById(R.id.avatar27);
        avatar28 = dialogView.findViewById(R.id.avatar28);
        avatar29 = dialogView.findViewById(R.id.avatar29);
        avatar30 = dialogView.findViewById(R.id.avatar30);

        avatar31 = dialogView.findViewById(R.id.avatar31);
        avatar32 = dialogView.findViewById(R.id.avatar32);
        avatar33 = dialogView.findViewById(R.id.avatar33);
        avatar34 = dialogView.findViewById(R.id.avatar34);
        avatar35 = dialogView.findViewById(R.id.avatar35);
        avatar36 = dialogView.findViewById(R.id.avatar36);
        avatar37 = dialogView.findViewById(R.id.avatar37);
        avatar38 = dialogView.findViewById(R.id.avatar38);
        avatar39 = dialogView.findViewById(R.id.avatar39);
        avatar40 = dialogView.findViewById(R.id.avatar40);

        avatar41 = dialogView.findViewById(R.id.avatar41);
        avatar42 = dialogView.findViewById(R.id.avatar42);
        avatar43 = dialogView.findViewById(R.id.avatar43);
        avatar44 = dialogView.findViewById(R.id.avatar44);
        avatar45 = dialogView.findViewById(R.id.avatar45);
        avatar46 = dialogView.findViewById(R.id.avatar46);
        avatar47 = dialogView.findViewById(R.id.avatar47);
        avatar48 = dialogView.findViewById(R.id.avatar48);
        avatar49 = dialogView.findViewById(R.id.avatar49);
        avatar50 = dialogView.findViewById(R.id.avatar50);

        avatar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar1);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar2);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar3);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar4);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar5);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar6);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar7);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar8);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar9);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar10);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });

        avatar11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar11);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar12);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar13);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar14);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar15);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar16);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar17);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar18);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar19);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar20);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar21);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar22);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar23);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar24);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar25);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar26);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar27);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar28);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar29);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar30);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });

        avatar31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar31);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar32);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar33);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar34);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar35);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar36);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar37);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar38);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar39);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar40);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });

        avatar41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar41);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar42);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar43);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar44);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar45);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar46);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar47);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar48);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar49);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });
        avatar50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAvatarForStroke = dialogView.findViewById(R.id.avatar50);
                setStrok(previousAvatarForStroke,currentAvatarForStroke);
                previousAvatarForStroke = currentAvatarForStroke;
            }
        });

        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               // circularImageView.setImageResource(previousAvatar);
                Toast.makeText(profile.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });
        dialogBuilder.create().show();
    }

    private void setStrok(ImageView previousAvatarForStroke, ImageView currentAvatarForStroke) {
        if(previousAvatarForStroke == currentAvatarForStroke)
            return;
        currentAvatarForStroke.setBackgroundResource(R.drawable.background_image_view);
        previousAvatarForStroke.setBackgroundResource(R.drawable.empty_background_image_view);
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
                    if(gender.equalsIgnoreCase("Male"))
                    {
                        circularImageView.setImageResource(R.drawable.avatar_six);
                        previousAvatar="avatar_six";
                    }
                    else
                    {
                        circularImageView.setImageResource(R.drawable.avatar23);
                        previousAvatar="avatar23";
                    }
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