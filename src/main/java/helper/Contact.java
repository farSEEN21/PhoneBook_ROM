package helper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Contact {

    String id;
    String name;
    String lastName;
    String email1;
    String phone;
    String address;
    String description;



}
