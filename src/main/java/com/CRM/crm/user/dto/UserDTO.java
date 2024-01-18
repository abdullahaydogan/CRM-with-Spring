package com.CRM.crm.user.dto;

import com.CRM.crm.user.User;

public class UserDTO {

    long id;
    String userName;
    String userEmail;
    String image;

    public UserDTO(User user) {
        setId(user.getId());
        setUserName(user.getUserName());
        setUserEmail(user.getUserEmail());
        setImage(user.getImage());

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
