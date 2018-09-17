package ru.agrass.tdbtest.model.network.reponses.base;

public class Payload {

    private static final String CANCELED = "CANCELED";
    private static final String OK = "Ok";

    private String Result;
    private String SecurityToken;
    private String ActionType;

    public Payload(String result, String SecurityToken, String actionType) {
        setResult(result);
        setSecurityToken(SecurityToken);
        setActionType(actionType);
    }

    public String getResult() {
        return Result;
    }

    public String getSecurityToken() {
        return SecurityToken;
    }

    private void setSecurityToken(String securityToken) {
        SecurityToken = securityToken;
    }

    private void setResult(String result) {
        Result = result;
    }

    public boolean isResultOk() {
        return Result.equals(OK);
    }

    public boolean isResultCancel() {
        return Result.equals(CANCELED);
    }

    public String getActionType() {
        return ActionType;
    }

    private void setActionType(String actionType) {
        ActionType = actionType;
    }
}
