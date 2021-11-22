package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Step4Tests {

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
    void task_1_0_shouldDefineUIContainerClass() {

        // given - a class we want the students to implement
        UIContainerProxy container;

        // when - we check if it exists
        container = Fixtures.createContainer();

        // then - it should exist
        assertTrue(container.existsClass(), "UIContainer class is not defined");

        // and - it should be abstract
        assertTrue(container.isAbstract(), "UIContainer should be abstract");
    }

    @Test
    void task_1_1_shouldExtendUIComponent() {

        // given - a class we want the students to implement
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it extends the UIComponent class
        UIComponentProxy component = Fixtures.createComponent();

        // then - it should
        assertTrue(container.extendsClass(component.getTargetClassName()), "UIContainer must extend UIComponent");
    }

    @Test
    void task_1_2_shouldHaveChildrenProperty() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'children' property

        // then - it should exist
        assertTrue(container.hasProperty("children"), "Property 'children' is not defined");

        // and - it should have the correct type
        UIComponentProxy component = Fixtures.createComponent();
        assertTrue(container.isPropertyOfType("children", List.class, component.getTargetClass()), "Property 'children' should be a List<UIComponent>");

        // and - it should have private access
        assertTrue(container.isPropertyPrivate("children"), "Property 'children' should have private access");
    }

    @Test
    void task_1_2_shouldHaveGetterForChildren() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'getChildren' method

        // then - it should exist
        assertTrue(container.hasMethod("getChildren"), "Method 'getChildren' is not defined");

        // and - it should have the correct return type
        UIComponentProxy component = Fixtures.createComponent();
        assertTrue(container.isMethodReturnType(List.class, component.getTargetClass(), "getChildren"), "Method 'getChildren' should return a List<UIComponent>");

        // and - it should have public access
        assertTrue(container.isMethodPublic("getChildren"), "Method 'getChildren' should be public");
    }

    @Test
    void task_1_2_shouldHaveSetterForChildren() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'setChildren' method

        // then - it should exist
        assertTrue(container.hasMethod("setChildren", List.class), "Method 'setChildren' is not defined");

        // and - it should have the correct return type
        assertTrue(container.isMethodReturnType(void.class, "setChildren", List.class), "Method 'setChildren' should return void");

        // and - it should have public access
        assertTrue(container.isMethodPublic("setChildren", List.class), "Method 'setChildren' should be public");
    }

    @Test
    void task_1_3_shouldHaveParametrizedConstructor() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the parametrized constructor

        // then - it should exist
        assertTrue(container.hasConstructor(Point.class, Dimension.class),
                "Constructor is not defined as specified with parameters (Point, Dimension)");

        // and - it should have public access
        assertTrue(container.isConstructorPublic(Point.class, Dimension.class),
                "The constructor should be public");
    }

    @Test
    void task_1_3_shouldInitializeChildrenList() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we get the children list
        List<Object> children = container.getChildren();

        // then - the list is initialized
        assertNotNull(children, "List of children must be initialized");
        assertEquals(0, children.size(), "List of children must start empty");
    }

    @Test
    void task_1_4_shouldHaveAddComponentMethod() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'addComponent' method

        // then - it should exist
        Class<?> componentClass = Fixtures.createComponent().getTargetClass();
        assertTrue(container.hasMethod("addComponent", componentClass), "Method 'addComponent' is not defined");

        // and - it should have the correct return type
        assertTrue(container.isMethodReturnType(void.class, "addComponent", componentClass), "Method 'addComponent' should return void");

        // and - it should have public access
        assertTrue(container.isMethodPublic("addComponent", componentClass), "Method 'addComponent' should be public");
    }

    @Test
    void task_1_4_shouldImplementAddComponentLogic() {

        // given - an empty UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we add components to it
        container.addComponent(Fixtures.createComponent());
        container.addComponent(Fixtures.createComponent());

        // then - the components are added to the children list property
        assertNotNull(container.getChildren(), "The container must have a children property");
        assertEquals(2, container.getChildren().size(), "The method 'addComponent' must add the component to the children list");
    }

    @Test
    void task_1_4_shouldHaveRemoveComponentMethod() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'removeComponent' method

        // then - it should exist
        Class<?> componentClass = Fixtures.createComponent().getTargetClass();
        assertTrue(container.hasMethod("removeComponent", componentClass), "Method 'removeComponent' is not defined");

        // and - it should have the correct return type
        assertTrue(container.isMethodReturnType(void.class, "removeComponent", componentClass), "Method 'removeComponent' should return void");

        // and - it should have public access
        assertTrue(container.isMethodPublic("removeComponent", componentClass), "Method 'removeComponent' should be public");
    }

    @Test
    void task_1_4_shouldImplementRemoveComponentLogic() {

        // given - a UIContainer with some components
        UIContainerProxy container = Fixtures.createContainer();
        UIComponentProxy c1 = Fixtures.createComponent();
        UIComponentProxy c2 = Fixtures.createComponent();
        container.addComponent(c1);
        container.addComponent(c2);

        // when - we remove components from it
        container.removeComponent(c1);

        // then - the component is removed from the list of children
        assertNotNull(container.getChildren(), "The container class must have a list of children components");
        assertEquals(1, container.getChildren().size(), "The method 'removeComponent' must remove the component from the children list");
        assertEquals(c2.getTarget(), container.getChildren().get(0), "The method 'removeComponent' must remove the correct component");
    }

    @Test
    void task_1_5_shouldHaveToStringMethod() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'toString' method
        String result = container.toString();

        // then - it should exist
        assertTrue(container.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(container.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(container.isMethodPublic("toString"), "Method 'toString' should be public");

        // and - it should contain all properties in the returned value
        assertTrue(result.contains("position"), "The name of the property 'position' should be present in the returned String");
        assertTrue(result.contains(container.getPosition().toString()), "The value of the property 'position' should be present in the returned String");
        assertTrue(result.contains("size"), "The name of the property 'size' should be present in the returned String");
        assertTrue(result.contains(container.getSize().toString()), "The value of the property 'size' should be present in the returned String");
        assertTrue(result.contains("children"), "The name of the property 'children' should be present in the returned String");
        assertTrue(result.contains(container.getChildren().toString()), "The value of the property 'children' should be present in the returned String");
    }

    @Test
    void task_2_0_shouldImplementDisplayable() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it implements the 'Displayable' interface
        DisplayableProxy displayable = Fixtures.createDisplayable();

        // then - it should
        assertTrue(container.implementsInterface(displayable.getTargetClass()), "UIContainer should implement the Displayable interface");
    }

    @Test
    void task_2_1_shouldDefineDrawSelfMethod() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'drawSelf' method definition

        // then - it should exist
        assertTrue(container.hasMethod("drawSelf"), "Method 'drawSelf' is not defined");

        // and - it should be abstract
        assertTrue(container.isMethodAbstract("drawSelf"), "Method 'drawSelf' must be abstract");

        // and - it should have the correct return type
        assertTrue(container.isMethodReturnType(void.class, "drawSelf"), "Method 'drawSelf' should return void");

        // and - it should have public access
        assertTrue(container.isMethodProtected("drawSelf"), "Method 'drawSelf' should be protected");
    }

    @Test
    void task_2_2_shouldHaveDrawMethod() {

        // given - a UIContainer
        UIContainerProxy container = Fixtures.createContainer();

        // when - we check if it has the 'draw' method

        // then - it should exist
        assertTrue(container.hasMethod("draw"), "Method 'draw' is not defined");

        // and - it should have the correct return type
        assertTrue(container.isMethodReturnType(void.class, "draw"), "Method 'draw' should return void");

        // and - it should have public access
        assertTrue(container.isMethodPublic("draw"), "Method 'draw' should be public");
    }

    @Test
    void task_2_2_shouldImplementDrawLogic() throws Exception {

        // given - a UIContainer with some components
        UIContainerProxy container = Fixtures.createContainer();
        UIComponentProxy c1 = Fixtures.createComponent();
        UIComponentProxy c2 = Fixtures.createDisplayableComponent();
        container.addComponent(c1);
        container.addComponent(c2);

        // when - we call the draw function from the container
        container.draw();

        // then - the method calls the drawSelf function
        assertNotNull(container.getTarget(), "The container class should exist");
        assertMethodInvoked(container.getTarget(), "drawSelf", 1);

        // and - the method calls the 'draw' function of all Displayable components
        assertMethodInvoked(c1.getTarget(), "draw", 0);
        assertMethodInvoked(c2.getTarget(), "draw", 1);
    }

    @Test
    void task_3_0_shouldDefineUIWindowClass() {

        // given - a class we want the students to implement
        UIWindowProxy window;

        // when - we check if it exists
        window = Fixtures.createWindow();

        // then - it should exist
        assertTrue(window.existsClass(), "UIWindow class is not defined");
    }

    @Test
    void task_3_1_shouldExtendUIContainerClass() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we check if it implements the UIContainer class

        // then - it should do it
        UIContainerProxy container = Fixtures.createContainer();
        assertTrue(window.extendsClass(container.getTargetClassName()), "UIWindow must extend UIContainer");
    }

    @Test
    void task_3_2_shouldHaveTitleProperty() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we check if it has the 'title' property

        // then - it should exist
        assertTrue(window.hasProperty("title"), "Property 'title' is not defined");

        // and - it should have the correct type
        assertTrue(window.isPropertyOfType("title", String.class), "Property 'title' should be a String");

        // and - it should have private access
        assertTrue(window.isPropertyPrivate("title"), "Property 'title' should have private access");
    }

    @Test
    void task_3_2_shouldHaveGetterForTitle() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we check if it has the 'getTitle' method

        // then - it should exist
        assertTrue(window.hasMethod("getTitle"), "Method 'getTitle' is not defined");

        // and - it should have the correct return type
        assertTrue(window.isMethodReturnType(String.class, "getTitle"), "Method 'getTitle' should return a String");

        // and - it should have public access
        assertTrue(window.isMethodPublic("getTitle"), "Method 'getTitle' should be public");
    }

    @Test
    void task_3_2_shouldHaveSetterForTitle() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we check if it has the 'setTitle' method

        // then - it should exist
        assertTrue(window.hasMethod("setTitle", String.class), "Method 'setTitle' is not defined");

        // and - it should have the correct return type
        assertTrue(window.isMethodReturnType(void.class, "setTitle", String.class), "Method 'setTitle' should return void");

        // and - it should have public access
        assertTrue(window.isMethodPublic("setTitle", String.class), "Method 'setTitle' should be public");
    }

    @Test
    void task_3_3_shouldHaveParametrizedConstructor() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we check if it has the parametrized constructor

        // then - it should exist
        assertTrue(window.hasConstructor(Point.class, Dimension.class, String.class),
                "Constructor is not defined with parameters (Point, Dimension, String)");

        // and - it should have public access
        assertTrue(window.isConstructorPublic(Point.class, Dimension.class, String.class),
                "The constructor should be public");
    }

    @Test
    void task_3_4_shouldHaveDrawSelfMethod() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we check if it has the 'drawSelf' method

        // then - it should exist
        assertTrue(window.hasMethod("drawSelf"), "Method 'drawSelf' is not defined");

        // and - it should have the correct return type
        assertTrue(window.isMethodReturnType(void.class, "drawSelf"), "Method 'drawSelf' should return void");

        // and - it should have public access
        assertTrue(window.isMethodProtected("drawSelf"), "Method 'drawSelf' should be protected");
    }

    @Test
    void task_3_4_shouldHaveToStringMethod() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we check if it has the 'toString' method
        String result = window.toString();

        // then - it should exist
        assertTrue(window.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(window.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(window.isMethodPublic("toString"), "Method 'toString' should be public");

        // and - it should contain all properties in the returned value
        assertTrue(result.contains("position"), "The name of the property 'position' should be present in the returned String");
        assertTrue(result.contains(window.getPosition().toString()), "The value of the property 'position' should be present in the returned String");
        assertTrue(result.contains("size"), "The name of the property 'size' should be present in the returned String");
        assertTrue(result.contains(window.getSize().toString()), "The value of the property 'size' should be present in the returned String");
        assertTrue(result.contains("title"), "The name of the property 'title' should be present in the returned String");
        assertTrue(result.contains(window.getTitle()), "The value of the property 'title' should be present in the returned String");
    }

    @Test
    void task_3_5_shouldImplementDrawSelfMethod() {

        // given - a UIWindow
        UIWindowProxy window = Fixtures.createWindow();

        // when - we call the 'drawSelf' method
        window.drawSelf();

        // then - it should print something to the console
        String output = outputStream.toString().strip();
        assertNotNull(output, "The 'drawSelf' implementation should print something to the console");
        assertNotNull(window.getTitle(), "The 'drawSelf' implementation should print something to the console");
        assertTrue(output.contains(window.getTitle()), "The 'drawSelf' output should include the value of the 'title' property");
    }

    private void assertMethodInvoked(Object object,
                                     String methodName,
                                     int times) throws Exception {
        final Method method;
        method = object.getClass().getDeclaredMethod(methodName);
        final Object verify = Mockito.verify(object, Mockito.times(times).description("Method '"+methodName+"' should be called "+times+" time(s)"));
        method.invoke(verify);
    }
}
