package vvithnne.ewallet.bankingservice.application.port.out;

import vvithnne.ewallet.bankingservice.domain.BankAccount;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(BankAccount bankAccount);

}
