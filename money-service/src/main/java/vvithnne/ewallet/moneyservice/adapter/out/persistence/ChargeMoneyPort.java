package vvithnne.ewallet.moneyservice.adapter.out.persistence;

import vvithnne.ewallet.moneyservice.domain.Member;
import vvithnne.ewallet.moneyservice.domain.Money;
import vvithnne.ewallet.moneyservice.domain.Wallet;

public interface ChargeMoneyPort {

    Wallet increaseMoney(Member member, Money amount);

}
