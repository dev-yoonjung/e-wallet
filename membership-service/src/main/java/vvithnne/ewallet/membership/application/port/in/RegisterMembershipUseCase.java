package vvithnne.ewallet.membership.application.port.in;

import vvithnne.ewallet.membership.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);

}
