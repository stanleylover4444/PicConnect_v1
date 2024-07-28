package com.PicConnect.myapplication.DTOS;

public class ChatDTO extends FriendDTO {

    private int chatId;
    private String lastMessageId;
    private String lastMessageTimestamp;



    public ChatDTO(String friendUsername, int friendProfilePictureUrl,   String lastMessageId, String lastMessageTimestamp) {
        super(friendUsername, friendProfilePictureUrl);

        this.lastMessageId = lastMessageId;
        this.lastMessageTimestamp = lastMessageTimestamp;
    }




    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public String getLastMessageTimestamp() {
        return lastMessageTimestamp;
    }

    public void setLastMessageTimestamp(String lastMessageTimestamp) {
        this.lastMessageTimestamp = lastMessageTimestamp;
    }
}