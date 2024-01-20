package vvithnne.membership.application.port.in;

import vvithnne.membership.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);

}
