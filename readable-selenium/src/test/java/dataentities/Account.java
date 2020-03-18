package dataentities;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Account {

    private AccountType type;
    private int id;
    private double balance;

    public Account(){}
}
