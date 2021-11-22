package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.UIComponentProxy;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step1Tests {

    @Test
    void task_1_0_shouldDefineUIComponentClass() {

        // given - a class we want the students to implement
        UIComponentProxy component;

        // when - we check if it exists
        component = Fixtures.createComponent();

        // then - it should exist
        assertTrue(component.existsClass(), "UIComponent class is not defined");

        // and - it should be abstract
        assertTrue(component.isAbstract(), "UIComponent should be abstract");
    }

    @Test
    void task_1_1_shouldHavePositionProperty() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the 'position' property

        // then - it should exist
        assertTrue(component.hasProperty("position"), "Property 'position' is not defined");

        // and - it should have the correct type
        assertTrue(component.isPropertyOfType("position", Point.class), "Property 'position' should be a java.awt.Point");

        // and - it should have private access
        assertTrue(component.isPropertyPrivate("position"), "Property 'position' should have private access");
    }

    @Test
    void task_1_1_shouldHaveGetterForPosition() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the 'getPosition' method

        // then - it should exist
        assertTrue(component.hasMethod("getPosition"), "Method 'getPosition' is not defined");

        // and - it should have the correct return type
        assertTrue(component.isMethodReturnType(Point.class, "getPosition"), "Method 'getPosition' should return a java.awt.Point");

        // and - it should have public access
        assertTrue(component.isMethodPublic("getPosition"), "Method 'getPosition' should be public");
    }

    @Test
    void task_1_1_shouldHaveSetterForPosition() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the 'setPosition' method

        // then - it should exist
        assertTrue(component.hasMethod("setPosition", Point.class), "Method 'setPosition' is not defined");

        // and - it should have the correct return type
        assertTrue(component.isMethodReturnType(void.class, "setPosition", Point.class), "Method 'setPosition' should return void");

        // and - it should have public access
        assertTrue(component.isMethodPublic("setPosition", Point.class), "Method 'setPosition' should be public");
    }

    @Test
    void task_1_2_shouldHaveSizeProperty() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the 'size' property

        // then - it should exist
        assertTrue(component.hasProperty("size"), "Property 'size' is not defined");

        // and - it should have the correct type
        assertTrue(component.isPropertyOfType("size", Dimension.class), "Property 'size' should be a java.awt.Dimension");

        // and - it should have private access
        assertTrue(component.isPropertyPrivate("size"), "Property 'size' should have private access");
    }

    @Test
    void task_1_2_shouldHaveGetterForSize() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the 'getSize' method

        // then - it should exist
        assertTrue(component.hasMethod("getSize"), "Method 'getSize' is not defined");

        // and - it should have the correct return type
        assertTrue(component.isMethodReturnType(Dimension.class, "getSize"), "Method 'getSize' should return a java.awt.Dimension");

        // and - it should have public access
        assertTrue(component.isMethodPublic("getSize"), "Method 'getSize' should be public");
    }

    @Test
    void task_1_2_shouldHaveSetterForSize() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the 'setSize' method

        // then - it should exist
        assertTrue(component.hasMethod("setSize", Dimension.class), "Method 'setSize' is not defined");

        // and - it should have the correct return type
        assertTrue(component.isMethodReturnType(void.class, "setSize", Dimension.class), "Method 'setSize' should return void");

        // and - it should have public access
        assertTrue(component.isMethodPublic("setSize", Dimension.class), "Method 'setSize' should be public");
    }

    @Test
    void task_1_3_shouldHaveParametrizedConstructor() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the parametrized constructor

        // then - it should exist
        assertTrue(component.hasConstructor(Point.class, Dimension.class),
                "Constructor is not defined as specified with parameters (Point, Dimension)");

        // and - it should have public access
        assertTrue(component.isConstructorPublic(Point.class, Dimension.class),
                "The constructor should be public");
    }

    @Test
    void task_1_4_shouldHaveToStringMethod() {

        // given - a UIComponent
        UIComponentProxy component = Fixtures.createComponent();

        // when - we check if it has the 'toString' method

        // then - it should exist
        assertTrue(component.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(component.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(component.isMethodPublic("toString"), "Method 'toString' should be public");
    }
}
