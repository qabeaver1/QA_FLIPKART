package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class wrapperMethods {

    WebDriver driver;  
    static WebDriverWait wait;
    static JavascriptExecutor js;

    public wrapperMethods(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;        
        System.out.println("Constructor: wrapperMethods");
    }

    public void click(WebElement elementToClick) {
        try {
            if (elementToClick != null && elementToClick.isDisplayed()) {
                // Initialize the webdriver wait
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                // Wait till the element is visible
                wait.until(ExpectedConditions.visibilityOf(elementToClick));
                elementToClick.click();
                Thread.sleep(3000);
                
            } else {
                System.out.println("Element is not displayed ");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking: ");
            e.printStackTrace();
        }
    }

    public void sendKeys(WebElement inputBox, String keysToSend) {
        try {
            if (inputBox != null && inputBox.isDisplayed()) {
                 // Initialize the webdriver wait
                 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                 // Wait till the element is visible
                wait.until(ExpectedConditions.visibilityOf(inputBox));
                inputBox.clear();
                inputBox.sendKeys(keysToSend);
                Thread.sleep(1000);
               

            } else {
                System.out.println("Input box is not displayed ");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while sending keys: " + e.getMessage());
        }
    }


    public List<WebElement> findElements(By locator) {

        List<WebElement> elements = new ArrayList<>();
        try {
            List<WebElement> foundElements = driver.findElements(locator);

            for (WebElement element : foundElements) {
                if (element.isDisplayed()) {
                    elements.add(element);
                } else {
                    System.out.println("Element found but not displayed: " + locator.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while finding elements: " + e.getMessage());
        }
        return elements;
    }

}
