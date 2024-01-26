package vvithnne.ewallet.membership.application.port.in;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import static vvithnne.ewallet.common.validator.Validation.validate;

@Builder
public record ModifyMembershipCommand(
        @NotNull Long membershipId,

        @NotBlank String name,

        @Email String email,

        @NotBlank String address,

        @AssertTrue boolean isValid,

        boolean isCorp
) {

    public ModifyMembershipCommand(
            Long membershipId,
            String name,
            String email,
            String address,
            boolean isValid,
            boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
        validate(this);
    }

}
