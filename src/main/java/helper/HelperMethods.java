package helper;

import config.AppiumConfig;

public class HelperMethods extends AppiumConfig {


    public void pause(int time) throws InterruptedException {
        Thread.sleep(time);
    }


    public void contactModel() {
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
