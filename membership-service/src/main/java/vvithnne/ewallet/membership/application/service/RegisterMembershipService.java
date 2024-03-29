package vvithnne.ewallet.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vvithnne.ewallet.membership.application.port.in.RegisterMembershipCommand;
import vvithnne.ewallet.membership.application.port.in.RegisterMembershipUseCase;
import vvithnne.ewallet.membership.application.port.out.RegisterMembershipPort;
import vvithnne.ewallet.common.annotation.UseCase;
import vvithnne.ewallet.membership.domain.Membership;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        Membership membership = Membership.of(
                new Membership.MembershipName(command.name()),
                new Membership.MembershipEmail(command.email()),
                new Membership.MembershipAddress(command.address()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return registerMembershipPort.createMembership(membership);
    }

}
