package com.redi.j2;

import java.awt.*;

public class UIButton extends UIComponent {

    private String text;

    private boolean enabled;

    public UIButton(Point position, Dimension size, String text, boolean enabled) {
        super(position, size);
        this.text = text;
        this.enabled = enabled;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UIButton{");
        sb.append("text='").append(text).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append(", position=").append(getPosition());
        sb.append(", size=").append(getSize());
        sb.append('}');
        return sb.toString();
    }
}
