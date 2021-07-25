package com.example.woddy;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChattingRoom extends ActivityBase{
    ChattingRoomAdapter crAdapter;
    RecyclerView crRecyclerView;
    ImageView btnPlus;
    EditText edtInputCon;
    Button btnSend;

    private ArrayList<ChattingRoomItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting_room);

        // ChattingList에서 클릭한 방의 CHATTER 받아오기
        Intent intent = getIntent();
        String chatter = intent.getStringExtra("CHATTER");
        setMyTitle(chatter);

        initChat();

        crRecyclerView = findViewById(R.id.chatting_room_recyclerView);
        btnPlus = findViewById(R.id.btn_plus);
        edtInputCon = findViewById(R.id.edt_input_conversation);
        btnSend = findViewById(R.id.btn_send);

        // ChattingRoomAdapter연결
        crAdapter = new ChattingRoomAdapter(itemList);
        crRecyclerView.setLayoutManager(new LinearLayoutManager(this, crRecyclerView.VERTICAL, false)); // 상하 스크롤
        crRecyclerView.setAdapter(crAdapter);
        crRecyclerView.smoothScrollToPosition(crAdapter.getItemCount()-1);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chat = edtInputCon.getText().toString();
                crAdapter.addItem(new ChattingRoomItem(chat, "7:15", 0));
                edtInputCon.setText(null);
                crRecyclerView.smoothScrollToPosition(crAdapter.getItemCount()-1);
            }
        });

    }

    private void initChat() {
        itemList = new ArrayList<>();
        itemList.add(new ChattingRoomItem("상대방의 대화입니다.", "7:15", 1));
        itemList.add(new ChattingRoomItem("당신의 대화입니다.", "8:40", 0));
        itemList.add(new ChattingRoomItem("상대방이 말하고 있습니다.", "17:05", 1));
        itemList.add(new ChattingRoomItem("2021-07-23"));
        itemList.add(new ChattingRoomItem("상대방이 채팅치고 있습니다.", "8:23", 1));
        itemList.add(new ChattingRoomItem("당신이 채팅하였습니다.", "8:24", 0));
        itemList.add(new ChattingRoomItem("상대방의 대화입니다.", "7:15", 1));
        itemList.add(new ChattingRoomItem("당신의 대화입니다.", "8:40", 0));
        itemList.add(new ChattingRoomItem("상대방이 말하고 있습니다.", "17:05", 1));
        itemList.add(new ChattingRoomItem("상대방이 채팅치고 있습니다.", "8:23", 1));
        itemList.add(new ChattingRoomItem("당신이 채팅하였습니다.", "8:24", 0));
    }
}