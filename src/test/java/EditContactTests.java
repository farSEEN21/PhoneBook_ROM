import config.AppiumConfig;
import helper.UserHelper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.ContactScreen;
import screens.SplashScreen;

public class EditContactTests extends AppiumConfig implements UserHelper {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
@BeforeTest
public void precondition() {
    new SplashScreen(driver).gotoLogin().fillEmail(NEWREGEMAIL).fillPsw(PSW).submitLogin();
}
@Test
    public void editOneCOntactPositive(){
    String text="updated_"+i+"@nail.com";
    new ContactScreen(driver)
            .editOneContact()
            .editEmail(text)
            .updateConatact()
            .isContactContains(text);


}


}
