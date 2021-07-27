package com.example.woddy.DB;

import com.example.woddy.Entity.ChattingMsg;
import com.example.woddy.Entity.ChattingInfo;
import com.example.woddy.Entity.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FirebaseManager {
    // Realtime Database이용
    //private FirebaseDatabase firebase; // DB접근 진입점
    private DatabaseReference database;    // DB주소 저장
    //private HashMap<String, Object> ciChildUpdate;    // chatting info child
    //private Map<String, Object> ciValue;    // chatting info value


    public FirebaseManager(DatabaseReference db) {
        //this.firebase = FirebaseDatabase.getInstance(); // 현재 DB접근 진입점 받기
        this.database = db;
        //ciChildUpdate = new HashMap<>();
        //ciValue = null;
    }

    public void addUser(User user) {
        database.child("user")
                .child(user.getNickName()).setValue(user);
    }

    public void addChattingRoom(ChattingInfo chatInfo) {
        //ciValue = chatInfo.toMap();
        //ciChildUpdate.put("/chattingRoom/" + chatInfo.getRoomNumber(), ciValue);
        //database.updateChildren(ciChildUpdate);

        database.child("chattingRoom")
                .child(chatInfo.getRoomNumber()).setValue(chatInfo);

    }

    public void addChattingChat(ChattingMsg chatChat) {
        //database = database.child("/chattingRoom/" + chatChat.getRoomNum() + "/messages/");
        //ciValue = chatChat.toMap();
        //database.child("/chattingRoom/" + chatChat.getRoomNum() + "/messages/").push().setValue(ciValue);

        database.child("chattingRoom")
                .child(chatChat.getRoomNum())
                .child("messages")
                .push().setValue(chatChat);
    }
/*
    public ChattingMsg getChat(String roomNum) {
        Query select = FirebaseDatabase.getInstance().getReference()
                .child("chattingRoom")
                .child(roomNum)
                .child("messages").orderByChild("writtenTime");
    }
*/

        /*
    // Cloud Firestore 아용
    private FirebaseFirestore database;
    private DocumentReference chattingRef;

    public FirebaseManager() {
        database = FirebaseFirestore.getInstance();

    }

    public void makeChattingRoom(ChattingInfo chatInfo, ChattingMsg chatChat) {
        DocumentReference chattingRef = database
                .collection("chattingRooms").document(chatInfo.getRoomNumber())
                .collection("chattings").document();
    }
*/


}
