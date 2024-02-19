package vvithnne.ewallet.bankingservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.request.RegisterBankAccountRequest;
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.response.RegisterBankAccountResponse;
import vvithnne.ewallet.bankingservice.application.port.in.RegisterBankAccountCommand;
import vvithnne.ewallet.bankingservice.application.port.in.RegisterBankAccountUseCase;
import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount;
import vvithnne.ewallet.common.annotation.WebAdapter;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/bank-account")
    ResponseEntity<RegisterBankAccountResponse> registerBankAccount(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = request.toCommand();
        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
        RegisterBankAccountResponse response = RegisterBankAccountResponse.of(registeredBankAccount);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
