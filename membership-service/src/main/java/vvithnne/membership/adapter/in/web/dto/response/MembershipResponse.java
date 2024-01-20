package vvithnne.membership.adapter.in.web.dto.response;

import lombok.Builder;
import vvithnne.membership.domain.Membership;

@Builder
public record MembershipResponse(
        Long membershipId,

        String name,

        String email,

        String address,

        boolean isValid,

        boolean isCorp
) {

    public static MembershipResponse of(Membership membership) {
        return MembershipResponse.builder()
                .membershipId(membership.getMembershipId().getValue())
                .name(membership.getName().getValue())
                .email(membership.getEmail().getValue())
                .address(membership.getAddress().getValue())
                .isValid(membership.getIsValid().isValue())
                .isCorp(membership.getIsCorp().isValue())
                .build();
    }

}
