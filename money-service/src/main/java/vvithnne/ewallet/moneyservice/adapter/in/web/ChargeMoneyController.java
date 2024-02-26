package vvithnne.ewallet.moneyservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vvithnne.ewallet.common.annotation.WebAdapter;
import vvithnne.ewallet.moneyservice.adapter.in.web.dto.request.ChargeMoneyRequest;
import vvithnne.ewallet.moneyservice.adapter.in.web.dto.response.ChargeMoneyResponse;
import vvithnne.ewallet.moneyservice.application.port.in.ChargeMoneyCommand;
import vvithnne.ewallet.moneyservice.application.port.in.ChargeMoneyUseCase;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ChargeMoneyController {

    private final ChargeMoneyUseCase chargeMoneyUseCase;

    @PostMapping("/money/charge")
    ResponseEntity<ChargeMoneyResponse> chargeMoney(@RequestBody ChargeMoneyRequest request) {
        ChargeMoneyCommand command = request.toCommand();
        ChangingMoney changingMoney = chargeMoneyUseCase.requestForIncreaseMoney(command);
        ChargeMoneyResponse response = ChargeMoneyResponse.of(changingMoney);

        return ResponseEntity.ok(response);
    }

}
