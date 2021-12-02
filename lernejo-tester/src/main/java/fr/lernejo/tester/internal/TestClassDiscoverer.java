package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    private final String PackageName;

    public TestClassDiscoverer(String PackageName){
            this.PackageName = PackageName;
        }
    public List<TestClassDescription> listTestClasses(){
        List<TestClassDescription> list = new ArrayList<>();
        Reflections reflections = new Reflections(PackageName, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        for (Class<?> type : allTypes){
            Method[] methods = type.getMethods();
            for(Method method : methods){
                if(type.getName().endsWith("LernejoTests") && method.getAnnotation(TestMethod.class) != null ){
                    list.add(new TestClassDescription(type));
                    break;
                }

            }

        }
        return list;
    }
}
