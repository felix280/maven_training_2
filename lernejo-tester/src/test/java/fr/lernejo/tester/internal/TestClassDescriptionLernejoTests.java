package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescriptionLernejoTests {

        public static void main(String[] args) {
            TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
            List<Method> listMethod = testClassDescription.listTestMethods();
            for(Method test : listMethod){
                System.out.println(test);
            }

        }
        @Test
        void list_Methods_Test() throws NoSuchMethodException {
            TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
            SomeLernejoTests someLernejoTests = new SomeLernejoTests();
            List<Method> result = testClassDescription.listTestMethods();
            List<Method> ListMethod = new ArrayList<>();
            ListMethod.add(someLernejoTests.getClass().getMethod("ok", null));
            ListMethod.add(someLernejoTests.getClass().getMethod("ko", null));
            Assertions.assertThat(result).as("contains ok and ko")
                .isEqualTo(ListMethod); // (3)
        }
}
