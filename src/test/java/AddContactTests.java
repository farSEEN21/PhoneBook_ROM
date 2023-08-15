import helper.Contact;
import helper.UserHelper;
import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.ContactScreen;
import screens.LoginRegistrationScreen;
import screens.SplashScreen;

public class AddContactTests extends AppiumConfig implements UserHelper {

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;

    @BeforeTest
//    public void logint() throws InterruptedException {
//
//        method.pause(5000);
//        new LoginRegistrationScreen(driver).fillformEmail();
//        new LoginRegistrationScreen(driver).fillformpsw();
//        new LoginRegistrationScreen(driver).click();
//
//
//    }

    public void precondition() {
        new SplashScreen(driver).gotoLogin().fillEmail(EMAIL).fillPsw(PSW).submitLogin();
    }

    @Test
    public void AddNewContactPositiveLessson() {


        Contact contact = Contact.builder()
                .name("John_" + i)
                .lastName("Snow")
                .phone("01234578" + i)
                .email1("john_" + i + "@mail.com")
                .address("Rehovot")
                .description("Best friend")
                .build();
        new ContactScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitConatact();
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
        String textcont = new ContactScreen(driver).textCont();
        String str = "Contact list";
        Assert.assertEquals(textcont, str.trim().toUpperCase());
        method.pause(5000);


    }

    @Test
    public void AddCOntacHW() {
        Contact user = contactModel();
        new ContactScreen(driver)
                .openContactForm()
                .fillContactForm(user)
                .submitConatact().isCOntactAdd(user);
        Assert.assertTrue(new ContactScreen(driver).isCorrect(user));

//String ContactNameLastName=contactModel().getName()+" "+contactModel().getLastName();
//String Contact=user.getPhone();


    }

    @Test
    public void AddCOntacLastOne() {
        Contact user = contactModel();
        Assert.assertTrue(new ContactScreen(driver).openContactForm()
                .fillContactForm(user)
                .submitConatact().isLastContact(user));
//
//.scrolldown(0)
//                .scrolldown( );
        //  Assert.assertEquals(user, );
        //if (new ContactScreen(driver).isCOntactAdd(user)==false){new ContactScreen(driver).scrolldown();}


        // Assert.assertTrue(new ContactScreen(driver).isCorrect(user));


    }
}