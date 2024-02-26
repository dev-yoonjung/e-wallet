package vvithnne.ewallet.moneyservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Wallet {

    @Getter private final WalletId walletId;

    @Getter private final Member member;

    @Getter private final Money balance;

    @Value
    @AllArgsConstructor
    public static class WalletId {
        Long value;
    }

    /**
     * Creates an {@link Wallet} entity without an ID. Use to create a new entity that is not yet
     * persisted.
     */
    public static Wallet of(
            Member member,
            Money balance
    ) {
        return new Wallet(
                null,
                member,
                balance
        );
    }

    /**
     * Creates an {@link Wallet} entity with an ID. Use to reconstitute a persisted entity.
     */
    public static Wallet of(
            WalletId walletId,
            Member member,
            Money balance
    ) {
        return new Wallet(
                walletId,
                member,
                balance
        );
    }

}
