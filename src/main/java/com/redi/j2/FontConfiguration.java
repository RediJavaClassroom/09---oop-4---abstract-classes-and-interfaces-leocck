package com.redi.j2;

import java.awt.*;

public class FontConfiguration {

    private final String fontName;
    private final int fontSize;
    private final Color fontColor;

    public FontConfiguration(String fontName, int fontSize, Color fontColor) {
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.fontColor = fontColor;
    }

    public String getFontName() {
        return fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public Color getFontColor() {
        return fontColor;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FontConfiguration{");
        sb.append("fontName='").append(fontName).append('\'');
        sb.append(", fontSize=").append(fontSize);
        sb.append(", fontColor=").append(fontColor);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FontConfiguration that = (FontConfiguration) o;

        if (getFontSize() != that.getFontSize()) return false;
        if (getFontName() != null ? !getFontName().equals(that.getFontName()) : that.getFontName() != null)
            return false;
        return getFontColor() != null ? getFontColor().equals(that.getFontColor()) : that.getFontColor() == null;
    }

    @Override
    public int hashCode() {
        int result = getFontName() != null ? getFontName().hashCode() : 0;
        result = 31 * result + getFontSize();
        result = 31 * result + (getFontColor() != null ? getFontColor().hashCode() : 0);
        return result;
    }
}
