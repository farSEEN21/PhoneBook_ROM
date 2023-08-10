package helper;

import io.appium.java_client.MobileElement;

public interface UserHelper {

String NEWREGEMAIL="dfg_1374@fgkfdjg.ru";
String EMAIL_2="dfg_1354@fgkfdjg.ru";
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


    default Contact contactModel() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("John" +i )
                .lastName("Snow")
                .phone("01234574788"+i )
                .email1("john_" + i + "@mail.com")
                .address("Rehovot")
                .description("Best friend")
                .build();
//        System.out.println(contact);
        return contact;
    }


}
