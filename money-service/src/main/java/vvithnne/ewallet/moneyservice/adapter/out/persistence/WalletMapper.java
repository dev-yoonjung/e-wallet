package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import org.springframework.stereotype.Component;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.entity.WalletJpaEntity;
import vvithnne.ewallet.moneyservice.domain.Member;
import vvithnne.ewallet.moneyservice.domain.Member.MembershipId;
import vvithnne.ewallet.moneyservice.domain.Money;
import vvithnne.ewallet.moneyservice.domain.Wallet;
import vvithnne.ewallet.moneyservice.domain.Wallet.WalletId;

@Component
public class WalletMapper {

    Wallet mapToDomain(WalletJpaEntity wallet) {
        return Wallet.of(
                new WalletId(wallet.getWalletId()),
                Member.of(new MembershipId(wallet.getWalletId())),
                new Money(wallet.getBalance())
        );
    }

    WalletJpaEntity mapToJpaEntity(Member member, Money balance) {
        return new WalletJpaEntity(
                null,
                member.getMembershipId().getValue(),
                balance.getAmount()
        );
    }

}
