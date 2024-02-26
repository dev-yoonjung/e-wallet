package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.entity.ChangingMoneyJpaEntity;

public interface SpringDataChangingMoneyRepository extends JpaRepository<ChangingMoneyJpaEntity, Long> {
}
