package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vvithnne.ewallet.common.annotation.PersistenceAdapter;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.entity.WalletJpaEntity;
import vvithnne.ewallet.moneyservice.domain.Member;
import vvithnne.ewallet.moneyservice.domain.Money;
import vvithnne.ewallet.moneyservice.domain.Wallet;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class WalletPersistenceAdapter implements ChargeMoneyPort {

    private final SpringDataWalletRepository springDataWalletRepository;

    private final WalletMapper walletMapper;

    @Override
    public Wallet increaseMoney(Member member, Money amount) {
        WalletJpaEntity wallet = springDataWalletRepository.findByMembershipId(member.getMembershipId().getValue())
                .map(entity -> {
                    entity.increase(amount.getAmount());

                    return entity;
                })
                .orElseGet(() -> springDataWalletRepository.save(
                        walletMapper.mapToJpaEntity(member, amount)
                ));

        return walletMapper.mapToDomain(wallet);
    }
}
