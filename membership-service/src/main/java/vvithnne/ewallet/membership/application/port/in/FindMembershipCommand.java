package vvithnne.ewallet.membership.application.port.in;

import jakarta.validation.constraints.NotNull;

import static vvithnne.ewallet.common.validator.Validation.validate;


public record FindMembershipCommand(@NotNull Long membershipId) {

    public FindMembershipCommand(Long membershipId) {
        this.membershipId = membershipId;
        validate(this);
    }

}
