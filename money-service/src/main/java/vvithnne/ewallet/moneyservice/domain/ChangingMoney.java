package vvithnne.ewallet.moneyservice.domain;

import lombok.*;
import vvithnne.ewallet.moneyservice.common.constant.ChangingStatus;
import vvithnne.ewallet.moneyservice.common.constant.ChangingType;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChangingMoney {

    @Getter private final ChangingId changingId;

    @Getter private final Member member;

    @Getter private final ChangingType changingType;

    @Getter private final Money amount;

    @Getter private final ChangingStatus changingStatus;

    @Getter private final UUID uuid;

    @Getter private final DateTime createdAt;

    /**
     * Creates an {@link ChangingMoney} entity without an ID. Use to create a new entity that is not yet
     * persisted.
     */
    public static ChangingMoney of(
            Member member,
            ChangingType changingType,
            Money amount
    ) {
        return new ChangingMoney(
                null,
                member,
                changingType,
                amount,
                ChangingStatus.REQUESTED,
                UUID.randomUUID(),
                DateTime.NOW
        );
    }

    /**
     * Creates an {@link ChangingMoney} entity with an ID. Use to reconstitute a persisted entity.
     */
    public static ChangingMoney of(
            ChangingId changingId,
            Member member,
            ChangingType changingType,
            Money amount,
            ChangingStatus changingStatus,
            String uuid,
            DateTime createdAt
    ) {
        return new ChangingMoney(
                changingId,
                member,
                changingType,
                amount,
                changingStatus,
                UUID.fromString(uuid),
                createdAt
        );
    }

    @Value
    @AllArgsConstructor
    public static class ChangingId {
        Long value;
    }

}
