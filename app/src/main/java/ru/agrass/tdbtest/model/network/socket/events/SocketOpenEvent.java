package ru.agrass.tdbtest.model.network.socket.events;

import okhttp3.Response;
import okhttp3.WebSocket;
import ru.agrass.tdbtest.model.network.socket.events.SocketEvent;

public class SocketOpenEvent extends SocketEvent {

    private WebSocket webSocket;
    private Response response;

    public SocketOpenEvent(WebSocket webSocket, Response response) {
        super(SocketEvent.TYPE_OPEN);
        setWebSocket(webSocket);
        setResponse(response);
    }

    public Response getResponse() {
        return response;
    }


    public WebSocket getWebSocket() {
        return webSocket;
    }

    private void setResponse(Response response) {
        this.response = response;
    }

    private void setWebSocket(WebSocket webSocket) {
        this.webSocket = webSocket;
    }
}
