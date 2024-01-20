package vvithnne.membership.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundMembershipException extends BusinessException {

    public NotFoundMembershipException() {
        super(HttpStatus.BAD_REQUEST.value(), "회원 정보를 찾지 못했습니다.");
    }

}
