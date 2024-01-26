package vvithnne.ewallet.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter private final MembershipId membershipId;

    @Getter private final MembershipName name;

    @Getter private final MembershipEmail email;

    @Getter private final MembershipAddress address;

    @Getter private final MembershipIsValid isValid;

    @Getter private final MembershipIsCorp isCorp;

    /**
     * Creates an {@link Membership} entity without an ID. Use to create a new entity that is not yet
     * persisted.
     */
    public static Membership of(
            MembershipName name,
            MembershipEmail email,
            MembershipAddress address,
            MembershipIsValid isValid,
            MembershipIsCorp isCorp
    ) {
        return new Membership(
                null,
                name,
                email,
                address,
                isValid,
                isCorp
        );
    }

    /**
     * Creates an {@link Membership} entity with an ID. Use to reconstitute a persisted entity.
     */
    public static Membership of(
            MembershipId membershipId,
            MembershipName name,
            MembershipEmail email,
            MembershipAddress address,
            MembershipIsValid isValid,
            MembershipIsCorp isCorp
    ) {
        return new Membership(
                membershipId,
                name,
                email,
                address,
                isValid,
                isCorp
        );
    }

    @Value
    @AllArgsConstructor
    public static class MembershipId {
        Long value;
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
