package ru.agrass.tdbtest.model.network.reponses.base;

public class SessionInfo {

    private String SID;
    private String ExpireTimeStamp;
    private String ExpireTimeSpan;


    public SessionInfo(String SID, String ExpireTimeStamp, String ExpireTimeSpan) {
        setSID(SID);
        setExpireTimeSpan(ExpireTimeSpan);
        setExpireTimeSpan(ExpireTimeStamp);
    }

    public String getExpireTimeSpan() {
        return ExpireTimeSpan;
    }

    public String getExpireTimeStamp() {
        return ExpireTimeStamp;
    }

    public String getSID() {
        return SID;
    }

    private void setExpireTimeSpan(String expireTimeSpan) {
        ExpireTimeSpan = expireTimeSpan;
    }

    private void setExpireTimeStamp(String expireTimeStamp) {
        ExpireTimeStamp = expireTimeStamp;
    }

    private void setSID(String SID) {
        this.SID = SID;
    }
}
