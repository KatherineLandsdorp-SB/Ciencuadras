import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.Services;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

public class TestClass {
//    private static Services methods = new Services();

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add("src/test/java/resources/suite.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}
