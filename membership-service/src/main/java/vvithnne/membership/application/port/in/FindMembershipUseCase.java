package vvithnne.membership.application.port.in;

import vvithnne.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);

}
