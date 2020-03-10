package dataentities;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Credentials {

    private String username = new Faker().name().username();
    private String password = "demo";

    public Credentials(){}
}
