package com.redi.j2.proxies;

import java.util.List;

public class UIContainerProxy extends UIComponentProxy{

    public UIContainerProxy(Object... args) {
        super(args);
    }

    public UIContainerProxy(Object target) {
        super(target);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.UIContainer";
    }

    public List<Object> getChildren() {
        if(getTarget() == null) {
            return null;
        }
        return invokeMethod("getChildren", new Class[]{});
    }

    public void addComponent(UIComponentProxy component) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("addComponent", new Class[]{component.getTargetClass()}, component.getTarget());
    }

    public void removeComponent(UIComponentProxy component) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("removeComponent", new Class[]{component.getTargetClass()}, component.getTarget());
    }

    public void draw() {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("draw", new Class[]{});
    }

    public void drawSelf() {
        // do nothing (used just for test compilation)
    }
}
