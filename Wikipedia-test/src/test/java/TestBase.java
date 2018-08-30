import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.wikipedia.org/");
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
