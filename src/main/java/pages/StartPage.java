package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

// Элементы главной страницы
public class StartPage {

    static WebDriver driver;

    private By cookieButton = By.id("rcc-confirm-button");
    private By firstOrderButton = By.className("Button_Button__ra12g");
    private By secondOrderButton = By.className("Home_FinishButton__1_cWm");

    private By faqButton = By.xpath("//*[contains(@id,'accordion__panel')]/p");

    public StartPage(WebDriver driver) {
        StartPage.driver = driver;
    }

    public List<WebElement> getFaqList(){
        return driver.findElements(faqButton);
    }
    public boolean checkBotton() {
        return driver.findElement(firstOrderButton).isEnabled();
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickFirstOrderButton() {
        driver.findElement(firstOrderButton).click();
    }

    public void clickSecondtOrderButton() {
        driver.findElement(secondOrderButton).click();
    }
}
