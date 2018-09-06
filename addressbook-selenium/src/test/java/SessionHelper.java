import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }


    public boolean isLoggedIn(){
        return  isElementPresent(
                By.xpath("//*[@title='Log out']"));
    }

    public void clickLoginButton() {
        click(By.id("pt-login"));
    }

    public void confirmLogin() {
        click(By.id("wpLoginAttempt"));
    }

    public void fillLoginForm(String user, String password) {
        type(By.id("wpName1"), user);
        type(By.id("wpPassword1"), password);


    }

    public void logout() {
        click(By.xpath("//*[@title='Log out']"));
    }
}
