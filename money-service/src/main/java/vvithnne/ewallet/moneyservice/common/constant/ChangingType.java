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
public enum ChangingType implements CodedEnum<Integer> {

    INCREASE(0, "증액"),

    DECREASE(1, "감액");

    private final int code;

    private final String name;

    private static final Map<Integer, ChangingType> codeMapper = Collections.unmodifiableMap(
            Stream.of(
                    values()
            ).collect(
                    Collectors
                            .toMap(ChangingType::getCode, Function.identity())
            )
    );

    public static ChangingType findChangingTypeByCode(int code) {
        return codeMapper.get(code);
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<ChangingType, Integer> {
        public Converter() {
            super(ChangingType.class);
        }

        @Override
        public Integer convertToDatabaseColumn(ChangingType changingType) {
            return changingType.getCode();
        }
    }
}
