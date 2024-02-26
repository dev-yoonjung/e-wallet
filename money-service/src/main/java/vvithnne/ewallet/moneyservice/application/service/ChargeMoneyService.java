package vvithnne.ewallet.moneyservice.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vvithnne.ewallet.common.annotation.UseCase;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.ChargeMoneyPort;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.CreateChangingMoneyPort;
import vvithnne.ewallet.moneyservice.adapter.out.persistence.UpdateChangingMoneyStatusPort;
import vvithnne.ewallet.moneyservice.application.port.in.ChargeMoneyCommand;
import vvithnne.ewallet.moneyservice.application.port.in.ChargeMoneyUseCase;
import vvithnne.ewallet.moneyservice.common.constant.ChangingStatus;
import vvithnne.ewallet.moneyservice.common.constant.ChangingType;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney;
import vvithnne.ewallet.moneyservice.domain.Member;
import vvithnne.ewallet.moneyservice.domain.Member.MembershipId;
import vvithnne.ewallet.moneyservice.domain.Money;
import vvithnne.ewallet.moneyservice.domain.Wallet;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ChargeMoneyService implements ChargeMoneyUseCase {

    private final CreateChangingMoneyPort createChangingMoneyPort;

    private final UpdateChangingMoneyStatusPort updateChangingMoneyStatusPort;

    private final ChargeMoneyPort chargeMoneyPort;

    @Override
    public ChangingMoney requestForIncreaseMoney(ChargeMoneyCommand command) {
        // 1. 고객 정보가 정상인지 확인 (멤버)

        // 2. 고객의 연동된 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)

        // 3. 법인 계좌 상태도 정상인지 확인 (뱅킹)

        ChangingMoney changingMoney = ChangingMoney.of(
                Member.of(new MembershipId(command.membershipId())),
                ChangingType.INCREASE,
                Money.of(command.amount())
        );

        changingMoney = createChangingMoneyPort.createChangingMoney(changingMoney);

        // 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌) (뱅킹)

        // 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴
        // 성공 시에 멤버의 MemberMoney 값 증액이 필요해요
        Wallet wallet = chargeMoneyPort.increaseMoney(changingMoney.getMember(), changingMoney.getAmount());
        changingMoney = updateChangingMoneyStatusPort.updateStatus(changingMoney.getChangingId(), ChangingStatus.COMPLETED);

        // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴
        // changingMoney = updateChangingMoneyStatusPort.updateStatus(changingMoney.getChangingId(), ChangingStatus.FAILED);

        return changingMoney;
    }

}
