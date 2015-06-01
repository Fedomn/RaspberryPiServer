package com.fedomn;

import java.io.IOException;

/**
 * Created by fedomn on 2015/6/1.
 */
public class PlayFirstHandler extends RequestHandler {
    public PlayFirstHandler(RequestHandler successor) {
        super(successor);
    }

    @Override
    public String handler(String request) {
        if (request.startsWith("playfirst")) {
            String folder_Setting = request.replace("playfirst ", "");
            try {
                Runtime.getRuntime().exec(
                        "/home/pi/server/omx_control.sh play " + folder_Setting);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "/home/pi/server/omx_control.sh play";
        } else {
            return successor.handler(request);
        }
    }
}
