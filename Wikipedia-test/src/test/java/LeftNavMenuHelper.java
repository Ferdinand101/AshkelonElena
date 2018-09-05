import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LeftNavMenuHelper extends HelperBase {
    public LeftNavMenuHelper(WebDriver driver) {
        super(driver);
    }

    public void getInteractionMenuListVar2() {
        int size = driver.findElements(
                By.xpath("//*[@id='p-interaction']//li")).size();
        System.out.println(size);
        for(int i = 1; i <= size; i++ ){
            WebElement item = driver.findElement(
                    By.xpath("//*[@id='p-interaction']//li[" + i + "]"));
            String itemName = item.getText();
            System.out.println(itemName);
        }
    }

    public void getInteractionMenuItemsList() {
        int size = driver.findElements(
                By.xpath("//*[@id='p-interaction']//li")).size();
        System.out.println(size);
        for (int i = 1; i <= size; i++) {
            List<String> itemsMenu = new ArrayList<>();
            WebElement item = driver.findElement(
                    By.xpath("//*[@id='p-interaction']//li[" + i + "]"));
            String itemName = item.getText();
            itemsMenu.add(itemName.toLowerCase());
            System.out.println(itemsMenu);
        }
    }


}
