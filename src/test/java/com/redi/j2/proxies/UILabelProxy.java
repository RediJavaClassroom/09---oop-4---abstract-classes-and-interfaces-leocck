package com.redi.j2.proxies;

import com.redi.j2.FontConfiguration;

import java.awt.*;

public class UILabelProxy extends UIComponentProxy {

    public UILabelProxy(Point position, Dimension size, String text, FontConfiguration font) {
        super(position, size, text, font);
    }

    public UILabelProxy(Object target) {
        super(target);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.UILabel";
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

    public FontConfiguration getFont() {
        if(getTarget() == null) {
            return null;
        }
        return invokeMethod("getFont", new Class[]{});
    }

    public void setFont(FontConfiguration font) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("setFont", new Class[]{FontConfiguration.class}, font);
    }

    public void draw() {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("draw", new Class[]{});
    }
}
