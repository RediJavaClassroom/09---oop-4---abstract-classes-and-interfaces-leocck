package com.redi.j2;

import java.awt.*;

public abstract class UIComponent {

    private Point position;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
