package com.fedomn;

/**
 * Created by fedomn on 2015/6/1.
 */
public abstract class RequestHandler {
    protected RequestHandler successor;

    public RequestHandler(RequestHandler successor) {
        this.successor = successor;
    }

    public abstract String handler(String request);
}
