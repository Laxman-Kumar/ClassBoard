package com.example.shared.myprojectversion_1;


public class EventClass {

    String uid, postedBy, eventName, descp, clubName,datePosted;


    public EventClass() {
    }

    public EventClass(String uid, String postedBy, String eventName, String descp, String clubName,String datePosted) {
        this.uid = uid;
        this.postedBy = postedBy;
        this.eventName = eventName;
        this.descp = descp;
        this.clubName = clubName;
        this.datePosted = datePosted;
    }

    public String getUid() {
        return uid;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String dataPosted) {
        this.datePosted = dataPosted;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
