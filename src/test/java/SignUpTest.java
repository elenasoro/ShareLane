import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class SignUpTest {

    @Test
    public void fiveDigitZipCodeTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        // Add check
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isRegisterDisplayed = registerButton.isDisplayed();
        driver.quit();
        Assert.assertTrue(isRegisterDisplayed, "'Register' button isn't displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 4 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("1234");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        // Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

    @Test
    public void sixDigitZipCodeTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 6 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("123456");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        // Add check
        WebElement errorMessage = new WebElement() {
            @Override
            public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
                return null;
            }

            @Override
            public void click() {

            }

            @Override
            public void submit() {

            }

            @Override
            public void sendKeys(CharSequence... charSequences) {

            }

            @Override
            public void clear() {

            }

            @Override
            public String getTagName() {
                return null;
            }

            @Override
            public String getAttribute(String s) {
                return null;
            }

            @Override
            public boolean isSelected() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public String getText() {
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public boolean isDisplayed() {
                return false;
            }

            @Override
            public Point getLocation() {
                return null;
            }

            @Override
            public Dimension getSize() {
                return null;
            }

            @Override
            public Rectangle getRect() {
                return null;
            }

            @Override
            public String getCssValue(String s) {
                return null;
            }
        };
        try {
            errorMessage = driver.findElement(By.className("error_message"));
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }

        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

    @Test
    public void signUpPositiveTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter First Name
        driver.findElement(By.name("first_name")).sendKeys("Elena");

        //Enter Last Name
        driver.findElement(By.name("last_name")).sendKeys("Sosnovskaya");

        //Enter email
        driver.findElement(By.name("email")).sendKeys("email@gmail.com");

        //Enter password1
        driver.findElement(By.name("password1")).sendKeys("testpass");

        //Enter password2
        driver.findElement(By.name("password2")).sendKeys("testpass");

        // Click on Register button
        driver.findElement(By.cssSelector("[value=Register]")).click();

        // Add check
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        boolean isConfirmationDisplayed = confirmationMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isConfirmationDisplayed, "Confirmation message isn't displayed");
    }

    @Test
    public void emptyFirstNameTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter First Name
        driver.findElement(By.name("first_name")).sendKeys("");

        //Enter Last Name
        driver.findElement(By.name("last_name")).sendKeys("Sosnovskaya");

        //Enter email
        driver.findElement(By.name("email")).sendKeys("email@gmail.com");

        //Enter password1
        driver.findElement(By.name("password1")).sendKeys("testpass");

        //Enter password2
        driver.findElement(By.name("password2")).sendKeys("testpass");

        // Click on Register button
        driver.findElement(By.cssSelector("[value=Register]")).click();

        // Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

    @Test
    public void incorrectEmailFormatTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter First Name
        driver.findElement(By.name("first_name")).sendKeys("Elena");

        //Enter Last Name
        driver.findElement(By.name("last_name")).sendKeys("Sosnovskaya");

        //Enter email
        driver.findElement(By.name("email")).sendKeys("email");

        //Enter password1
        driver.findElement(By.name("password1")).sendKeys("testpass");

        //Enter password2
        driver.findElement(By.name("password2")).sendKeys("testpass");

        // Click on Register button
        driver.findElement(By.cssSelector("[value=Register]")).click();

        // Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

    @Test
    public void emptyEmailFieldTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter First Name
        driver.findElement(By.name("first_name")).sendKeys("Elena");

        //Enter Last Name
        driver.findElement(By.name("last_name")).sendKeys("Sosnovskaya");

        //Enter email
        driver.findElement(By.name("email")).sendKeys("");

        //Enter password1
        driver.findElement(By.name("password1")).sendKeys("testpass");

        //Enter password2
        driver.findElement(By.name("password2")).sendKeys("testpass");

        // Click on Register button
        driver.findElement(By.cssSelector("[value=Register]")).click();

        // Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

    @Test
    public void emptyPassword1Test() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter First Name
        driver.findElement(By.name("first_name")).sendKeys("Elena");

        //Enter Last Name
        driver.findElement(By.name("last_name")).sendKeys("Sosnovskaya");

        //Enter email
        driver.findElement(By.name("email")).sendKeys("email@gmail.com");

        //Enter password1
        driver.findElement(By.name("password1")).sendKeys("");

        //Enter password2
        driver.findElement(By.name("password2")).sendKeys("testpass");

        // Click on Register button
        driver.findElement(By.cssSelector("[value=Register]")).click();

        // Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

    @Test
    public void confirmPasswordIncorrectTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        //Enter First Name
        driver.findElement(By.name("first_name")).sendKeys("Elena");

        //Enter Last Name
        driver.findElement(By.name("last_name")).sendKeys("Sosnovskaya");

        //Enter email
        driver.findElement(By.name("email")).sendKeys("email@gmail.com");

        //Enter password1
        driver.findElement(By.name("password1")).sendKeys("testpass");

        //Enter password2
        driver.findElement(By.name("password2")).sendKeys("testpas2");

        // Click on Register button
        driver.findElement(By.cssSelector("[value=Register]")).click();

        // Add check
        WebElement errorMessage = new WebElement() {
            @Override
            public void click() {

            }

            @Override
            public void submit() {

            }

            @Override
            public void sendKeys(CharSequence... charSequences) {

            }

            @Override
            public void clear() {

            }

            @Override
            public String getTagName() {
                return null;
            }

            @Override
            public String getAttribute(String s) {
                return null;
            }

            @Override
            public boolean isSelected() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public String getText() {
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public boolean isDisplayed() {
                return false;
            }

            @Override
            public Point getLocation() {
                return null;
            }

            @Override
            public Dimension getSize() {
                return null;
            }

            @Override
            public Rectangle getRect() {
                return null;
            }

            @Override
            public String getCssValue(String s) {
                return null;
            }

            @Override
            public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
                return null;
            }
        };

        try {
            errorMessage = driver.findElement(By.className("error_message"));
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

}
