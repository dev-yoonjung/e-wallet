package vvithnne.membership.application.port.out;

import vvithnne.membership.domain.Membership;

public interface RegisterMembershipPort {

    Membership createMembership(Membership membership);

}
