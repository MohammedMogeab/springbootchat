package com.example.websocket.client;

import com.example.websocket.Message;

import java.util.ArrayList;

public interface MessageListener {
    void onMessageRecieve(Message message);
    void onActiveUsersUpdated(ArrayList<String> users);
}