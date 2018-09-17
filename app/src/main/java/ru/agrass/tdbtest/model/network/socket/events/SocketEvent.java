package ru.agrass.tdbtest.model.network.socket.events;

public class SocketEvent {

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_BYTES = 1;
    public static final int TYPE_OPEN = 2;
    public static final int TYPE_FAILURE = 3;
    public static final int TYPE_CLOSED = 4;
    public static final int TYPE_CLOSING = 5;


    private int type;

    public SocketEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
