package com.PicConnect.myapplication.DTOS;

import java.sql.Timestamp;

public class MessageDTO   {

    private int messageId;
    private int senderId;
    private int receiverId;
    private String messageText;
    private Timestamp timestampSeen;
    private String statusText;
}
