package com.redi.j2;

import java.awt.*;

public class UIWindow extends UIContainer {

    private String title;

    public UIWindow(Point position, Dimension size, String title) {
        super(position, size);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UIWindow{");
        sb.append(super.toString());
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void drawSelf() {
        System.out.println(this);
    }
}
