import config.AppiumConfig;
import helper.UserHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ContactScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig implements UserHelper{


    @Test
    public void LoginPositive(){
        Assert.assertTrue(
new SplashScreen(driver).gotoLogin()
        .fillEmail(EMAIL)
        .fillPsw(PSW)
        .submitLogin()
        .isContactActivityPresent());



    }


    @AfterMethod
    public void postcondition(){

        if (new ContactScreen(driver).isContactActivityPresent()){
            new ContactScreen(driver).logout();
            new SplashScreen(driver);
        }

    }


}
