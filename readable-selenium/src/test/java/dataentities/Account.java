package dataentities;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Account {

    private AccountType accountType;

    public Account(){}
}
