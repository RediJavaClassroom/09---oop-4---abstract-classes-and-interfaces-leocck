package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

import java.awt.*;

public class UIComponentProxy extends ReflectionProxy {

    public UIComponentProxy(Object... args) {
        super(args);
    }

    public UIComponentProxy(Object target) {
        super(target);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.UIComponent";
    }

    public Point getPosition() {
        if(getTarget() == null) {
            return null;
        }
        return invokeMethod("getPosition", new Class[]{});
    }

    public void setPosition(Point position) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("setPosition", new Class[]{Point.class}, position);
    }

    public Dimension getSize() {
        if(getTarget() == null) {
            return null;
        }
        return invokeMethod("getSize", new Class[]{});
    }

    public void setSize(Dimension size) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("setSize", new Class[]{Dimension.class}, size);
    }

    @Override
    public String toString() {
        if(getTarget() == null) {
            return null;
        }
        return invokeMethod("toString", new Class[]{});
    }
}
