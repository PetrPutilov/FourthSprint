import org.junit.Test;
import pages.FaqList;
import pages.StartPage;
import pages.OrderPage;
import pages.LeasePage;

import static org.junit.Assert.assertTrue;
public class OrderTest extends StartTest{
    @Test
    public void OrderOfUpButton() {

        StartPage objMainPage = new StartPage(driver);
        objMainPage.checkBotton();
        objMainPage.clickCookieButton();
        objMainPage.clickFirstOrderButton();

        OrderPage objOderPage = new OrderPage(driver);

        objOderPage.sendClientFirstName("Пётр");
        objOderPage.sendClientSecondName("Путилов");
        objOderPage.sendDeliveryAddress("Саратов, Верхняя 24");
        objOderPage.selectMetroStation("Красносельская");
        objOderPage.sendDeliveryClientPhoneNumber("79271001000");
        objOderPage.clickNextButton();


        LeasePage objRentPage = new LeasePage(driver);

        objRentPage.sendRentalDate("01.01.2025");
        objRentPage.setRentalTime();
        objRentPage.clickCheckBoxColourBlackPearl();
        objRentPage.sendComment("комментарий");
        objRentPage.clickOrderButton();
        objRentPage.clickOrderButtonYes();


        boolean isDisplayed = new LeasePage(driver).isModalOrderWindowDisplayed();
        assertTrue("Ошибка", isDisplayed);
    }
    @Test
    public void OrderOfDownButton() {

        FaqList objMainList = new FaqList(driver);


        StartPage objMainPage = new StartPage(driver);


        objMainList.scrollPageToEndOfList(objMainPage.getFaqList().size());

        objMainPage.clickCookieButton();
        objMainPage.clickSecondtOrderButton();


        OrderPage objOderPage = new OrderPage(driver);

        objOderPage.sendClientFirstName("Пётр");
        objOderPage.sendClientSecondName("Первый");
        objOderPage.sendDeliveryAddress("Саратов, Нижняя 7");
        objOderPage.selectMetroStation("Комсомольская");
        objOderPage.sendDeliveryClientPhoneNumber("777777777777");
        objOderPage.clickNextButton();


        LeasePage objRentPage = new LeasePage(driver);

        objRentPage.sendRentalDate("02.02.2025");
        objRentPage.setRentalTime();
        objRentPage.clickCheckBoxColourGreyDespair();
        objRentPage.sendComment("комментарий 2");
        objRentPage.clickOrderButton();
        objRentPage.clickOrderButtonYes();
        boolean isDisplayed = new LeasePage(driver).isModalOrderWindowDisplayed();
        assertTrue("Ошибка снова", isDisplayed);
    }
}
