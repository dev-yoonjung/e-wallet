package vvithnne.ewallet.bankingservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import vvithnne.ewallet.common.constant.BankType;
import vvithnne.ewallet.bankingservice.domain.BankAccount.BankAccountNumber;
import vvithnne.ewallet.bankingservice.domain.BankAccount.IsValid;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {

    @Getter private final RegisteredBankAccountId registeredBankAccountId;

    @Getter private final MembershipId membershipId;

    @Getter private final BankType bankType;

    @Getter private final BankAccountNumber bankAccountNumber;

    @Getter private final IsValid linkedStatusIsValid;

    /**
     * Creates an {@link RegisteredBankAccount} entity without an ID. Use to create a new entity that is not yet
     * persisted.
     */
    public static RegisteredBankAccount of(
            MembershipId membershipId,
            BankType bankType,
            BankAccountNumber bankAccountNumber,
            IsValid linkedStatusIsValid
    ) {
        return new RegisteredBankAccount(
                null,
                membershipId,
                bankType,
                bankAccountNumber,
                linkedStatusIsValid
        );
    }

    /**
     * Creates an {@link RegisteredBankAccount} entity with an ID. Use to reconstitute a persisted entity.
     */
    public static RegisteredBankAccount of(
            RegisteredBankAccountId registeredBankAccountId,
            MembershipId membershipId,
            BankType bankType,
            BankAccountNumber bankAccountNumber,
            IsValid linkedStatusIsValid
    ) {
        return new RegisteredBankAccount(
                registeredBankAccountId,
                membershipId,
                bankType,
                bankAccountNumber,
                linkedStatusIsValid
        );
    }

    @Value
    @AllArgsConstructor
    public static class RegisteredBankAccountId {
        Long value;
    }

    @Value
    @AllArgsConstructor
    public static class MembershipId {
        Long value;
    }

}
