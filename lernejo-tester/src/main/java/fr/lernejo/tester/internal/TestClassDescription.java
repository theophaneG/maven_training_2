package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassDescription {
    private final Class<?> TestClass ;

    public TestClassDescription(Class<?> testClass) {
        TestClass = testClass;
    }

    public List<Method> listTestMethods(){
        return Arrays.stream(TestClass.getDeclaredMethods())
            .filter(method -> Modifier.isPublic((method.getModifiers())))
            .filter(method -> method.getReturnType().equals(Void.TYPE))
            .filter(method -> method.getParameterCount() == 0)
            .filter(method -> method.isAnnotationPresent(TestMethod.class))
            .collect(Collectors.toList()) ;
    }

}
