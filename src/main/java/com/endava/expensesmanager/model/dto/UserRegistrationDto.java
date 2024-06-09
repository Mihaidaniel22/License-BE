package com.endava.expensesmanager.model.dto;

public class UserRegistrationDto {
    private String name;
    private String password;

    private Integer userId;

    public Integer getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer userId) {
        this.userId = userId;
    }

}
