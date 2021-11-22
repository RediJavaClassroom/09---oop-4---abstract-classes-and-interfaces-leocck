package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step3Tests {

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
    void task_1_0_shouldDefineUILabelClass() {

        // given - a class we want the students to implement
        UILabelProxy label;

        // when - we check if it exists
        label = Fixtures.createLabel();

        // then - it should exist
        assertTrue(label.existsClass(), "UILabel class is not defined");

        // and - it should extend UIComponent
        UIComponentProxy component = Fixtures.createComponent();
        assertTrue(label.extendsClass(component.getTargetClassName()), "UILabel must extend UIComponent");
    }

    @Test
    void task_1_1_shouldHaveTextProperty() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'text' property

        // then - it should exist
        assertTrue(label.hasProperty("text"), "Property 'text' is not defined");

        // and - it should have the correct type
        assertTrue(label.isPropertyOfType("text", String.class), "Property 'text' should be a String");

        // and - it should have private access
        assertTrue(label.isPropertyPrivate("text"), "Property 'text' should have private access");
    }

    @Test
    void task_1_1_shouldHaveGetterForText() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'getText' method

        // then - it should exist
        assertTrue(label.hasMethod("getText"), "Method 'getText' is not defined");

        // and - it should have the correct return type
        assertTrue(label.isMethodReturnType(String.class, "getText"), "Method 'getText' should return a String");

        // and - it should have public access
        assertTrue(label.isMethodPublic("getText"), "Method 'getText' should be public");
    }

    @Test
    void task_1_1_shouldHaveSetterForText() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'setText' method

        // then - it should exist
        assertTrue(label.hasMethod("setText", String.class), "Method 'setText' is not defined");

        // and - it should have the correct return type
        assertTrue(label.isMethodReturnType(void.class, "setText", String.class), "Method 'setText' should return void");

        // and - it should have public access
        assertTrue(label.isMethodPublic("setText", String.class), "Method 'setText' should be public");
    }

    @Test
    void task_1_2_shouldHaveFontProperty() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'font' property

        // then - it should exist
        assertTrue(label.hasProperty("font"), "Property 'font' is not defined");

        // and - it should have the correct type
        assertTrue(label.isPropertyOfType("font", FontConfiguration.class), "Property 'font' should be a FontConfiguration");

        // and - it should have private access
        assertTrue(label.isPropertyPrivate("font"), "Property 'font' should have private access");
    }

    @Test
    void task_1_2_shouldHaveGetterForFont() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'getFont' method

        // then - it should exist
        assertTrue(label.hasMethod("getFont"), "Method 'getFont' is not defined");

        // and - it should have the correct return type
        assertTrue(label.isMethodReturnType(FontConfiguration.class, "getFont"), "Method 'getFont' should return a FontConfiguration");

        // and - it should have public access
        assertTrue(label.isMethodPublic("getFont"), "Method 'getFont' should be public");
    }

    @Test
    void task_1_2_shouldHaveSetterForFont() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'setFont' method

        // then - it should exist
        assertTrue(label.hasMethod("setFont", FontConfiguration.class), "Method 'setFont' is not defined");

        // and - it should have the correct return type
        assertTrue(label.isMethodReturnType(void.class, "setFont", FontConfiguration.class), "Method 'setFont' should return void");

        // and - it should have public access
        assertTrue(label.isMethodPublic("setFont", FontConfiguration.class), "Method 'setFont' should be public");
    }

    @Test
    void task_1_3_shouldHaveParametrizedConstructor() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the parametrized constructor

        // then - it should exist
        assertTrue(label.hasConstructor(Point.class, Dimension.class, String.class, FontConfiguration.class),
                "Constructor is not defined with parameters (Point, Dimension, String, FontConfiguration)");

        // and - it should have public access
        assertTrue(label.isConstructorPublic(Point.class, Dimension.class, String.class, FontConfiguration.class),
                "The constructor should be public");
    }

    @Test
    void task_1_4_shouldHaveToStringMethod() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'toString' method
        String result = label.toString();

        // then - it should exist
        assertTrue(label.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(label.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(label.isMethodPublic("toString"), "Method 'toString' should be public");

        // and - it should contain all properties in the returned value
        assertTrue(result.contains("position"), "The name of the property 'position' should be present in the returned String");
        assertTrue(result.contains(label.getPosition().toString()), "The value of the property 'position' should be present in the returned String");
        assertTrue(result.contains("size"), "The name of the property 'size' should be present in the returned String");
        assertTrue(result.contains(label.getSize().toString()), "The value of the property 'size' should be present in the returned String");
        assertTrue(result.contains("text"), "The name of the property 'text' should be present in the returned String");
        assertTrue(result.contains(label.getText()), "The value of the property 'text' should be present in the returned String");
        assertTrue(result.contains("font"), "The name of the property 'font' should be present in the returned String");
        assertTrue(result.contains(""+label.getFont()), "The value of the property 'font' should be present in the returned String");
    }

    @Test
    void task_2_0_shouldImplementDisplayable() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it implements the 'Displayable' interface
        DisplayableProxy displayable = Fixtures.createDisplayable();

        // then - it should
        assertTrue(label.implementsInterface(displayable.getTargetClass()), "UILabel should implement the Displayable interface");
    }

    @Test
    void task_2_0_shouldHaveDrawMethod() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it has the 'draw' method

        // then - it should exist
        assertTrue(label.hasMethod("draw"), "Method 'draw' is not defined");

        // and - it should have the correct return type
        assertTrue(label.isMethodReturnType(void.class, "draw"), "Method 'draw' should return void");

        // and - it should have public access
        assertTrue(label.isMethodPublic("draw"), "Method 'draw' should be public");
    }

    @Test
    void task_2_0_shouldImplementDrawMethod() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we call the 'draw' method
        label.draw();

        // then - it should print something to the console
        String output = outputStream.toString().strip();
        assertNotNull(output, "The 'draw' implementation should print something to the console");
        assertNotNull(label.getText(), "The 'draw' implementation should print something to the console");
        assertTrue(output.contains(label.getText()), "The 'draw' output should include the value of the 'text' property");
    }

    @Test
    void task_3_0_shouldDefineInterfaceClickListener() {

        // given - an interface we want the students to implement
        FontContainerProxy fontContainer;

        // when - we check if it exists
        fontContainer = Fixtures.createFontContainer();

        // then - it should exist
        assertTrue(fontContainer.existsClass(), "FontContainer interface is not defined");

        // and - it should be an interface
        assertTrue(fontContainer.isInterface(), "FontContainer must be an interface");
    }

    @Test
    void task_3_1_shouldDefineGetFontMethod() {

        // given - the FontContainer interface
        FontContainerProxy fontContainer = Fixtures.createFontContainer();

        // when - we check if it has the 'getFont' method definition

        // then - it should exist
        assertTrue(fontContainer.hasMethod("getFont"), "Method 'getFont' is not defined");

        // and - it should be abstract
        assertTrue(fontContainer.isMethodAbstract("getFont"), "Method 'getFont' must be abstract");

        // and - it should have the correct return type
        assertTrue(fontContainer.isMethodReturnType(FontConfiguration.class, "getFont"), "Method 'getFont' should return FontConfiguration");

        // and - it should have public access
        assertTrue(fontContainer.isMethodPublic("getFont"), "Method 'getFont' should be public");
    }

    @Test
    void task_3_2_shouldImplementClickListener() {

        // given - a UILabel
        UILabelProxy label = Fixtures.createLabel();

        // when - we check if it implements the 'ClickListener' interface
        FontContainerProxy fontContainer = Fixtures.createFontContainer();

        // then - it should
        assertTrue(label.implementsInterface(fontContainer.getTargetClass()), "UIButton should implement the Displayable interface");
    }
}
