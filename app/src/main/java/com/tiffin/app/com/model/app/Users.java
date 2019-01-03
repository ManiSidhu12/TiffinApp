package com.tiffin.app.com.model.app;

public class Users {

    String userName;
    String userId;
    String location;
    String sector;
    String noOfTiffins;
    String phoneNo;

    String mealType;

    public String getLunch() {
        return lunch;
    }

    public String getDinner() {
        return dinner;
    }

    String lunch;
    String dinner;

    public String getMealType() {
        return mealType;
    }

    public Users(){

    }

    public Users(String userName, String userId, String location, String sector, String noOfTiffins, String phoneNo,String meal,String lunch,String dinner) {
        this.userName = userName;
        this.userId = userId;
        this.location = location;
        this.sector = sector;
        this.noOfTiffins = noOfTiffins;
        this.phoneNo = phoneNo;
        this.mealType = meal;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getLocation() {
        return location;
    }

    public String getSector() {
        return sector;
    }

    public String getNoOfTiffins() {
        return noOfTiffins;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
