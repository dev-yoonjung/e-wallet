package vvithnne.ewallet.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vvithnne.ewallet.membership.adapter.in.web.dto.response.MembershipResponse;
import vvithnne.ewallet.membership.application.port.in.FindMembershipCommand;
import vvithnne.ewallet.membership.application.port.in.FindMembershipUseCase;
import vvithnne.ewallet.common.annotation.WebAdapter;
import vvithnne.ewallet.membership.domain.Membership;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    ResponseEntity<MembershipResponse> findMembershipByMembershipId(@PathVariable Long membershipId) {
        FindMembershipCommand command = new FindMembershipCommand(membershipId);
        Membership membership = findMembershipUseCase.findMembership(command);
        MembershipResponse response = MembershipResponse.of(membership);

        return ResponseEntity.ok(response);
    }

}
