package vvithnne.membership.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import vvithnne.membership.adapter.out.persistence.entity.MembershipJpaEntity;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
}
