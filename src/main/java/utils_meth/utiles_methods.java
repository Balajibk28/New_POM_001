package utils_meth;

import driver.fac.Dri_fac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class utiles_methods
{
    public WebDriver driver;
    public jsutils jsutils;

    public utiles_methods  (WebDriver driver)
    {
        this.driver= driver;
        jsutils=new jsutils(this.driver);
    }

    public void do_sendkeys(By locator,String data)
    {
        WebElement ele=getWebElement(locator);
        if(!getTextbox_value(locator).equals(""))
        {
            ele.clear();
        }
        else
        {
            ele.sendKeys(data);
        }
    }

    public void do_click(By locator)
    {
        getWebElement(locator).click();
    }

    public String doGetText(By locator)
    {
        return getWebElement(locator).getText().trim();
    }

    public List<String> doGetTexts(By locator)
    {
        List<WebElement> elementList=getWebElements(locator);
        List<String> texts= new ArrayList<>();

        for (WebElement ele:elementList)
        {
            texts.add(ele.getText());
        }

       return texts;
    }

    public String geturl(By locator)
    {
        return driver.getCurrentUrl();
    }

    public boolean isElementsDisplayed(By locator)
    {
        return getWebElement(locator).isDisplayed();
    }

    public WebElement getWebElement(By locator)
    {
        if (Boolean.parseBoolean(Dri_fac.doborder))
        {
            jsutils.drawborder(locator);
        }
        return driver.findElement(locator);
    }
    public List<WebElement> getWebElements(By locator)
    {
        return driver.findElements(locator);
    }
    public String getTextbox_value(By locator)
    {
        return getWebElement(locator).getAttribute("Value");
    }

}
