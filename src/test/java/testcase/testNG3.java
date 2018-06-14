package testcase;

import org.testng.annotations.*;

public class testNG3 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass3");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass3");
    }
}
