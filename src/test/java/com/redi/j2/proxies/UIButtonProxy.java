package com.redi.j2.proxies;

import java.awt.*;

public class UIButtonProxy extends UIComponentProxy{

    public UIButtonProxy(Point position, Dimension size, String text, boolean enabled) {
        super(position, size, text, enabled);
    }

    public UIButtonProxy(Object target) {
        super(target);
    }

    public String getText() {
        if(getTarget() == null) {
            return null;
        }
        return invokeMethod("getText", new Class[]{});
    }

    public void setText(String text) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("setText", new Class[]{String.class}, text);
    }

    public void enable() {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("enable", new Class[]{});
    }

    public void disable() {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("disable", new Class[]{});
    }

    public boolean isEnabled() {
        if(getTarget() == null) {
            return false;
        }
        return invokeMethod("isEnabled", new Class[]{});
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.UIButton";
    }

    public boolean getEnabled() {
        return getPropertyValue("enabled");
    }

    public void draw() {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("draw", new Class[]{});
    }

    public void onClickEvent() {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("onClickEvent", new Class[]{});
    }
}
