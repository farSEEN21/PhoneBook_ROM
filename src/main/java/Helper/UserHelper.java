package Helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface UserHelper {


    String EMAIL = "a@a1.ru";
    String PSW = "DJS@sda1";

    default void fillform(MobileElement some, String str) {
      //  some.click();
        some.clear();
        some.sendKeys(str);

    }

    default void click(MobileElement some) {
        some.click();

    }


    default void contactModel() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("John_" + i)
                .lastName("Snow")
                .phone("01234578" + i)
                .email1("john_" + i + "@mail.com")
                .address("Rehovot")
                .description("Best friend")
                .build();
        System.out.println(contact);
    }


}
