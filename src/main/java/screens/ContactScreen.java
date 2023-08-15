package screens;

import helper.Contact;
import helper.UserHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactScreen extends BaseScreen implements UserHelper {


    public ContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    String phoneNUmber;

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

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/emptyTxt']")
    MobileElement emptytext;


    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutBTB;


    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
    List<MobileElement> rowContainer;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<MobileElement> rowName;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowPhone']")
    List<MobileElement> rowPhone;

    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement yesbtn;


    public boolean isContactActivityPresent() {
        return shouldHave(activityTextView, "Contact list", 5);
    }


    public LoginRegistrationScreen logout() {
        moreOptions.click();
        logoutBTB.click();


        return new LoginRegistrationScreen(driver);
    }

    public AddNewContactScreen openContactForm() {
        wait(addbtn, 9);
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
        (rowPhone.get(a).getText().contains(user.getPhone()) && rowName.get(b).getText().contains(user.getName() + " " + user.getLastName())) {
            return true;
        } else {
            System.out.println("OOOO NO!!!");
            return false;
        }
    }

    public ContactScreen scrollList() {
        wait(addbtn, 5);
        MobileElement contact = rowContainer.get(rowContainer.size() - 1);
        phoneNUmber = rowPhone.get(0).getText();
        Rectangle rec = contact.getRect();
        int xStart = rec.getX() + rec.getWidth() / 8;
        int y = rec.getY() + rec.getHeight() / 2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xStart, y))
                .moveTo(PointOption.point(xStart, 0))
                .release()
                .perform();
        return this;
    }


    public boolean isEndofList() {
        String beforeScroll = rowName.get(rowName.size() - 1).getText() +
                " " + rowPhone.get(rowPhone.size() - 1).getText();
        scrolldown();
        String afterscroll = rowName.get(rowName.size() - 1).getText() +
                " " + rowPhone.get(rowPhone.size() - 1).getText();
        if (beforeScroll.equals(afterscroll))
            return true;
        return false;
    }


    public ContactScreen scrolldown() {
        wait(addbtn, 5);
        int last = rowContainer.size() - 1;
        MobileElement contact = rowContainer.get(last);
        //   phoneNUmber=rowPhone.get(last).getText();
        Rectangle position = contact.getRect();


        int y = 500 + (position.getY() + position.getHeight()) / 4;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(y, y))
                .moveTo(PointOption.point(21, 0))
                .release()
                .perform();

        pause(3000);


        return this;
    }

    public boolean isCorrectlastContact(Contact user) {

        int lastOne = rowContainer.size() - 1;
        rowContainer.get(lastOne).click();
        Contact usercheck = new ViewContact(driver).viewContOn();
        if (user.getName().equals(usercheck.getName()) &&
                user.getLastName().equals(usercheck.getLastName())
                &&
                user.getPhone().equals(usercheck.getPhone())
                &&
                user.getEmail1().equals(usercheck.getEmail1())
                && user.getAddress().equals(usercheck.getAddress())) {
            driver.navigate().back();
            System.out.println("yes");
            return true;
        } else {
            driver.navigate().back();

            return false;
        }


    }

    public boolean isContactAddScroll(Contact contact) {
        boolean res = false;
        while (!res) {
            boolean checkName = checkContainsText(rowName, contact.getName() + " " + contact.getLastName());
            boolean checkphone = checkContainsText(rowPhone, contact.getPhone());
            res= checkName && checkphone;
            if (res == false) isEndofList();
        }
        return res;
    }

    public boolean isLastContact(Contact user) {
// boolean result = isCorrect(user);
        boolean result = isCorrectlastContact(user);
        while (!result == true) {
            scrolldown();
            result = isCorrectlastContact(user);
        }
        return true;
    }

    public boolean isCOntactAdd(Contact user) {
        boolean checkName = checkContainsText(rowName, user.getName() + " " + user.getLastName());
        boolean checkphone = checkContainsText(rowPhone, user.getPhone());
        return checkName && checkphone;
    }


    public boolean checkContainsText(List<MobileElement> list, String text) {

        for (MobileElement element : list) {
            if (element.getText().contains(text)) return true;
        }
        return false;
    }

    public ContactScreen removeOneContact() {
        wait(addbtn, 5);
        MobileElement contact = rowContainer.get(0);
        phoneNUmber = rowPhone.get(0).getText();
        Rectangle rec = contact.getRect();
        int xStart = rec.getX() + rec.getWidth() / 8;
        int xEnd = xStart + rec.getWidth() * 6 / 8;
        int y = rec.getY() + rec.getHeight() / 2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xStart, y))
                .moveTo(PointOption.point(xEnd, y))
                .release()
                .perform();
        yesbtn.click();
        pause(3000);
        return this;
    }


    public boolean isContactRemove() {
        boolean res = rowPhone.contains(phoneNUmber);
        return !res;
    }

    public ContactScreen removeallcontacts() {
        wait(addbtn, 5);
        while (rowContainer.size() > 0) {
            removeOneContact();
        }
        return this;

    }

    public boolean isNoContactMessage() {
        return shouldHave(emptytext, "No Contacts. Add One more!", 5);
    }

    public ContactScreen provideContacts() {
        while (rowContainer.size() < 3) {
            addContact();
        }
        return this;
    }


    public ContactScreen addContact() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;


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
        return this;

    }


    public EditContactScreen editOneContact() {
        wait(addbtn, 5);
        MobileElement contact = rowContainer.get(0);
        Rectangle rec = contact.getRect();
        int xStart = rec.getX() + rec.getWidth() / 8;
        int xEnd = xStart + rec.getWidth() * 6 / 8;
        int y = rec.getY() + rec.getHeight() / 2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xEnd, y))
                .moveTo(PointOption.point(xStart, y))
                .release()
                .perform();

        pause(3000);
        return new EditContactScreen(driver);
    }


    public boolean isContactContains(String text) {
        rowContainer.get(0).click();
        Contact contact = new ViewContact(driver).viewContOn();
        driver.navigate().back();
        return contact.toString().contains(text);

    }


}

