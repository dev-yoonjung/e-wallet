package vvithnne.ewallet.membership.adapter.in.web.dto.request;

import vvithnne.ewallet.membership.application.port.in.ModifyMembershipCommand;
import vvithnne.ewallet.membership.common.exception.NotMatchedMembershipIdException;

public record ModifyMembershipRequest(
        Long membershipId,

        String name,

        String address,

        String email,

        boolean isValid,

        boolean isCorp
) {
    public ModifyMembershipCommand toCommand(Long membershipId) {
        if (!membershipId.equals(this.membershipId)) {
            throw new NotMatchedMembershipIdException();
        }

        return ModifyMembershipCommand.builder()
                .membershipId(this.membershipId)
                .name(this.name)
                .address(this.address)
                .email(this.email)
                .isValid(this.isValid)
                .isCorp(this.isCorp)
                .build();
    }
}
