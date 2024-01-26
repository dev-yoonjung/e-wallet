package vvithnne.ewallet.membership.application.port.in;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import static vvithnne.ewallet.common.validator.Validation.validate;

@Builder
public record RegisterMembershipCommand(
        @NotBlank String name,

        @Email String email,

        @NotBlank String address,

        @AssertTrue boolean isValid,

        boolean isCorp
) {

    public RegisterMembershipCommand(
            String name,
            String email,
            String address,
            boolean isValid,
            boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
        validate(this);
    }

}
