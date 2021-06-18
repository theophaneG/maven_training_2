package fr.lernejo.tester;

import fr.lernejo.tester.api.TestMethod;

public class SomeLernejoTests {
    @TestMethod
    public void ok(){

    }

    public void ko(){
        throw new IllegalStateException();

    }

    @TestMethod
    public void none(){

    }
}
