package vvithnne.ewallet.bankingservice.application.port.in;

import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);

}
