import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private SessionHelper sessionHelper;
   private GroupHelper groupHelper;

    WebDriver driver;

    public void start() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.wikipedia.org/");
       // Thread.sleep(3000);
        sessionHelper = new SessionHelper(driver);
        groupHelper = new GroupHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public void clickOnJapaneseLink() {
        sessionHelper.click(By.cssSelector("a#js-link-box-ja"));
    }

    public void returnToPreviousPage() {
        driver.navigate().back();
    }

    public void clickOnEnglishLink() {
        sessionHelper.click(By.cssSelector("a#js-link-box-en"));
    }


    public boolean onTheWelcomPage() {
        return sessionHelper.isElementPresent(By.cssSelector("a#js-link-box-en")) ;
    }



    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }


}

