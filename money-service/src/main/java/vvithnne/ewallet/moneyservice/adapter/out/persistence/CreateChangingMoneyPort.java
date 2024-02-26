package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import vvithnne.ewallet.moneyservice.domain.ChangingMoney;

public interface CreateChangingMoneyPort {

    ChangingMoney createChangingMoney(ChangingMoney changingMoney);

}
