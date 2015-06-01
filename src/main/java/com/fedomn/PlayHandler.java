package com.fedomn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fedomn on 2015/6/1.
 */
public class PlayHandler extends RequestHandler {

    private Map<String, String> videoControls = new HashMap<String, String>();

    public PlayHandler(RequestHandler successor) {
        super(successor);
        initVideoControls();
    }

    private void initVideoControls() {
        String[] receiveControls = {"pause", "+10m", "-10m", "+30s", "-30s", "vol+", "vol-", "quit"};
        String[] execControls = {"p", "\033[A", "\033[B", "\033[C", "\033[D", "+", "-", "q"};
        for (int i = 0; i < receiveControls.length; i++) {
            videoControls.put(receiveControls[i], execControls[i]);
        }
    }

    @Override
    public String handler(String request) {
        if (request.startsWith("play")) {
            try {
                Runtime.getRuntime().exec("/home/pi/server/omx_control.sh " + videoControls.get(request.replace("play ","")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "/home/pi/server/omx_control.sh";
        } else {
            return successor.handler(request);
        }
    }
}
