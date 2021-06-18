import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;
import fr.lernejo.tester.internal.TestClassDescription;
import org.assertj.core.api.Assertions;


import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {

    @TestMethod
    public void test_class_annotated_filter(){
        TestClassDescription description = new TestClassDescription(SomeLernejoTests.class);
        List<Method> methods = description.listTestMethods();
        Assertions.assertThat(methods)
            .extracting(method -> method.getName())
            .containsExactlyInAnyOrder("ok","ko");

    }
    public static void main (String[] args) {
        new TestClassDescriptionLernejoTests().test_class_annotated_filter();
    }
}
