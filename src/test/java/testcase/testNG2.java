package testcase;

import org.testng.annotations.*;

public class testNG2 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass2");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass2");
    }
}
