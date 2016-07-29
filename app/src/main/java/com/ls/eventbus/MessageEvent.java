package com.ls.eventbus;

/**
 * Created by Administrator on 2016/7/28.
 */
public class MessageEvent {
    public String getMessage() {
        return message;
    }

    public String message;

    public MessageEvent(String message) {
        this.message = message;
    }
}
