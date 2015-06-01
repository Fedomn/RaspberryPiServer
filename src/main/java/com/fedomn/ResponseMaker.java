package com.fedomn;

/**
 * Created by fedomn on 2015/5/31.
 */
public class ResponseMaker {

    public static String translate(String request) {
        RequestHandler commonRequestHandler = new CommonRequestHandler(null);
        RequestHandler officeHandler = new OfficeHandler(commonRequestHandler);
        RequestHandler officeFirstHandler = new OfficeFirstHandler(officeHandler);
        RequestHandler playHandler = new PlayHandler(officeFirstHandler);
        RequestHandler playFirstHandler = new PlayFirstHandler(playHandler);
        return playFirstHandler.handler(request);


        if (request.equals("playFirst")) {
            return "/home/pi/server/omx_control.sh play";
        } else if (request.equals("play")) {
            return "/home/pi/server/omx_control.sh";
        } else if (request.equals("officeFirst")) {
            return "libreoffice";
        } else {
            return "";
        }
    }
}
