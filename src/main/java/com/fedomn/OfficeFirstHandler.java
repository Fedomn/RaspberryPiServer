package com.fedomn;

/**
 * Created by fedomn on 2015/6/1.
 */
public class OfficeFirstHandler extends RequestHandler {
    public OfficeFirstHandler(RequestHandler successor) {
        super(successor);
    }

    @Override
    public String handler(String request) {
        if (request.equals("officeFirst")) {
            return "libreoffice";
        } else {
            return successor.handler(request);
        }
    }
}
