package vvithnne.ewallet.moneyservice.application.port.in;

import vvithnne.ewallet.moneyservice.domain.ChangingMoney;

public interface ChargeMoneyUseCase {

    ChangingMoney requestForIncreaseMoney(ChargeMoneyCommand command);

}
