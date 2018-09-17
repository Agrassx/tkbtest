package ru.agrass.tdbtest.model.network.socket;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import ru.agrass.tdbtest.model.network.socket.events.SocketEvent;

class RxWebSocketLogger implements Subscriber<SocketEvent> {

    private final String TAG;

    public RxWebSocketLogger(String tag) {
        this.TAG = tag + ": ";
    }

    @Override
    public void onSubscribe(Subscription s) {
        Log.d(TAG, "Subscribe");
    }

    @Override
    public void onNext(SocketEvent socketEvent) {
        Log.d(TAG, "Next");
        Log.d(TAG, socketEvent.toString());
    }

    @Override
    public void onError(Throwable t) {
        Log.e(TAG, "Error");
        Log.e(TAG, t.getMessage());
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "Complete");
    }
}
