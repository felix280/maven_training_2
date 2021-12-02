package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Modifier;

public class TestClassDescription {
    private final Class<?> nameClass;
    public TestClassDescription(Class<?> nameClass){
        this.nameClass = nameClass;
    }

    public List<Method> listTestMethods(){
        Method[] m = nameClass.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for(int i = 0; i < m.length; i++) {
            if((Modifier.isPublic(m[i].getModifiers()) || m[i].getReturnType().equals(Void.TYPE)) && m[i].getParameters().length == 0 && m[i].getAnnotation(TestMethod.class) != null ){
                list.add(m[i]);
            }

        }
        return list;
    }
}
