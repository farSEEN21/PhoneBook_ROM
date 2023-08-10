import config.AppiumConfig;
import helper.UserHelper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import screens.LoginRegistrationScreen;
import screens.SplashScreen;

import java.util.Random;

public class RgistrationTests extends AppiumConfig implements UserHelper {

    int i=new Random().nextInt(1000)+1000;


    @Test
    public void RegistrationTestPosit(){
        String d="dfg_"+i+"@fgkfdjg.ru";
        Assert.assertTrue(
                new SplashScreen(driver).gotoLogin()
                        .fillEmail(d)
                        .fillPsw(PSW)
                        .submitReg()
                        .isContactActivityPresent());


        System.out.println(d);

    }
   @Test
    public void RegistrationTestNegWrongEmail(){

        Assert.assertTrue(
                new SplashScreen(driver).gotoLogin()
                        .fillEmail("dfg_"+i+"fgkfdjg.ru")
                        .fillPsw(PSW)
                        .submitRegNeg().isAllert());
Assert.assertTrue(new LoginRegistrationScreen(driver).isAllert());
 



    }
    @AfterTest
    public void postcond() {
        if (new LoginRegistrationScreen(driver).isAllert()){
           new LoginRegistrationScreen(driver).clickErrorOk();
   }}

}
