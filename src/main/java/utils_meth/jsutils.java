package utils_meth;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jsutils
{
    private WebDriver driver;
    private JavascriptExecutor jse;
    private utiles_methods utiles_methods;

    public jsutils(WebDriver driver)
    {
        this.driver = driver;
        jse=(JavascriptExecutor) this.driver;
        utiles_methods=new utiles_methods(this.driver);
    }
    public void drawborder(By locator)
    {
        jse.executeScript("arguments[0].style.border= '3px solid red'" ,utiles_methods.getWebElement(locator));
    }

//    public void drawborder(WebElement ele) {
//    }
}
