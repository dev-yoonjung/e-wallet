package vvithnne.ewallet.bankingservice.adapter.out.external.bank.dto.response;


public record GetBankAccountResponse(
        String bankCode,

        String bankAccountNumber,

        boolean isValid
) {

}
