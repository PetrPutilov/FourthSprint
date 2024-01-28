package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

// элемнеты страницы заказа
public class OrderPage {
    private  WebDriver driver;
    private final By ClientFirstName = By.xpath(".//input[@placeholder='* Имя']");
    private final By ClientLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By deliveryMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By deliveryClientPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By NextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    private final By logo = By.className("Header_LogoScooter__3lsAR");


    public OrderPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitForLoadHeader(){
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ClientLastName")));
    }
    // заполнение поля Имя
    public void sendClientFirstName(String firstName) {
        driver.findElement(ClientFirstName).sendKeys(firstName);
    }
    // заполнение поля Фамилия
    public void sendClientSecondName(String firstName) {
        driver.findElement(ClientLastName).sendKeys(firstName);
    }
    //заполнение адреса доставки
    public void sendDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
    }

    // Выбор станции метро
    public void selectMetroStation(String metroStationFromOrder) {
        driver.findElement(deliveryMetroStation).click();
        driver.findElement(deliveryMetroStation).sendKeys(metroStationFromOrder);
        driver.findElement(deliveryMetroStation).sendKeys(Keys.DOWN,Keys.ENTER);
    }

    // заполнение телефона клиента
    public void sendDeliveryClientPhoneNumber(String phoneNumber) {
        driver.findElement(deliveryClientPhoneNumber).sendKeys(phoneNumber);
    }

    // Клик по кнопке "Далее"
    public void clickNextButton() {
        driver.findElement(NextButton).click();
    }

    // слик по логотипу
    public void clickLogo() {
        driver.findElement(logo).click();
    }
}
