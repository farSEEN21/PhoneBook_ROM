package screens;

import helper.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Assert.*;

public class LoginRegistrationScreen extends BaseScreen implements UserHelper {


    public LoginRegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityTextView;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement emailfield;

    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputemail;

    public String emailfield() {
        return emailfield.getText();
    }


    public void fillformEmail() {
        UserHelper.super.fillform(emailfield, EMAIL);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement pswfield;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement intputpsw;

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


    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginbtnid;


    public void click() {
        UserHelper.super.click(loginbtn);
    }

    public String loginbtn() {
        return loginbtn.getText();
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement authText;
    @FindBy(xpath = "//*[@resource-id='android:id/alertTitle']")
    MobileElement alertTitle;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement OkBtnError;

    public boolean isAllert() {
        wait(alertTitle,5);
        String str=alertTitle.getText();
        return   shouldHave(alertTitle,"Error",5);

    }
    public void clickErrorOk() {
        OkBtnError.click();

    }

    public String authText() {
        return authText.getText();
    }


    public LoginRegistrationScreen fillEmail(String email) {

        wait(inputemail, 5);
        type(inputemail, email);
        return this;

    }

    public LoginRegistrationScreen fillPsw(String psw) {
        type(intputpsw, psw);
        return this;

    }

    public ContactScreen submitLogin() {
        click(loginbtn);
        return new ContactScreen(driver);

    }

    public ContactScreen submitReg() {
        click(regbtn);
        return new ContactScreen(driver);

    }

    public LoginRegistrationScreen submitRegNeg() {
        click(regbtn);
        return this;

    }

}
