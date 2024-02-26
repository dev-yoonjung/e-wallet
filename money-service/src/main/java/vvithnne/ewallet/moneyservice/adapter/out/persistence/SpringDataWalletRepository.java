package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.entity.WalletJpaEntity;

import java.util.Optional;

public interface SpringDataWalletRepository extends JpaRepository<WalletJpaEntity, Long> {

    Optional<WalletJpaEntity> findByMembershipId(Long membershipId);

}
