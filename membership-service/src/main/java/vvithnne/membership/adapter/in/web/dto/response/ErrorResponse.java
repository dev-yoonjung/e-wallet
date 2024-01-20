package vvithnne.membership.adapter.in.web.dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
public record ErrorResponse(
        int status,

        List<String> errorMessages
) {

    public static ErrorResponse of(HttpStatus status, List<String> errorMessages) {
        return ErrorResponse.builder()
                .status(status.value())
                .errorMessages(errorMessages)
                .build();
    }

}
