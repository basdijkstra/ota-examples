package dataentities;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class Customer {

    private String firstName = new Faker().name().firstName();
    private String lastName = new Faker().name().lastName();
    private Address address = new Address().toBuilder().build();
    private String phoneNumber = new Faker().phoneNumber().phoneNumber();
    private String ssn = new Faker().idNumber().validSvSeSsn();
    private Credentials credentials = new Credentials().toBuilder().build();

    public Customer(){}
}
