package testcase;

import org.testng.Assert;
import org.testng.annotations.*;

public class testNG {

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass1");
    }

    @Test
    public void test1(){
        System.out.println("case1");
        String realMessage = "ABC";
        String expectedMessage = "Abcd";
        Assert.assertTrue(realMessage.equalsIgnoreCase(expectedMessage),"Expect Message Not Find");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass1");
    }

}
