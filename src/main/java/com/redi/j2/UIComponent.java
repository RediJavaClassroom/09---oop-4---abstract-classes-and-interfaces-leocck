package com.redi.j2;

import java.awt.*;

public abstract class UIComponent {

    private Point position;

    private Dimension size;

    public UIComponent(Point position, Dimension size) {
        this.position = position;
        this.size = size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UIComponent{");
        sb.append("position=").append(position);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
