package vvithnne.ewallet.membership.common.exception;

import org.springframework.http.HttpStatus;
import vvithnne.ewallet.common.exception.BusinessException;

public class NotMatchedMembershipIdException extends BusinessException {

    public NotMatchedMembershipIdException() {
        super(HttpStatus.BAD_REQUEST.value(), "멤버쉽 아이디가 일치하지 않습니다.");
    }
}
