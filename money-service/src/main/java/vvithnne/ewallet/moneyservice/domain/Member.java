package vvithnne.ewallet.moneyservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Getter private final MembershipId membershipId;

    public static Member of(MembershipId membershipId) {
        return new Member(membershipId);
    }

    @Value
    @AllArgsConstructor
    public static class MembershipId {
        Long value;
    }

}
