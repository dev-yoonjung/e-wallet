package vvithnne.ewallet.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vvithnne.ewallet.membership.adapter.in.web.dto.request.ModifyMembershipRequest;
import vvithnne.ewallet.membership.adapter.in.web.dto.response.MembershipResponse;
import vvithnne.ewallet.membership.application.port.in.ModifyMembershipCommand;
import vvithnne.ewallet.membership.application.port.in.ModifyMembershipUseCase;
import vvithnne.ewallet.common.annotation.WebAdapter;
import vvithnne.ewallet.membership.domain.Membership;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PutMapping("/membership/{membershipId}")
    ResponseEntity<MembershipResponse> modifyMembershipByMembershipId(
            @PathVariable Long membershipId,
            @RequestBody ModifyMembershipRequest request
    ) {
        ModifyMembershipCommand command = request.toCommand(membershipId);
        Membership membership = modifyMembershipUseCase.modifyMembership(command);
        MembershipResponse response = MembershipResponse.of(membership);

        return ResponseEntity.ok(response);
    }


}
