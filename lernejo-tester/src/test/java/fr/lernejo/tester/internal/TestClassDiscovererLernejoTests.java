package fr.lernejo.tester.internal;


import fr.lernejo.tester.api.TestMethod;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class TestClassDiscovererLernejoTests {

    public static void main(String[] args) throws NoSuchMethodException {
        /*TestClassDiscoverer testClassDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        List<TestClassDescription> result = testClassDiscoverer.listTestClasses();*/
       // System.out.print(result);
        TestClassDiscovererLernejoTests testClassDiscovererLernejoTests = new TestClassDiscovererLernejoTests();
        testClassDiscovererLernejoTests.list_Class_Test();

    }
   @TestMethod
    public void list_Class_Test() throws NoSuchMethodException {
        TestClassDiscoverer testClassDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        List<TestClassDescription> result = testClassDiscoverer.listTestClasses();
        Assertions.assertThat(result).as("contains 3 elements")
            .size()
            .isEqualTo(3);
    }
}
