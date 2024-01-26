package vvithnne.ewallet.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vvithnne.ewallet.membership.application.port.in.ModifyMembershipCommand;
import vvithnne.ewallet.membership.application.port.in.ModifyMembershipUseCase;
import vvithnne.ewallet.membership.application.port.out.ModifyMembershipPort;
import vvithnne.ewallet.common.annotation.UseCase;
import vvithnne.ewallet.membership.domain.Membership;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        Membership membership = Membership.of(
          new Membership.MembershipId(command.membershipId()),
          new Membership.MembershipName(command.name()),
          new Membership.MembershipEmail(command.email()),
          new Membership.MembershipAddress(command.address()),
          new Membership.MembershipIsValid(command.isValid()),
          new Membership.MembershipIsCorp(command.isCorp())
        );

        return modifyMembershipPort.modifyMembership(membership);
    }
}
