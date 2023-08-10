package screens;

import helper.Contact;
import helper.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactScreen extends BaseScreen implements UserHelper {


    public ContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
    MobileElement addbtn;

    public void ClickAddButton() {
        click(addbtn);


    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement textContList;

    public String textCont() {
        return textContList.getText().toUpperCase().trim();
    }


    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityTextView;


    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOptions;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutBTB;


    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
    List<MobileElement> rowContainer;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<MobileElement> rowName;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowPhone']")
    List<MobileElement> rowPhone;


    public boolean isContactActivityPresent() {
        return shouldHave(activityTextView, "Contact list", 5);
    }


    public LoginRegistrationScreen logout() {
        moreOptions.click();
        logoutBTB.click();


        return new LoginRegistrationScreen(driver);
    }

    public AddNewContactScreen openContactForm() {
        wait(addbtn, 5);
        addbtn.click();
        return new AddNewContactScreen(driver);
    }

//    public void contactlist() {
//        int i = rowContainer.size() - 1;
//        int a = rowName.size() - 1;
//        int b = rowPhone.size() - 1;
//        System.out.println(rowPhone.get(0).getText().contains("012345782055"));
//        String name1 = rowName.get(a).toString();
//        System.out.println("RUSALSTS =" + rowContainer.get(i) + " " + i);
//        System.out.println("PRINT the name ====== " + rowName.get(1) + " " + a);
//        System.out.println("PRINT the name ====== " + name1 + rowName.get(1) + " " + a);
//        System.out.println("PRINT the phone ====== " + rowPhone.get(b).toString() + " " + b);
//
//
//    }

    public boolean isCorrect(Contact user) {
        int a = rowPhone.size() - 1;
        int b = rowName.size() - 1;
        if
        (rowPhone.get(a).getText().contains(user.getPhone()) && rowName.get(b).getText().contains(user.getName())) {
            return true;
        } else {
            System.out.println("OOOO NO!!!");
            return false;
        }


    }
}