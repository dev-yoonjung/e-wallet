package vvithnne.ewallet.bankingservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.request.RequestFirmbankingRequest;
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.response.RequestFirmbankingResponse;
import vvithnne.ewallet.bankingservice.application.port.in.RequestFirmbankingCommand;
import vvithnne.ewallet.bankingservice.application.port.in.RequestFirmbankingUseCase;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;
import vvithnne.ewallet.common.annotation.WebAdapter;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmbankingController {

    private final RequestFirmbankingUseCase requestFirmbankingUseCase;

    @PostMapping("/banking/firmbanking/request")
    ResponseEntity<RequestFirmbankingResponse> requestFirmbanking(@RequestBody RequestFirmbankingRequest request) {
        RequestFirmbankingCommand command = request.toCommand();
        RequestedFirmbanking requestedFirmbanking = requestFirmbankingUseCase.requestFirmbanking(command);
        RequestFirmbankingResponse response = RequestFirmbankingResponse.of(requestedFirmbanking);

        return ResponseEntity.ok(response);
    }

}
