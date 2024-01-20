package vvithnne.membership.application.port.out;

import vvithnne.membership.domain.Membership;

public interface FindMembershipPort {

    Membership findMembership(Membership.MembershipId membershipId);

}
