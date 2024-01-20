package vvithnne.membership.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import vvithnne.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import vvithnne.membership.application.port.out.FindMembershipPort;
import vvithnne.membership.application.port.out.RegisterMembershipPort;
import vvithnne.membership.common.annotation.PersistenceAdapter;
import vvithnne.membership.common.exception.NotFoundMembershipException;
import vvithnne.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort,
                                                     FindMembershipPort {

    private final MembershipMapper membershipMapper;

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public Membership createMembership(Membership membership) {
        MembershipJpaEntity entity = membershipRepository.save(
                membershipMapper.mapToJpaEntity(membership)
        );

        return membershipMapper.mapToDomain(entity);
    }

    @Override
    public Membership findMembership(Membership.MembershipId membershipId) {
        MembershipJpaEntity entity = membershipRepository.findById(membershipId.getValue())
                .orElseThrow(NotFoundMembershipException::new);

        return membershipMapper.mapToDomain(entity);
    }
}
