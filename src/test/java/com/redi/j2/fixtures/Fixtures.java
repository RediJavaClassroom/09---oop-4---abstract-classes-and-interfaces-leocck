package com.redi.j2.fixtures;

import com.redi.j2.FontConfiguration;
import com.redi.j2.proxies.*;
import org.mockito.Mockito;

import java.awt.*;
import java.util.Optional;
import java.util.Random;

import static org.mockito.Mockito.CALLS_REAL_METHODS;

public class Fixtures {

    private static int ID = 0;
    private static final Random random = new Random();

    public static UIComponentProxy createComponent() {
        Class<?> clazz = new UIComponentProxy().getTargetClass();
        if(clazz == null) return new UIComponentProxy();
        Point position = new Point(random.nextInt(301), random.nextInt(201));
        Dimension dimension = new Dimension(random.nextInt(301), random.nextInt(201));
        Object mockTarget = Mockito.mock(
                clazz,
                Mockito.withSettings().useConstructor(position, dimension)
                        .extraInterfaces(MockDisplayable.class) // this is just to verify if method is called 0 times without a NoSuchMethod exception
                        .defaultAnswer(CALLS_REAL_METHODS)
        );
        return new UIComponentProxy(mockTarget);
    }

    public static UIComponentProxy createDisplayableComponent() {
        Class<?> clazz = new UIComponentProxy().getTargetClass();
        if(clazz == null) return new UIComponentProxy();
        Point position = new Point(random.nextInt(301), random.nextInt(201));
        Dimension dimension = new Dimension(random.nextInt(301), random.nextInt(201));
        Object mockTarget = Mockito.mock(
                clazz,
                Mockito.withSettings().useConstructor(position, dimension)
                        .extraInterfaces(createDisplayable().getTargetClass())
                        .defaultAnswer(CALLS_REAL_METHODS)
        );
        return new UIComponentProxy(mockTarget);
    }

    public static UIButtonProxy createButton() {
        return createButton(null, null, null, null);
    }

    public static UIButtonProxy createButton(Point position, Dimension size, String text, Boolean enabled) {
        ID++;
        position = Optional.ofNullable(position).orElse(new Point(random.nextInt(101), random.nextInt(101)));
        size = Optional.ofNullable(size).orElse(new Dimension(random.nextInt(301), random.nextInt(201)));
        text = Optional.ofNullable(text).orElse("Button "+ID);
        enabled = Optional.ofNullable(enabled).orElse(true);
        return new UIButtonProxy(position, size, text, enabled);
    }

    public static DisplayableProxy createDisplayable() {
        return new DisplayableProxy();
    }

    public static ClickListenerProxy createClickListener() {
        return new ClickListenerProxy();
    }

    public static UILabelProxy createLabel() {
        return createLabel(null, null, null, null);
    }

    public static UILabelProxy createLabel(Point position, Dimension size, String text, FontConfiguration font) {
        ID++;
        position = Optional.ofNullable(position).orElse(new Point(random.nextInt(101), random.nextInt(101)));
        size = Optional.ofNullable(size).orElse(new Dimension(random.nextInt(301), random.nextInt(60)));
        text = Optional.ofNullable(text).orElse("Label "+ID);
        font = Optional.ofNullable(font).orElse(new FontConfiguration("Arial", size.height, Color.black));
        return new UILabelProxy(position, size, text, font);
    }

    public static FontContainerProxy createFontContainer() {
        return new FontContainerProxy();
    }

    public static UIContainerProxy createContainer() {
        Class<?> clazz = new UIContainerProxy().getTargetClass();
        if(clazz == null) return new UIContainerProxy();
        Point position = new Point(random.nextInt(301), random.nextInt(201));
        Dimension dimension = new Dimension(random.nextInt(301), random.nextInt(201));
        Object mockTarget = Mockito.mock(
                clazz,
                Mockito.withSettings().useConstructor(position, dimension)
                        .defaultAnswer(CALLS_REAL_METHODS)
        );
        return new UIContainerProxy(mockTarget);
    }

    public static UIWindowProxy createWindow() {
        return createWindow(null, null, null);
    }

    public static UIWindowProxy createWindow(Point position, Dimension size, String title) {
        ID++;
        position = Optional.ofNullable(position).orElse(new Point(random.nextInt(101), random.nextInt(101)));
        size = Optional.ofNullable(size).orElse(new Dimension(random.nextInt(301), random.nextInt(201)));
        title = Optional.ofNullable(title).orElse("Window Title "+ID);
        return new UIWindowProxy(position, size, title);
    }
}
