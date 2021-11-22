package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.ClickListenerProxy;
import com.redi.j2.proxies.DisplayableProxy;
import com.redi.j2.proxies.UIButtonProxy;
import com.redi.j2.proxies.UIComponentProxy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Step2Tests {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() throws IOException {
        outputStream.close();
    }

    @Test
    void task_1_0_shouldDefineUIButtonClass() {

        // given - a class we want the students to implement
        UIButtonProxy button;

        // when - we check if it exists
        button = Fixtures.createButton();

        // then - it should exist
        assertTrue(button.existsClass(), "UIButton class is not defined");

        // and - it should extend UIComponent
        UIComponentProxy component = Fixtures.createComponent();
        assertTrue(button.extendsClass(component.getTargetClassName()), "UIButton must extend UIComponent");
    }

    @Test
    void task_1_1_shouldHaveTextProperty() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'text' property

        // then - it should exist
        assertTrue(button.hasProperty("text"), "Property 'text' is not defined");

        // and - it should have the correct type
        assertTrue(button.isPropertyOfType("text", String.class), "Property 'text' should be a String");

        // and - it should have private access
        assertTrue(button.isPropertyPrivate("text"), "Property 'text' should have private access");
    }

    @Test
    void task_1_1_shouldHaveGetterForText() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'getText' method

        // then - it should exist
        assertTrue(button.hasMethod("getText"), "Method 'getText' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(String.class, "getText"), "Method 'getText' should return a String");

        // and - it should have public access
        assertTrue(button.isMethodPublic("getText"), "Method 'getText' should be public");
    }

    @Test
    void task_1_1_shouldHaveSetterForText() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'setText' method

        // then - it should exist
        assertTrue(button.hasMethod("setText", String.class), "Method 'setText' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(void.class, "setText", String.class), "Method 'setText' should return void");

        // and - it should have public access
        assertTrue(button.isMethodPublic("setText", String.class), "Method 'setText' should be public");
    }

    @Test
    void task_1_2_shouldHaveEnabledProperty() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'enabled' property

        // then - it should exist
        assertTrue(button.hasProperty("enabled"), "Property 'enabled' is not defined");

        // and - it should have the correct type
        assertTrue(button.isPropertyOfType("enabled", boolean.class), "Property 'enabled' should be a boolean");

        // and - it should have private access
        assertTrue(button.isPropertyPrivate("enabled"), "Property 'enabled' should have private access");
    }

    @Test
    void task_1_2_shouldNotHaveGetterForEnabled() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'getEnabled' method

        // then - it should NOT exist
        assertFalse(button.hasMethod("getEnabled"), "Method 'getEnabled' should not be defined");
    }

    @Test
    void task_1_2_shouldNotHaveSetterForEnabled() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'setEnabled' method

        // then - it should NOT exist
        assertFalse(button.hasMethod("setEnabled", boolean.class), "Method 'setEnabled' should not be defined");
    }

    @Test
    void task_1_3_shouldHaveParametrizedConstructor() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the parametrized constructor

        // then - it should exist
        assertTrue(button.hasConstructor(Point.class, Dimension.class, String.class, boolean.class),
                "Constructor is not defined with parameters (Point, Dimension, String, boolean)");

        // and - it should have public access
        assertTrue(button.isConstructorPublic(Point.class, Dimension.class, String.class, boolean.class),
                "The constructor should be public");
    }

    @Test
    void task_1_4_shouldHaveEnableMethod() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'enable' method

        // then - it should exist
        assertTrue(button.hasMethod("enable"), "Method 'enable' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(void.class, "enable"), "Method 'enable' should return void");

        // and - it should have public access
        assertTrue(button.isMethodPublic("enable"), "Method 'enable' should be public");
    }

    @Test
    void task_1_4_shouldHaveDisableMethod() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'disable' method

        // then - it should exist
        assertTrue(button.hasMethod("disable"), "Method 'disable' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(void.class, "disable"), "Method 'disable' should return void");

        // and - it should have public access
        assertTrue(button.isMethodPublic("disable"), "Method 'disable' should be public");
    }

    @Test
    void task_1_4_shouldHaveIsEnabledMethod() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'isEnabled' method

        // then - it should exist
        assertTrue(button.hasMethod("isEnabled"), "Method 'isEnabled' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(boolean.class, "isEnabled"), "Method 'isEnabled' should return a boolean");

        // and - it should have public access
        assertTrue(button.isMethodPublic("isEnabled"), "Method 'isEnabled' should be public");
    }

    @Test
    void task_1_4_shouldImplementEnableMethod() {

        // given - a disabled UIButton
        UIButtonProxy button = Fixtures.createButton(null, null, null, false);

        // when - we enable the button
        button.enable();

        // then - the property should be set to true
        assertTrue(button.isEnabled(), "After calling 'enable', the method 'isEnabled' should return true");
    }

    @Test
    void task_1_4_shouldImplementDisableMethod() {

        // given - an enabled UIButton
        UIButtonProxy button = Fixtures.createButton(null, null, null, true);

        // when - we disable the button
        button.disable();

        // then - the property should be set to false
        assertFalse(button.isEnabled(), "After calling 'disable', the method 'isEnabled' should return false");
    }

    @Test
    void task_1_5_shouldHaveToStringMethod() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'toString' method
        String result = button.toString();

        // then - it should exist
        assertTrue(button.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(button.isMethodPublic("toString"), "Method 'toString' should be public");

        // and - it should contain all properties in the returned value
        assertTrue(result.contains("position"), "The name of the property 'position' should be present in the returned String");
        assertTrue(result.contains(button.getPosition().toString()), "The value of the property 'position' should be present in the returned String");
        assertTrue(result.contains("size"), "The name of the property 'size' should be present in the returned String");
        assertTrue(result.contains(button.getSize().toString()), "The value of the property 'size' should be present in the returned String");
        assertTrue(result.contains("text"), "The name of the property 'text' should be present in the returned String");
        assertTrue(result.contains(button.getText()), "The value of the property 'text' should be present in the returned String");
        assertTrue(result.contains("enabled"), "The name of the property 'enabled' should be present in the returned String");
        assertTrue(result.contains(""+button.getEnabled()), "The value of the property 'enabled' should be present in the returned String");
    }

    @Test
    void task_2_0_shouldDefineInterfaceDisplayable() {

        // given - an interface we want the students to implement
        DisplayableProxy displayable;

        // when - we check if it exists
        displayable = Fixtures.createDisplayable();

        // then - it should exist
        assertTrue(displayable.existsClass(), "Displayable interface is not defined");

        // and - it should be an interface
        assertTrue(displayable.isInterface(), "Displayable must be an interface");
    }

    @Test
    void task_2_1_shouldDefineDrawMethod() {

        // given - the Displayable interface
        DisplayableProxy displayable = Fixtures.createDisplayable();

        // when - we check if it has the 'draw' method definition

        // then - it should exist
        assertTrue(displayable.hasMethod("draw"), "Method 'draw' is not defined");

        // and - it should be abstract
        assertTrue(displayable.isMethodAbstract("draw"), "Method 'draw' must be abstract");

        // and - it should have the correct return type
        assertTrue(displayable.isMethodReturnType(void.class, "draw"), "Method 'draw' should return void");

        // and - it should have public access
        assertTrue(displayable.isMethodPublic("draw"), "Method 'draw' should be public");
    }

    @Test
    void task_2_2_shouldImplementDisplayable() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it implements the 'Displayable' interface
        DisplayableProxy displayable = Fixtures.createDisplayable();

        // then - it should
        assertTrue(button.implementsInterface(displayable.getTargetClass()), "UIButton should implement the Displayable interface");
    }

    @Test
    void task_2_2_shouldHaveDrawMethod() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'draw' method

        // then - it should exist
        assertTrue(button.hasMethod("draw"), "Method 'draw' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(void.class, "draw"), "Method 'draw' should return void");

        // and - it should have public access
        assertTrue(button.isMethodPublic("draw"), "Method 'draw' should be public");
    }

    @Test
    void task_2_2_shouldImplementDrawMethod() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we call the 'draw' method
        button.draw();

        // then - it should print something to the console
        String output = outputStream.toString().strip();
        assertNotNull(output, "The 'draw' implementation should print something to the console");
        assertNotNull(button.getText(), "The 'draw' implementation should print something to the console");
        assertTrue(output.contains(button.getText()), "The 'draw' output should include the value of the 'text' property");
    }

    @Test
    void task_3_0_shouldDefineInterfaceClickListener() {

        // given - an interface we want the students to implement
        ClickListenerProxy clickListener;

        // when - we check if it exists
        clickListener = Fixtures.createClickListener();

        // then - it should exist
        assertTrue(clickListener.existsClass(), "ClickListener interface is not defined");

        // and - it should be an interface
        assertTrue(clickListener.isInterface(), "ClickListener must be an interface");
    }

    @Test
    void task_3_1_shouldDefineOnClickEventMethod() {

        // given - the ClickListener interface
        ClickListenerProxy clickListener = Fixtures.createClickListener();

        // when - we check if it has the 'onClickEvent' method definition

        // then - it should exist
        assertTrue(clickListener.hasMethod("onClickEvent"), "Method 'onClickEvent' is not defined");

        // and - it should be abstract
        assertTrue(clickListener.isMethodAbstract("onClickEvent"), "Method 'onClickEvent' must be abstract");

        // and - it should have the correct return type
        assertTrue(clickListener.isMethodReturnType(void.class, "onClickEvent"), "Method 'onClickEvent' should return void");

        // and - it should have public access
        assertTrue(clickListener.isMethodPublic("onClickEvent"), "Method 'onClickEvent' should be public");
    }

    @Test
    void task_3_2_shouldImplementClickListener() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it implements the 'ClickListener' interface
        ClickListenerProxy clickListener = Fixtures.createClickListener();

        // then - it should
        assertTrue(button.implementsInterface(clickListener.getTargetClass()), "UIButton should implement the Displayable interface");
    }

    @Test
    void task_3_2_shouldHaveOnClickEventMethod() {

        // given - a UIButton
        UIButtonProxy button = Fixtures.createButton();

        // when - we check if it has the 'onClickEvent' method

        // then - it should exist
        assertTrue(button.hasMethod("onClickEvent"), "Method 'onClickEvent' is not defined");

        // and - it should have the correct return type
        assertTrue(button.isMethodReturnType(void.class, "onClickEvent"), "Method 'onClickEvent' should return void");

        // and - it should have public access
        assertTrue(button.isMethodPublic("onClickEvent"), "Method 'onClickEvent' should be public");
    }

    @Test
    void task_3_2_shouldReactToClickEventIfEnabled() {

        // given - an enabled UIButton
        UIButtonProxy button = Fixtures.createButton(null, null, null, true);

        // when - we call the 'onClickEvent' method
        button.onClickEvent();

        // then - it should print something to the console
        String output = outputStream.toString().strip();
        assertNotNull(output, "The 'onClickEvent' implementation should print something to the console when the button is enabled");
    }

    @Test
    void task_3_2_shouldNotReactToClickEventIfDisabled() {

        // given - a disabled UIButton
        UIButtonProxy button = Fixtures.createButton(null, null, null, false);

        // when - we call the 'onClickEvent' method
        button.onClickEvent();

        // then - it should not print anything on the console
        String output = outputStream.toString().strip();
        assertTrue(output == null || "".equals(output), "The 'onClickEvent' implementation must do nothing when the button is disabled");
    }
}
