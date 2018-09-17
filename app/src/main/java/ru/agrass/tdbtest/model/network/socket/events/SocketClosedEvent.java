package ru.agrass.tdbtest.model.network.socket.events;

public class SocketClosedEvent extends SocketEvent {

    private final int code;
    private final String reason;

    public SocketClosedEvent(int code, String reason) {
        super(SocketEvent.TYPE_CLOSED);
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
        return "SocketClosedEvent {" +
                "code = " + code +
                ", reason = \'" + reason + '\'' +
                '}';
    }
}
