package part3.base;

import com.base.BasePage;
import com.demoqa.pages.HomePage;
import com.util.BaseUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    private final String DEMOQA_URL = "https://demoqa.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(DEMOQA_URL);
        BaseUtil.setDriver(driver);
        BasePage.setWebDriver(driver);
        homePage = new HomePage();
    }

    @AfterMethod
    public void takeFailResultScreenshot(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File target = new File(System.getProperty("user.dir") +
                    "/screenshots/" + java.time.LocalDate.now() + "/"
                    + testResult.getName() + ".png");
            if (!target.getParentFile().exists()) {
                target.getParentFile().mkdirs();
            }
            try {
                FileHandler.copy(source, target);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("screen shot at " + target);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
