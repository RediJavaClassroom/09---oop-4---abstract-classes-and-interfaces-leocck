package com.redi.j2;

import java.awt.*;

public class UILabel extends UIComponent implements Displayable, FontContainer {

    private String text;

    private FontConfiguration font;

    public UILabel(Point position, Dimension size, String text, FontConfiguration font) {
        super(position, size);
        this.text = text;
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public FontConfiguration getFont() {
        return font;
    }

    public void setFont(FontConfiguration font) {
        this.font = font;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UILabel{");
        sb.append(super.toString());
        sb.append(", text='").append(text).append('\'');
        sb.append(", font=").append(font);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void draw() {
        System.out.println(this);
    }
}
