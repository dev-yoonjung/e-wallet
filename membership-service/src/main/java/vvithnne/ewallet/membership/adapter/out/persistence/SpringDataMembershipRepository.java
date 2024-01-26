package vvithnne.ewallet.membership.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import vvithnne.ewallet.membership.adapter.out.persistence.entity.MembershipJpaEntity;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
}
