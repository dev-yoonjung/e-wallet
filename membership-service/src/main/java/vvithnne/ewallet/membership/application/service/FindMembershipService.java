package vvithnne.ewallet.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vvithnne.ewallet.membership.application.port.in.FindMembershipCommand;
import vvithnne.ewallet.membership.application.port.in.FindMembershipUseCase;
import vvithnne.ewallet.membership.application.port.out.FindMembershipPort;
import vvithnne.ewallet.common.annotation.UseCase;
import vvithnne.ewallet.membership.domain.Membership;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        Membership.MembershipId membershipId = new Membership.MembershipId(command.membershipId());

        return findMembershipPort.findMembership(membershipId);
    }

}
