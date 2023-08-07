package screens;

import Helper.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationScreen extends BaseScreen implements UserHelper {


    public LoginRegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement emailfield;

    public String emailfield() {
        return emailfield.getText();
    }


    public void fillformEmail() {
        UserHelper.super.fillform(emailfield, EMAIL);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement pswfield;

    public void fillformpsw() {
        UserHelper.super.fillform(pswfield, PSW);
    }

    public String pswfield() {
        return pswfield.getText();
    }


    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement regbtn;

    public String regbtn() {
        return regbtn.getText();
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
    MobileElement loginbtn;


    public void click() {
        UserHelper.super.click(loginbtn);
    }

    public String loginbtn() {
        return loginbtn.getText();
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement authText;

    public String authText() {
        return authText.getText();
    }


}
