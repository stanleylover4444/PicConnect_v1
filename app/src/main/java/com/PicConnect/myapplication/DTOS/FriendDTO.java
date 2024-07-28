package com.PicConnect.myapplication.DTOS;

public class FriendDTO {
    private int friendId;
    private int friendUserId;
    private String friendUsername;
    private int friendProfilePictureUrl;

    public FriendDTO(int friendId, int friendUserId, String friendUsername, int friendProfilePictureUrl) {
        this.friendId = friendId;
        this.friendUserId = friendUserId;
        this.friendUsername = friendUsername;
        this.friendProfilePictureUrl = friendProfilePictureUrl;
    }

    public FriendDTO(String friendUsername, int friendProfilePictureUrl) {
        this.friendUsername = friendUsername;
        this.friendProfilePictureUrl = friendProfilePictureUrl;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getFriendUserId() {
        return friendUserId;
    }

    public void setFriendUserId(int friendUserId) {
        this.friendUserId = friendUserId;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    public int getFriendProfilePictureUrl() {
        return friendProfilePictureUrl;
    }

    public void setFriendProfilePictureUrl(int friendProfilePictureUrl) {
        this.friendProfilePictureUrl = friendProfilePictureUrl;
    }
}