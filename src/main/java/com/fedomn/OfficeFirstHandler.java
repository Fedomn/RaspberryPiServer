package com.fedomn;

import java.io.IOException;

/**
 * Created by fedomn on 2015/6/1.
 */
public class OfficeFirstHandler extends RequestHandler {
    public OfficeFirstHandler(RequestHandler successor) {
        super(successor);
    }

    @Override
    public String handler(String request) {
        if (request.startsWith("officefirst")) {
            try {
                Runtime.getRuntime().exec("libreoffice "+ request.replace("officefirst ", "") +" &");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "libreoffice";
        } else {
            return successor.handler(request);
        }
    }
}
