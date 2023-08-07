import Helper.Contact;
import Helper.UserHelper;
import config.AppiumConfig;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.ContactScreen;
import screens.LoginRegistrationScreen;

public class AddContactTests extends AppiumConfig implements UserHelper {

    @BeforeTest
    public void logint() throws InterruptedException {

        method.pause(5000);
        new LoginRegistrationScreen(driver).fillformEmail();
        new LoginRegistrationScreen(driver).fillformpsw();
        new LoginRegistrationScreen(driver).click();


    }


    @Test
    public void AddContact() throws InterruptedException {
        method.pause(5000);
        new ContactScreen(driver).ClickAddButton();
        new AddNewContactScreen(driver).name();
        new AddNewContactScreen(driver).lastname();
        new AddNewContactScreen(driver).email();
        new AddNewContactScreen(driver).Phone();

        new AddNewContactScreen(driver).adress();
        new AddNewContactScreen(driver).click();
        method.pause(5000);
    }
}
