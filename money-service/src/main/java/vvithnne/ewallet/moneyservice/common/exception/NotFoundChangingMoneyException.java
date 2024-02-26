package vvithnne.ewallet.moneyservice.common.exception;

import org.springframework.http.HttpStatus;
import vvithnne.ewallet.common.exception.BusinessException;

public class NotFoundChangingMoneyException extends BusinessException {

    public NotFoundChangingMoneyException() {
        super(HttpStatus.BAD_REQUEST.value(), "잔액 변동 내역을 찾지 못했습니다.");
    }

}
