package dataentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class LoanRequest {

    private String loanAmount;
    private String downPayment;
    private String fromAccountId;

    public LoanRequest(){}

    public static LoanRequest createALoanRequestWithSufficientFunds() {

        return LoanRequest.builder().loanAmount("1000").downPayment("100").fromAccountId("54321").build();
    }
}
