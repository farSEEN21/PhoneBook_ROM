import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginRegistrationScreen;
import screens.SplashScreen;

public class LaunchTest extends AppiumConfig {

    @Test
    public void launch() {
        String ver = new SplashScreen(driver).getCurrentVersion();
        Assert.assertTrue(ver.contains("1.0.0"));
    }

    @Test
    public void LoginRegtestEmail() throws InterruptedException {
        method.pause(6000);
        String ver = new LoginRegistrationScreen(driver).emailfield();
        Assert.assertTrue(ver.contains("Type email"));
    }


    @Test
    public void LoginRegtestPSW() throws InterruptedException {
        method.pause(6000);
        String ver = new LoginRegistrationScreen(driver).pswfield();
        Assert.assertTrue(ver.contains("Type password"));
    }

    @Test
    public void LoginRegtestRegBTN() throws InterruptedException {
        method.pause(6000);
        String ver = new LoginRegistrationScreen(driver).regbtn();
        Assert.assertTrue(ver.contains("REGISTRATION\n"));
    }

    @Test
    public void LoginRegtestLoginBtn() throws InterruptedException {
        method.pause(6000);
        String ver = new LoginRegistrationScreen(driver).loginbtn();
        Assert.assertTrue(ver.contains("LOGIN"));
    }

    @Test
    public void LoginRegtest() throws InterruptedException {
        method.pause(6000);
        String ver = new LoginRegistrationScreen(driver).authText();
        Assert.assertTrue(ver.contains("Authentication"));
    }


}
