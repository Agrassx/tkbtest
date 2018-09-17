package ru.agrass.tdbtest.model.network.socket.events;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import okio.ByteString;
import ru.agrass.tdbtest.model.network.socket.events.SocketEvent;

public class SocketMessageEvent extends SocketEvent {

    private final String text;
    private final ByteString bytes;

    public SocketMessageEvent(@NonNull String message) {
        super(SocketEvent.TYPE_MESSAGE);
        this.text = message;
        this.bytes = null;
    }

    public SocketMessageEvent(@NonNull ByteString bytes) {
        super(SocketEvent.TYPE_BYTES);
        this.text = null;
        this.bytes = bytes;
    }

    @Override
    public int getType() {
        return super.getType();
    }

    @Nullable
    public String getText() {
        return text;
    }

    @Nullable
    public ByteString getBytes() {
        return bytes;
    }

    public boolean isText() {
        return getType() == TYPE_MESSAGE;
    }

    public String toString() {
        return "SocketMessageEvent{" +
                "text='" + text + '\'' +
                ", bytes=" + bytes +
                '}';
    }
}
