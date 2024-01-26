package vvithnne.ewallet.membership.application.port.out;

import vvithnne.ewallet.membership.domain.Membership;

public interface RegisterMembershipPort {

    Membership createMembership(Membership membership);

}
