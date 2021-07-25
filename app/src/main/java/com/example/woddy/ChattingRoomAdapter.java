package com.example.woddy;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChattingRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int USER_CONVERSATION = 0;
    public static final int CHATTER_CONVERSATION = 1;
    public static final int DATE_MARK = 2;

    ArrayList<ChattingRoomItem> chatItemList;

    public ChattingRoomAdapter(ArrayList<ChattingRoomItem> chatItemList) {
        this.chatItemList = chatItemList;
    }

    public void addItem(ChattingRoomItem chatItem) {
        chatItemList.add(chatItem);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(viewType == USER_CONVERSATION) {
            view = inflater.inflate(R.layout.chat_room_recycler_user, parent, false);
            return new UserConversationHolder(view);
        } else if (viewType == CHATTER_CONVERSATION) {
            view = inflater.inflate(R.layout.chat_room_recycler_chatter, parent, false);
            return new ChatterConversationHolder(view);
        } else {
            view = inflater.inflate(R.layout.chat_room_recycler_date, parent, false);
            return new DateMarkHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UserConversationHolder) {
            ((UserConversationHolder)holder).userCon.setText(chatItemList.get(position).getConversation());
            ((UserConversationHolder)holder).sendTime.setText(chatItemList.get(position).getTime());
        } else if (holder instanceof ChatterConversationHolder) {
            ((ChatterConversationHolder)holder).chatterCon.setText(chatItemList.get(position).getConversation());
            ((ChatterConversationHolder)holder).getTime.setText(chatItemList.get(position).getTime());
        } else {
            ((DateMarkHolder)holder).dateMark.setText(chatItemList.get(position).getDate());
        }
    }

    @Override
    public int getItemCount() {
        return chatItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return chatItemList.get(position).getViewType();
    }

    public class UserConversationHolder extends RecyclerView.ViewHolder {
        TextView userCon;   // 사용자가 보낸 메시지
        TextView sendTime;  // 메시지 보낸 시간

        public UserConversationHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            userCon = itemView.findViewById(R.id.user_conversation);
            sendTime = itemView.findViewById(R.id.send_time);
        }
    }

    public class ChatterConversationHolder extends RecyclerView.ViewHolder {
        TextView chatterCon;    // 상대방이 보낸 메시지
        TextView getTime;   // 메시지 받은 시간

        public ChatterConversationHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            chatterCon = itemView.findViewById(R.id.chatter_conversation);
            getTime = itemView.findViewById(R.id.receive_time);
        }
    }

    public class DateMarkHolder extends RecyclerView.ViewHolder {
        TextView dateMark;
        public DateMarkHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            dateMark = itemView.findViewById(R.id.date_mark);
        }
    }
}
