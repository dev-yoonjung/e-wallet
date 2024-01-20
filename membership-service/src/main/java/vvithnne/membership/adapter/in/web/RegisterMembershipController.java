package vvithnne.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vvithnne.membership.adapter.in.web.dto.response.MembershipResponse;
import vvithnne.membership.adapter.in.web.dto.request.RegisterMembershipRequest;
import vvithnne.membership.application.port.in.RegisterMembershipCommand;
import vvithnne.membership.application.port.in.RegisterMembershipUseCase;
import vvithnne.membership.common.annotation.WebAdapter;
import vvithnne.membership.domain.Membership;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership")
    ResponseEntity<MembershipResponse> registerMembership(@RequestBody RegisterMembershipRequest request) {
        RegisterMembershipCommand command = request.toCommand();
        Membership membership = registerMembershipUseCase.registerMembership(command);
        MembershipResponse response = MembershipResponse.of(membership);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
