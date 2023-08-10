package screens;

import helper.Contact;
import helper.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen implements UserHelper {

    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement name;


    public void name() {
        UserHelper.super.fillform(name, "Sregf" + i);
    }

    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement lastname;

    public void lastname() {
        UserHelper.super.fillform(lastname, "sdfdsfdsf" + i);
    }


    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement email;

    public void email() {
        UserHelper.super.fillform(email, "sdfdf" + i + "@dfsdf.ru");
    }

    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement Phone;

    public void Phone() {
        UserHelper.super.fillform(Phone, "5486865466" + i);
    }

    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement adress;

    public void adress() {
        UserHelper.super.fillform(adress, "sdfdsfdsf");
    }


    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement desc;
    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement createbtn;

    public void click() {
        UserHelper.super.click(createbtn);
    }

    public AddNewContactScreen fillContactForm(Contact contact) {
        wait(createbtn, 5);
        type(name, contact.getName());
        type(lastname, contact.getLastName());
        type(Phone, contact.getPhone());
        type(email, contact.getEmail1());
        type(adress, contact.getAddress());
        return this;
    }

    public ContactScreen submitConatact() {
        createbtn.click();
        return new ContactScreen(driver);

    }
}
