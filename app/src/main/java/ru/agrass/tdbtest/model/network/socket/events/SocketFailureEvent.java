package ru.agrass.tdbtest.model.network.socket.events;

import okhttp3.Response;

public class SocketFailureEvent extends SocketEvent {

    private Throwable throwable;
    private Response response;

    public SocketFailureEvent(Throwable throwable, Response response) {
        super(SocketEvent.TYPE_FAILURE);
        this.throwable = throwable;
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
