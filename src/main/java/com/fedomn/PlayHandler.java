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
        if (request.equals("play")) {
            return "/home/pi/server/omx_control.sh";
        } else {
            return successor.handler(request);
        }
    }
}
