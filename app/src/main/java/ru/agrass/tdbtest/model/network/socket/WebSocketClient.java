package ru.agrass.tdbtest.model.network.socket;

import java.util.concurrent.TimeUnit;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import ru.agrass.tdbtest.model.network.socket.events.SocketEvent;

public class WebSocketClient implements FlowableOnSubscribe<SocketEvent> {

    private static OkHttpClient client;

    private Request request;


    public WebSocketClient() {
        client = getClient();
        request = getRequest();
    }

    private static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .readTimeout(0, TimeUnit.MILLISECONDS)
                    .build();
        }
        return client;
    }

    private Request getRequest() {
        if (request == null) {
            request = new Request.Builder()
                    .url("wss://business-test2.online.tkbbank.ru/ws")
                    .build();
        }
        return request;
    }

    @Override
    public void subscribe(FlowableEmitter<SocketEvent> e) throws Exception {
        client.newWebSocket(request, new WebSocketRouter(e));
    }
}
