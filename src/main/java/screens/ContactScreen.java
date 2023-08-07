package screens;

import Helper.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

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
    public String textCont(){
        return textContList.getText().toUpperCase().trim();
    }
}
