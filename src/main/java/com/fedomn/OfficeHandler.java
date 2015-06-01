package com.fedomn;

/**
 * Created by fedomn on 2015/6/1.
 */
public class OfficeHandler extends RequestHandler {
    public OfficeHandler(RequestHandler successor) {
        super(successor);
    }

    @Override
    public String handler(String request) {
        return "";
    }

}
