package vvithnne.ewallet.membership.application.port.in;

import vvithnne.ewallet.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);

}
