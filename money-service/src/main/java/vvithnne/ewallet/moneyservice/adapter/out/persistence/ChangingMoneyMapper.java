package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import org.springframework.stereotype.Component;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.entity.ChangingMoneyJpaEntity;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney.ChangingId;
import vvithnne.ewallet.moneyservice.domain.DateTime;
import vvithnne.ewallet.moneyservice.domain.Member;
import vvithnne.ewallet.moneyservice.domain.Member.MembershipId;
import vvithnne.ewallet.moneyservice.domain.Money;

import java.util.Optional;

@Component
public class ChangingMoneyMapper {

    ChangingMoney mapToDomain(ChangingMoneyJpaEntity changingMoney) {
        return ChangingMoney.of(
                new ChangingId(changingMoney.getChangingMoneyId()),
                Member.of(new MembershipId(changingMoney.getMembershipId())),
                changingMoney.getChangingType(),
                new Money(changingMoney.getAmount()),
                changingMoney.getStatus(),
                changingMoney.getUuid(),
                new DateTime(changingMoney.getTimestamp())
        );
    }

    ChangingMoneyJpaEntity mapToJpaEntity(ChangingMoney changingMoney) {
        Long changingMoneyId = Optional.ofNullable(changingMoney.getChangingId())
                .map(ChangingId::getValue)
                .orElse(null);

        return new ChangingMoneyJpaEntity(
                changingMoneyId,
                changingMoney.getMember().getMembershipId().getValue(),
                changingMoney.getChangingType(),
                changingMoney.getAmount().getAmount(),
                changingMoney.getCreatedAt().getInstant(),
                changingMoney.getChangingStatus(),
                changingMoney.getUuid().toString()
        );
    }

}
