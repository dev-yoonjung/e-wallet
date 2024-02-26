package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import vvithnne.ewallet.common.annotation.PersistenceAdapter;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.entity.ChangingMoneyJpaEntity;
import vvithnne.ewallet.moneyservice.common.constant.ChangingStatus;
import vvithnne.ewallet.moneyservice.common.exception.NotFoundChangingMoneyException;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney;

@PersistenceAdapter
@RequiredArgsConstructor
public class ChangingMoneyPersistenceAdapter implements CreateChangingMoneyPort,
                                                        UpdateChangingMoneyStatusPort {

    private final SpringDataChangingMoneyRepository changingMoneyRepository;

    private final ChangingMoneyMapper changingMoneyMapper;

    @Override
    public ChangingMoney createChangingMoney(ChangingMoney changingMoney) {
        ChangingMoneyJpaEntity entity = changingMoneyRepository.save(
                changingMoneyMapper.mapToJpaEntity(changingMoney)
        );

        return changingMoneyMapper.mapToDomain(entity);
    }

    @Override
    public ChangingMoney updateStatus(ChangingMoney.ChangingId changingId, ChangingStatus status) {
        ChangingMoneyJpaEntity entity = changingMoneyRepository.findById(changingId.getValue())
                .orElseThrow(NotFoundChangingMoneyException::new);

        entity.updateStatus(status);

        return changingMoneyMapper.mapToDomain(entity);
    }
}
