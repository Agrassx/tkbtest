package ru.agrass.tdbtest.model.network.reponses.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    private String CorelationId;

    private String Type;

    @SerializedName("Payload")
    private Payload payload;

    @SerializedName("SessionInfo")
    private SessionInfo sessionInfo;

    private String TimeStamp;

    public BaseResponse(String CorelationId, String Type, Payload payload,
                                    SessionInfo sessionInfo, String TimeStamp) {
        setCorelationId(CorelationId);
        setPayload(payload);
        setSessionInfo(sessionInfo);
        setTimeStamp(TimeStamp);
        setType(Type);

    }

    public Payload getPayload() {
        return payload;
    }

    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

    public String getCorelationId() {
        return CorelationId;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public String getType() {
        return Type;
    }

    private void setCorelationId(String corelationId) {
        CorelationId = corelationId;
    }

    private void setPayload(Payload payload) {
        this.payload = payload;
    }

    private void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    private void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    private void setType(String type) {
        Type = type;
    }

}
