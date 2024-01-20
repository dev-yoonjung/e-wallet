package vvithnne.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vvithnne.membership.application.port.in.FindMembershipCommand;
import vvithnne.membership.application.port.in.FindMembershipUseCase;
import vvithnne.membership.application.port.out.FindMembershipPort;
import vvithnne.membership.common.annotation.UseCase;
import vvithnne.membership.domain.Membership;

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
