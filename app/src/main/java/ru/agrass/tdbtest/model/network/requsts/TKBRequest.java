package ru.agrass.tdbtest.model.network.requsts;

public class TKBRequest {

    private static String loginRequest = "{" +
            "\"Payload\" : {" +
            "\"Login\" : \"best1\"," +
            "\"Password\" : \"123456\"" +
            "}," +
            "\"CorelationId\" : \"og2cEhpPS\"," +
            "\"Type\" : \"Auth\"," +
            "\"Name\" : \"Login\"" +
            "}";

    private static String sendSMSRequest = "{" +
            "\"Type\": \"RequireAction\"," +
            "\"Payload\": {" +
            "\"ActionId\":" +
            "\"e9994232-1256-4bff-b559-" +
            "acf4862a74f0\"," +
            "\"OriginCorelationId\":" +
            "\"pSznSVIhJ\"," +
            "\"ActionType\": \"ProofBySMS\"," +
            "\"ActionData\": {" +
            "\"Authenticator\": \"FakeSMS\"," +
            "\"PhoneNumber\": \"FakeSMS\"," +
            "\"CodeNumber\": \"4\"," +
            "\"RenewTimeout\": \"00:00:10\"," +
            "\"ExpireDate\":" +
            "\"2018-09-18T13:15:16.0550504+03:00\"" +
            "," +
            "\"Timestamp\":" +
            "\"2018-09-17T13:15:16.0790552+03:00\"" +
            "," +
            "\"CodeLength\": 4," +
            "\"TryCount\": 2" +
            "}" +
            "}," +
            "\"SessionInfo\": {" +
            "\"SID\": \"[SID:" +
            "00521809376:00488522315]\"," +
            "\"ExpireTimeStamp\":\n" +
            "\"9999-12-31T23:59:59.9999999\"," +
            "\"ExpireTimeSpan\":" +
            "\"2915119.08:29:43.9209447\"" +
            "}," +
            "\"TimeStamp\":" +
            "\"2018-09-17T13:30:16.0790552+03:00\"" +
            "}";

    private static String checkSMSCodeRequest = "{" +
            "\"Type\" : \"ConfirmOperation\"," +
            "\"Payload\" : {" +
            "\"ActionId\" :" +
            "\"137f1abc-3bea-4a6d-ace2-" +
            "b2a704b762ac\"," +
            "\"Values\" : {" +
            "\"Code\" : \"1238\"" +
            "}\n" +
            "},\n" +
            "\"CorelationId\" : \"qXZ5D1Mt1\"" +
            "}";

    public static String getLoginRequest() {
        return loginRequest;
    }

    public static String getSendSMSRequest() { return sendSMSRequest; }

    public static String getCheckSMSCodeRequest() {return  checkSMSCodeRequest; }
}
