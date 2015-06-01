package com.fedomn;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fedomn on 2015/6/1.
 */
public class OfficeHandler extends RequestHandler {
    private Robot robot;
    private Map<String, Integer> officeControls = new HashMap<String, Integer>();

    public OfficeHandler(RequestHandler successor) {
        super(successor);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        initOfficeControls();
    }

    private void initOfficeControls() {
        String[] receiveControls = {"fScreen", "ESC", "next", "prev"};
        Integer[] execControls = {KeyEvent.VK_F5, KeyEvent.VK_ESCAPE, KeyEvent.VK_DOWN, KeyEvent.VK_UP};
        for (int i = 0; i < receiveControls.length; i++) {
            officeControls.put(receiveControls[i], execControls[i]);
        }
    }
    private void pressOneKey(int key) {
        robot.keyPress(key);
        robot.keyRelease(key);
    }

    private void pressTwoKey(int keyBefore, int keyAfter) {
        robot.keyPress(keyBefore);
        robot.keyPress(keyAfter);
        robot.keyRelease(keyBefore);
        robot.keyRelease(keyAfter);
    }

    @Override
    public String handler(String request) {
        if (request.startsWith("office")) {
            String control = request.replace("office ", "");
            if (control.equals("quit")) {
                pressTwoKey(KeyEvent.VK_ALT, KeyEvent.VK_F4);
            } else {
                pressOneKey(officeControls.get(control));
            }
            return "";
        } else {
            return successor.handler(request);
        }
    }
}
