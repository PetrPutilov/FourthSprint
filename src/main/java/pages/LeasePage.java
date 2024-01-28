package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class LeasePage {

    WebDriver driver;

    // Локаторы данных страницы "Про аренду"
     // заполнение поля даты начала аренды
    private final By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // заполнение поля сррока аренды
    private final By rentalTimeField = By.className("Dropdown-placeholder");
    // список срока аренды
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    //  цвет самоката "Черный жемчуг"
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    // цвет самоката "Серая безысходность"
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    // комментарий
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопка  "Заказать"
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    // кнопка  "Да" оформления заказа*
    private final By orderButtonYes = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    //Локатор модального окна
    private final By modalOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");

    //Модальное окно "Заказ Оформлен"
    public boolean isModalOrderWindowDisplayed() {
        return driver.findElement(modalOrderWindow).isDisplayed();
    }


    public LeasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для работы с элементами страницы аренды
     //Ввод даты доставки
    public void sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
    }

    //срок аренды
    public void setRentalTime() {
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();
    }

    // Выбор цвета самоката "Черный жемчуг"
    public void clickCheckBoxColourBlackPearl() {
        driver.findElement(checkBoxColourBlackPearl).click();
    }

    //Выбор цвета самоката "Серая безысходность"
    public void clickCheckBoxColourGreyDespair() {
        driver.findElement(checkBoxColourGreyDespair).click();
    }

    //Ввод комментария для курьера
    public void sendComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
    }

    //Клик по Кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Клик по кнопке "Да" оформления заказа
    public void clickOrderButtonYes() {
        driver.findElement(orderButtonYes).click();
    }
}
