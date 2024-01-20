package vvithnne.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter private final String membershipId;

    @Getter private final String name;

    @Getter private final String email;

    @Getter private final String address;

    @Getter private final boolean isValid;

    @Getter private final boolean isCorp;

    public static Membership generateMember(
            MembershipId membershipId,
            MembershipName name,
            MembershipEmail email,
            MembershipAddress address,
            MembershipIsValid isValid,
            MembershipIsCorp isCorp
    ) {
        return new Membership(
                membershipId.value,
                name.value,
                email.value,
                address.value,
                isValid.value,
                isCorp.value
        );
    }

    @Value
    @AllArgsConstructor
    public static class MembershipId {
        String value;
    }

    @Value
    @AllArgsConstructor
    public static class MembershipName {
        String value;
    }

    @Value
    @AllArgsConstructor
    public static class MembershipEmail {
        String value;
    }

    @Value
    @AllArgsConstructor
    public static class MembershipAddress {
        String value;
    }

    @Value
    @AllArgsConstructor
    public static class MembershipIsValid {
        boolean value;
    }

    @Value
    @AllArgsConstructor
    public static class MembershipIsCorp {
        boolean value;
    }

}
