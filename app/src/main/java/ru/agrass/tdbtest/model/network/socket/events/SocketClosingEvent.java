package ru.agrass.tdbtest.model.network.socket.events;

public class SocketClosingEvent extends SocketEvent {

    private final String reason;
    private final int code;

    public SocketClosingEvent(int code, String reason) {
        super(SocketEvent.TYPE_CLOSING);
        this.code = code;
        this.reason = reason;
    }
    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }


    @Override
    public String toString() {
        return "SocketClosingEvent {" +
                "code = " + code +
                ", reason = \' " + reason + '\'' +
                '}';
    }
}
