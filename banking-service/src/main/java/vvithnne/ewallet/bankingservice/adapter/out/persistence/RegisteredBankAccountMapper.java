package vvithnne.ewallet.bankingservice.adapter.out.persistence;

import org.springframework.stereotype.Component;
import vvithnne.ewallet.bankingservice.adapter.out.persistence.entity.RegisteredBankAccountJpaEntity;
import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount;
import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount.RegisteredBankAccountId;
import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount.MembershipId;
import vvithnne.ewallet.bankingservice.domain.BankAccount.BankAccountNumber;
import vvithnne.ewallet.bankingservice.domain.BankAccount.IsValid;


import java.util.Optional;

@Component
public class RegisteredBankAccountMapper {

    RegisteredBankAccount mapToDomain(RegisteredBankAccountJpaEntity registeredBankAccount) {
        return RegisteredBankAccount.of(
                new RegisteredBankAccountId(registeredBankAccount.getMembershipId()),
                new MembershipId(registeredBankAccount.getMembershipId()),
                registeredBankAccount.getBankType(),
                new BankAccountNumber(registeredBankAccount.getBankAccountNumber()),
                new IsValid(registeredBankAccount.isLinkedStatusIsValid())
        );
    }

    RegisteredBankAccountJpaEntity mapToJpaEntity(RegisteredBankAccount registeredBankAccount) {
        Long registeredBankAccountId = Optional.ofNullable(registeredBankAccount.getRegisteredBankAccountId())
                .map(RegisteredBankAccountId::getValue)
                .orElse(null);

        return new RegisteredBankAccountJpaEntity(
                registeredBankAccountId,
                registeredBankAccount.getMembershipId().getValue(),
                registeredBankAccount.getBankType(),
                registeredBankAccount.getBankAccountNumber().getValue(),
                registeredBankAccount.getLinkedStatusIsValid().isValue()
        );
    }
}
