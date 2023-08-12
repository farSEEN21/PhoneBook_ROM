import config.AppiumConfig;
import helper.UserHelper;
import org.testng.Assert;
import org.testng.Converter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactScreen;
import screens.SplashScreen;

public class RemoveContactTest extends AppiumConfig implements UserHelper {

@BeforeClass

    public void precondition() {
        new SplashScreen(driver).gotoLogin().fillEmail(NEWREGEMAIL).fillPsw(PSW).submitLogin();
    }
@BeforeMethod
public void providerContacts(){
new ContactScreen(driver).provideContacts();
}
@Test

public void removeOneContactPosit(){
    Assert.assertTrue( new ContactScreen(driver)
            .removeOneContact().isContactRemove());
}
@Test
    public void removeAllContactsposit(){
    Assert.assertTrue(
new ContactScreen(driver).removeallcontacts().isNoContactMessage());


}

}
