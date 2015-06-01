package com.fedomn;

/**
 * Created by fedomn on 2015/6/1.
 */
public class PlayFirstHandler extends RequestHandler {
    public PlayFirstHandler(RequestHandler successor) {
        super(successor);
    }

    @Override
    public String handler(String request) {
        if (request.equals("playFirst")) {
            return "/home/pi/server/omx_control.sh play";
        } else {
            return successor.handler(request);
        }
    }
}
