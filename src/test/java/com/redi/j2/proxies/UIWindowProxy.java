package com.redi.j2.proxies;

import com.redi.j2.FontConfiguration;

import java.awt.*;

public class UIWindowProxy extends UIContainerProxy{

    public UIWindowProxy(Point position, Dimension size, String title) {
        super(position, size, title);
    }

    public UIWindowProxy(Object target) {
        super(target);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.UIWindow";
    }

    public String getTitle() {
        if(getTarget() == null) {
            return null;
        }
        return invokeMethod("getTitle", new Class[]{});
    }

    public void setTitle(String title) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("setTitle", new Class[]{String.class}, title);
    }

    @Override
    public void drawSelf() {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("drawSelf", new Class[]{});
    }
}
