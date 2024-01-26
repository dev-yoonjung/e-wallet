package vvithnne.ewallet.membership.adapter.in.web.dto.request;

import vvithnne.ewallet.membership.application.port.in.RegisterMembershipCommand;

public record RegisterMembershipRequest(
        String name,

        String address,

        String email,

        boolean isCorp
) {

    public RegisterMembershipCommand toCommand() {
        return RegisterMembershipCommand.builder()
                .name(this.name)
                .address(this.address)
                .email(this.email)
                .isValid(true)
                .isCorp(this.isCorp)
                .build();
    }

}
