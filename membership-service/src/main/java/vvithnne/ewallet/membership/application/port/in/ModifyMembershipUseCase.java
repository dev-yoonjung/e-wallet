package vvithnne.ewallet.membership.application.port.in;

import vvithnne.ewallet.membership.domain.Membership;

public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);

}
