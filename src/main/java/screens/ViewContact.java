package screens;

import helper.Contact;
import helper.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ViewContact extends BaseScreen implements UserHelper {
    public ViewContact(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/nameTxt']")
    MobileElement name;




    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/lastNameTxt']")
    MobileElement lastname;




    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/emailTxt']")
    MobileElement email;



    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/phoneTxt']")
    MobileElement Phone;



    @FindBy
            (xpath = "//*[@resource-id='com.sheygam.contactapp:id/addressTxt']")
    MobileElement adress;

    public Contact viewContOn(){
        return Contact.builder()
                .name(name.getText())
                .lastName(lastname.getText())
                .phone(Phone.getText())
                .email1(email.getText())
                .address(adress.getText())
                .description("").build();
    }


}
