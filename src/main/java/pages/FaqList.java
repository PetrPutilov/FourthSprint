package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static constants.Constant.QUESTION_BUTTON_ID;

public class FaqList {

    private static WebDriver driver;

    public FaqList(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollPageToEndOfList(Integer sizeList) {
        WebElement lastQuestionArrow = driver.findElement(By.id(QUESTION_BUTTON_ID + (sizeList-1)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }

    public void clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
    }
}
