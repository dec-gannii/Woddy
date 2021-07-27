package com.example.woddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.woddy.DB.FirebaseManager;
import com.example.woddy.Entity.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends ActivityBase {
    Button btnMoveToChatt;
    Button btnMoveToMyPage;
    EditText edtUserName;   // Test용

    DatabaseReference db;
    FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveToChatt = findViewById(R.id.btn_move_to_chatt);
        btnMoveToMyPage = findViewById(R.id.btn_move_to_mypage);
        edtUserName = findViewById(R.id.edt_user_name);

        btnMoveToChatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChattingList.class);
                startActivity(intent);
            }
        });

        btnMoveToMyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });
    }

}