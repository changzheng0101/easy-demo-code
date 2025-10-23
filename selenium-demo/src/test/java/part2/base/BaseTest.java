package part2.base;


import com.base.BasePage;
import com.saucedemo.pages.LoginPage;
import com.util.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * @author 29504
 * @date 2024/10/03
 */
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void loadApplication() {
        String url = "https://www.saucedemo.com";
        driver.get(url);
        BasePage.setWebDriver(driver);
        BaseUtil.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
