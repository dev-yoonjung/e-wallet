package vvithnne.ewallet.bankingservice.application.port.out;

import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccount createRegisteredBankAccount(RegisteredBankAccount registeredBankAccount);

}
