package vvithnne.ewallet.membership.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import vvithnne.ewallet.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import vvithnne.ewallet.membership.application.port.out.FindMembershipPort;
import vvithnne.ewallet.membership.application.port.out.ModifyMembershipPort;
import vvithnne.ewallet.membership.application.port.out.RegisterMembershipPort;
import vvithnne.ewallet.common.annotation.PersistenceAdapter;
import vvithnne.ewallet.membership.common.exception.NotFoundMembershipException;
import vvithnne.ewallet.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort,
                                                     FindMembershipPort,
                                                     ModifyMembershipPort {

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

    @Override
    public Membership modifyMembership(Membership membership) {
        MembershipJpaEntity entity = membershipRepository.findById(membership.getMembershipId().getValue())
                .orElseThrow(NotFoundMembershipException::new);
        entity.modify(
                membership.getName().getValue(),
                membership.getAddress().getValue(),
                membership.getEmail().getValue(),
                membership.getIsValid().isValue(),
                membership.getIsCorp().isValue()
        );

        return membershipMapper.mapToDomain(entity);
    }
}
