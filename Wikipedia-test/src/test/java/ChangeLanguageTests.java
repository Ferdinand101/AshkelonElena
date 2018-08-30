import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTests extends TestBase {
    @Test
    public void openHomePageOnEnglish() {
        clickOnEnglishLink();
        String actualUrl = driver.getCurrentUrl();
        String expectedURL=
                "https://en.wikipedia.org/wiki/Main_Page";

        Assert.assertEquals(actualUrl, expectedURL);

        returnToPreviousPage();
    }

    @Test
    public void openHomePageOnJapanese() {
        clickOnJapaneseLink();

        String actualUrl = driver.getCurrentUrl();
        String expectedURL=
                "https://ja.wikipedia.org/wiki/%E3%83%A1%E3%82%A4%E3%83%B3%E3%83%9A%E3%83%BC%E3%82%B8";

        Assert.assertEquals(actualUrl, expectedURL);

        returnToPreviousPage();
    }

    private void clickOnJapaneseLink() {
        click(By.cssSelector("a#js-link-box-ja"));
    }

    public void returnToPreviousPage() {
        driver.navigate().back();
    }

    public void clickOnEnglishLink() {
        click(By.cssSelector("a#js-link-box-en"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
