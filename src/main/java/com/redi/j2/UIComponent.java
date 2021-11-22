package com.redi.j2;

import java.awt.*;

public abstract class UIComponent {

    private Point position;

    private Dimension size;

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
}
