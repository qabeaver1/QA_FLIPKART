package demo;

import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases  {

    static ChromeDriver driver;
    static wrapperMethods utility;
    

    @BeforeSuite(alwaysRun = true)
    public static void driverSetUp() {
        System.out.println("Initializing : TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize utility here after driver setup
        //utility = new wrapperMethods(driver);
    }

    @BeforeClass
    public void setUp() {
        utility = new wrapperMethods(driver); // Initialize utility here after driver setup
    }

    @Test(priority = 1, enabled = true)

    public void testSearch_01() throws InterruptedException {

        try {
        System.out.println("Start Test case: Search for Washing Machine and print items with <=4 star ratings");

        // Go to www.flipkart.com
        driver.get("https://www.flipkart.com/");
        Thread.sleep(6000);

        // search for 'Washing Machine'
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        utility.click(searchBox);
        utility.sendKeys(searchBox, "Washing Machine");

        // click on search icon
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        utility.click(searchButton);

        // sort based on popularity
        WebElement popularity = driver.findElement(By.xpath("//div[text()='Popularity']"));
        utility.click(popularity);

        // Print the count of items with rating less than or equal to 4 stars
        List<WebElement> itemsInAPage = driver
                .findElements(By.xpath("//div[@class='col col-7-12']//descendant::div[@class='XQDdHH']"));
        int count = 0;
        for (WebElement item : itemsInAPage) {
            String rating_Star = item.getText();
            try {
                double ratingValue = Double.parseDouble(rating_Star);
                if (ratingValue <= 4.0) {
                    count++;
                }
            } catch (Exception e) {
                System.out.println("Invalid rating value: " + rating_Star);
            }
        }

        System.out.println("Number of items with rating <= 4 stars: " + count);
        Assert.assertTrue(count > 0, "No items found with rating <= 4 stars");

        System.out.println("End Test case: Printed the count successfully");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }       

    }

    @Test(priority = 2, enabled = true)

    public void testSearch_02() throws InterruptedException {

        try {
            
        System.out.println("Start Test case: Search for iPhone print the titles and discount % > than 17%");

        //be in the search page of flipkart
        driver.get("https://www.flipkart.com/search?");
        Thread.sleep(4000);

        // search for 'Washing Machine'
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='zDPmFV']"));
        utility.click(searchBox);
        utility.sendKeys(searchBox, "iPhone");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        utility.click(searchButton);

        // Get the titles of the iPhones
        List<WebElement> titles_InAPage = driver.findElements(By.xpath("//div[@class='yKfJKb row']/div[1]/div[1]"));

        // Get the discounts of the iPhones
        List<WebElement> discounts = driver
                .findElements(By.xpath("//div[@class='yKfJKb row']/div[2]/div/div[1]/div[3]/span"));

        int totalItemsInAPage = Math.min(titles_InAPage.size(), discounts.size());
        boolean itemFound = false;
        for (int j = 0; j < totalItemsInAPage; j++) {
            String discountText = discounts.get(j).getText();

            // Extract numeric value(22) from discount text (e.g., 22% off)
            StringBuilder sb = new StringBuilder();
            for (char c : discountText.toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }

            int discount_Value;

            if (sb.length() > 0) {
                discount_Value = Integer.parseInt(sb.toString());
            } else {
                discount_Value = 0;
            }
            //checking for discounts greater than 17
            if (discount_Value > 17) {
                itemFound = true;
                String title = titles_InAPage.get(j).getText();
                System.out.println("Title: " + title + " and Discount: " + discount_Value + "%");
                
            }
        }
        Assert.assertTrue(itemFound, "No items found with a discount greater than 17%");

        System.out.println("End Test case: Printed the titles and discounts successfully");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }

    }

    @Test(priority = 3, enabled = true)

    public void testSearch_03() throws InterruptedException {
        try {
            System.out.println("Start Test case: Search for 'Coffee Mug' and print top 5 items Titles and ImageURLs ");

            driver.get("https://www.flipkart.com/search?");
            Thread.sleep(4000);
    
            // search for 'Coffee Mug'
            WebElement searchBox = driver.findElement(By.xpath("//input[@class='zDPmFV']"));
            utility.click(searchBox);
            utility.sendKeys(searchBox, "Coffee Mug");
    
            WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
            utility.click(searchButton);
    
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300);");
            Thread.sleep(2000); 
    
            // click on 4star rating checkbox
            WebElement checkBox_4star = driver.findElement(By.xpath("(//div[@class='XqNaEv'])[1]"));
            utility.click(checkBox_4star);
    
            // Get the titles of the Coffee Mugs
            List<WebElement> titles_InAPage = driver
                    .findElements(By.xpath("(//a[@class='wjcEIp'])"));
    
            // Get the image URLs of the Coffee Mugs
            List<WebElement> imgURLs = driver.findElements(By.xpath("//div[@class='_4WELSP']//img"));
    
            // Get the review counts of the Coffee Mugs
            List<WebElement> reviewCounts = driver.findElements(By.xpath("//span[@class='Wphh3N']"));
    
            HashMap<Integer, MapInputs> coffeeMug_Map = new HashMap<>();
    
            int minSize = Math.min(titles_InAPage.size(), Math.min(imgURLs.size(), reviewCounts.size()));
    
            // Combine titles, image URLs, and review counts
            for (int j = 0; j < minSize; j++) {
                String title = titles_InAPage.get(j).getText();
                String imgURL = imgURLs.get(j).getAttribute("src");
                String reviewCount = reviewCounts.get(j).getText();
    
                StringBuilder sb = new StringBuilder();
                for (char c : reviewCount.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    }
                }
                int reviewCount_Number = Integer.parseInt(sb.toString());
    
                // Create a CoffeeMug object and put it into the map
                MapInputs coffeeMug = new MapInputs(title, imgURL, reviewCount_Number);
                coffeeMug_Map.put(reviewCount_Number, coffeeMug);
            }
    
            // Find the max 5 with the highest review counts
            List<Integer> sortedReviewCounts = new ArrayList<>(coffeeMug_Map.keySet());
            //sorting in descnding order
            Collections.sort(sortedReviewCounts, Collections.reverseOrder());
    
            System.out.println(" 5 Items with highest review counts:");
            for (int i = 0; i < Math.min(5, sortedReviewCounts.size()); i++) {
    
                int reviewCount = sortedReviewCounts.get(i);        
    
                MapInputs coffeeMug = coffeeMug_Map.get(reviewCount);
                
                System.out.println("Title: " + coffeeMug.getTitle());
                System.out.println("Image URL: " + coffeeMug.getImgUrl());
            }
    
            System.out.println("Total number of items : " + minSize);
            Assert.assertTrue(minSize > 0, "No items found");
    
            System.out.println("End Test case: Printed the titles, image URLs, and review counts successfully");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
       
    }

    @AfterSuite(alwaysRun = true)
    public static void quitDriver() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

}
