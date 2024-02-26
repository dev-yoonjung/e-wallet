package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import vvithnne.ewallet.moneyservice.common.constant.ChangingStatus;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney.ChangingId;


public interface UpdateChangingMoneyStatusPort {

    ChangingMoney updateStatus(ChangingId changingId, ChangingStatus status);

}
