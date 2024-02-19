package vvithnne.ewallet.bankingservice.adapter.out.external.bank;

import vvithnne.ewallet.bankingservice.adapter.out.external.bank.dto.request.GetBankAccountRequest;
import vvithnne.ewallet.bankingservice.adapter.out.external.bank.dto.response.GetBankAccountResponse;
import vvithnne.ewallet.bankingservice.application.port.out.RequestBankAccountInfoPort;
import vvithnne.ewallet.bankingservice.domain.BankAccount;
import vvithnne.ewallet.common.annotation.ExternalSystemAdapter;
import vvithnne.ewallet.common.constant.BankType;

@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(BankAccount bankAccount) {
        GetBankAccountRequest request = GetBankAccountRequest.of(bankAccount);

        GetBankAccountResponse response = new GetBankAccountResponse(
                request.bankCode(),
                request.bankAccountNumber(),
                true
        );

        return BankAccount.of(
                BankType.findBankTypeByCode(response.bankCode()),
                new BankAccount.BankAccountNumber(response.bankAccountNumber()),
                new BankAccount.IsValid(response.isValid())
        );
    }

}
