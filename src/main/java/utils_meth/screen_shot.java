package utils_meth;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class screen_shot
{
    private WebDriver driver;
    private TakesScreenshot tks;

    public screen_shot(WebDriver driver)
    {
        this.driver=driver;
        tks=(TakesScreenshot) this.driver;
    }

    public void Screenshotlocation(String fileName)
    {
        File temp =tks.getScreenshotAs( OutputType.FILE);
        try {
            FileUtils.copyFile(temp, new File("./ScreenShorts"+fileName+System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
