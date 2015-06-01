package com.fedomn;

/**
 * Created by fedomn on 2015/6/1.
 */
public class PlayHandler extends RequestHandler {
    public PlayHandler(RequestHandler successor) {
        super(successor);
    }

    @Override
    public String handler(String request) {
        return "";
    }
}
