package vvithnne.ewallet.moneyservice.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import vvithnne.ewallet.common.constant.util.AbstractCodedEnumConverter;
import vvithnne.ewallet.common.constant.util.CodedEnum;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum ChangingStatus implements CodedEnum<Integer> {

    REQUESTED(0, "요청"),

    COMPLETED(1, "완료"),

    FAILED(2, "실패");

    private final int code;

    private final String name;

    private static final Map<Integer, ChangingStatus> codeMapper = Collections.unmodifiableMap(
            Stream.of(
                    values()
            ).collect(
                    Collectors
                            .toMap(ChangingStatus::getCode, Function.identity())
            )
    );

    public static ChangingStatus findChangingStatusByCode(int code) {
        return codeMapper.get(code);
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<ChangingStatus, Integer> {
        public Converter() {
            super(ChangingStatus.class);
        }

        @Override
        public Integer convertToDatabaseColumn(ChangingStatus changingStatus) {
            return changingStatus.getCode();
        }
    }
}
