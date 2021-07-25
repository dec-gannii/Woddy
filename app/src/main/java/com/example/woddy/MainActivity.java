package com.example.woddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActivityBase {
    Button btnMoveToChatt;
    Button btnMoveToMyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveToChatt = findViewById(R.id.btn_move_to_chatt);
        btnMoveToMyPage = findViewById(R.id.btn_move_to_mypage);

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