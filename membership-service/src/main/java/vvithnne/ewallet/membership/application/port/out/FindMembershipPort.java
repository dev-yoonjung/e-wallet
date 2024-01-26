package vvithnne.ewallet.membership.application.port.out;

import vvithnne.ewallet.membership.domain.Membership;

public interface FindMembershipPort {

    Membership findMembership(Membership.MembershipId membershipId);

}
