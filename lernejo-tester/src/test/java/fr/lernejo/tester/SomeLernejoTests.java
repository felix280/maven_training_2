package fr.lernejo.tester;
import fr.lernejo.tester.api.TestMethod;

import java.lang.IllegalStateException;

public class SomeLernejoTests {

    @TestMethod
    public void ok(){

    }
    @TestMethod
    public void ko(){
        throw new IllegalStateException();
    }

    public void none(){

    }

}
