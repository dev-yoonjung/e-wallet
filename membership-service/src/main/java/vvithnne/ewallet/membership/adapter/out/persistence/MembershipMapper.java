package vvithnne.ewallet.membership.adapter.out.persistence;

import org.springframework.stereotype.Component;
import vvithnne.ewallet.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import vvithnne.ewallet.membership.domain.Membership;

import java.util.Optional;

@Component
public class MembershipMapper {

    Membership mapToDomain(MembershipJpaEntity membership) {
        return Membership.of(
                new Membership.MembershipId(membership.getMembershipId()),
                new Membership.MembershipName(membership.getName()),
                new Membership.MembershipEmail(membership.getEmail()),
                new Membership.MembershipAddress(membership.getAddress()),
                new Membership.MembershipIsValid(membership.isValid()),
                new Membership.MembershipIsCorp(membership.isCorp())
        );
    }

    MembershipJpaEntity mapToJpaEntity(Membership membership) {
        Long membershipId = Optional.ofNullable(membership.getMembershipId())
                .map(Membership.MembershipId::getValue)
                .orElse(null);

        return new MembershipJpaEntity(
                membershipId,
                membership.getName().getValue(),
                membership.getEmail().getValue(),
                membership.getAddress().getValue(),
                membership.getIsValid().isValue(),
                membership.getIsCorp().isValue()
        );
    }

}
