package dataentities;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Address {

    private String streetAndHouseNumber = new Faker().address().streetAddress();
    private String city = new Faker().address().city();
    private String state = new Faker().address().state();
    private String zipCode = new Faker().address().zipCode();

    public Address(){}
}
