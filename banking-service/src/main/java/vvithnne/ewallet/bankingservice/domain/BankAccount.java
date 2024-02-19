package vvithnne.ewallet.bankingservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import vvithnne.ewallet.bankingservice.exception.InvalidBankAccountException;
import vvithnne.ewallet.common.constant.BankType;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccount {

    @Getter private final BankType bankType;

    @Getter private final BankAccountNumber bankAccountNumber;

    @Getter private final IsValid isValid;

    /**
     * Creates an {@link BankAccount} entity without account status. Use to get bank account information that is not yet
     * communicated with external banking system.
     */
    public static BankAccount of(
            BankType bankType,
            BankAccountNumber bankAccountNumber
    ) {
        return new BankAccount(
          bankType,
          bankAccountNumber,
          null
        );
    }

    /**
     * Creates an {@link BankAccount} entity with account status. Use to reconstitute a received bank account information
     * from external banking system.
     */
    public static BankAccount of(
            BankType bankType,
            BankAccountNumber bankAccountNumber,
            IsValid isValid
    ) {
        return new BankAccount(
                bankType,
                bankAccountNumber,
                isValid
        );
    }

    public void validate() {
        if (!isValid.value) {
            throw new InvalidBankAccountException();
        }
    }

    @Value
    @AllArgsConstructor
    public static class BankAccountNumber {
        String value;
    }

    @Value
    @AllArgsConstructor
    public static class IsValid {
        boolean value;
    }

}
