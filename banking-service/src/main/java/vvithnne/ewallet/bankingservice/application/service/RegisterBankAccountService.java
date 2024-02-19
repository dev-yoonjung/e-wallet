package vvithnne.ewallet.bankingservice.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vvithnne.ewallet.bankingservice.application.port.in.RegisterBankAccountCommand;
import vvithnne.ewallet.bankingservice.application.port.in.RegisterBankAccountUseCase;
import vvithnne.ewallet.bankingservice.application.port.out.RegisterBankAccountPort;
import vvithnne.ewallet.bankingservice.application.port.out.RequestBankAccountInfoPort;
import vvithnne.ewallet.bankingservice.domain.BankAccount;
import vvithnne.ewallet.bankingservice.domain.BankAccount.BankAccountNumber;
import vvithnne.ewallet.bankingservice.domain.BankAccount.IsValid;
import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount;
import vvithnne.ewallet.common.annotation.UseCase;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {
        BankAccount bankAccount = requestBankAccountInfoPort.getBankAccountInfo(
                BankAccount.of(
                        command.bankType(),
                        new BankAccount.BankAccountNumber(command.bankAccountNumber())
                )
        );

        bankAccount.validate();

        RegisteredBankAccount registeredBankAccount = RegisteredBankAccount.of(
                new RegisteredBankAccount.MembershipId(command.membershipId()),
                bankAccount.getBankType(),
                new BankAccountNumber(bankAccount.getBankAccountNumber().getValue()),
                new IsValid(bankAccount.getIsValid().isValue())
        );

        return registerBankAccountPort.createRegisteredBankAccount(registeredBankAccount);
    }

}
