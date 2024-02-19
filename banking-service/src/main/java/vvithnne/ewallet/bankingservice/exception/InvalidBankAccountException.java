package vvithnne.ewallet.bankingservice.exception;

import org.springframework.http.HttpStatus;
import vvithnne.ewallet.common.exception.BusinessException;

public class InvalidBankAccountException extends BusinessException {

    public InvalidBankAccountException() {
        super(HttpStatus.BAD_REQUEST.value(), "올바르지 않은 은행 계좌입니다.");
    }

}
