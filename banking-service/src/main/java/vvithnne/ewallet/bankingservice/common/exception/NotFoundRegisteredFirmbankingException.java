package vvithnne.ewallet.bankingservice.common.exception;

import org.springframework.http.HttpStatus;
import vvithnne.ewallet.common.exception.BusinessException;

public class NotFoundRegisteredFirmbankingException extends BusinessException {

    public NotFoundRegisteredFirmbankingException() {
        super(HttpStatus.BAD_REQUEST.value(), "펌뱅킹 요청 정보를 찾지 못했습니다.");
    }

}
