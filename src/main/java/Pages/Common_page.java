package Pages;

import driver.fac.Dri_fac;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class Common_page
{
    public Dri_fac dri_fac;
    public WebDriver driver;
    public Properties prop;
    private Dri_fac Dri_fac;

    @BeforeTest
    public void be_test()
    {
            Dri_fac =new Dri_fac();
            prop=Dri_fac.init_prop();
            driver=Dri_fac.init_web_driver(prop);
    }

    @Test
    public void test_1()
    {
        System.out.println("test_1");
    }

//    @AfterTest
//    public void ae_test()
//    {
//        driver.quit();
//    }

}
