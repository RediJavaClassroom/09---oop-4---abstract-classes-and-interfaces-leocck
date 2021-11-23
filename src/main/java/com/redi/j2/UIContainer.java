package com.redi.j2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UIContainer extends UIComponent implements Displayable {

    private List<UIComponent> children;

    public UIContainer(Point position, Dimension size) {
        super(position, size);
        children = new ArrayList<>();
    }

    public void addComponent(UIComponent c) {
        children.add(c);
    }

    public void removeComponent(UIComponent c) {
        children.remove(c);
    }

    public List<UIComponent> getChildren() {
        return children;
    }

    public void setChildren(List<UIComponent> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UIContainer{");
        sb.append(super.toString());
        sb.append(", children=").append(children);
        sb.append('}');
        return sb.toString();
    }

    protected abstract void drawSelf();

    @Override
    public void draw() {
        this.drawSelf();
        for(UIComponent c : children) {
            if(c instanceof Displayable) {
                ((Displayable) c).draw();
            }
        }
    }
}
