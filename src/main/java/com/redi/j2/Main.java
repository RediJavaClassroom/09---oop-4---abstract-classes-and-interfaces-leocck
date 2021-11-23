package com.redi.j2;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        UIWindow window = new UIWindow(new Point(100, 100),
                new Dimension(200, 100),
                "My Window");

        UIButton button = new UIButton(new Point(0, 0),
                new Dimension(40, 10),
                "Click Me",
                true);
        button.onClickEvent();
        button.disable();
        button.onClickEvent();

        window.addComponent(button);

        UILabel label = new UILabel(new Point(0, 10),
                new Dimension(40, 10),
                "A Label",
                new FontConfiguration("Arial", 16, Color.black));

        window.addComponent(label);

        window.draw();
    }
}
