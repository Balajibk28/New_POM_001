package driver.fac;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Dri_fac
{

    private Properties prop;
    private WebDriver driver;
    public static String doborder;

    public WebDriver init_web_driver(Properties prop)
    {
        String browser= prop.getProperty("browser");
        doborder = prop.getProperty("border");

        switch (browser.toUpperCase())
        {
            case "CHROME":
            {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                break;
            }
            case "FIRE":
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default:
            {

                System.out.println("send me correct browser name");
            }


        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }

    public Properties init_prop()
    {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("config/config.Properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop;
    }

}
