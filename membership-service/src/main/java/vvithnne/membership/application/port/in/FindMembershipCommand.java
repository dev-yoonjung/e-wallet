package vvithnne.membership.application.port.in;

import jakarta.validation.constraints.NotNull;

import static vvithnne.membership.common.Validation.validate;

public record FindMembershipCommand(@NotNull Long membershipId) {

    public FindMembershipCommand(Long membershipId) {
        this.membershipId = membershipId;
        validate(this);
    }

}
