package vvithnne.ewallet.common.constant;

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
public enum BankType implements CodedEnum<String> {

    KYONGNAMBANK("039", "경남", "KYONGNAMBANK"),

    GWANGJUBANK("034", "광주", "GWANGJUBANK"),

    LOCALNONGHYEOP("012", "단위농협", "LOCALNONGHYEOP"),

    BUSANBANK("032", "부산", "BUSANBANK"),

    SAEMAUL("045", "새마을", "SAEMAUL"),

    SANLIM("064", "산림", "SANLIM"),

    SHINHAN("088", "신한", "SHINHAN"),

    SHINHYEOP("048", "신협", "SHINHYEOP"),

    CITI("027", "씨티", "CITI"),

    WOORI("020", "우리", "WOORI"),

    POST("071", "우체국", "POST"),

    SAVINGBANK("050", "저축", "SAVINGBANK"),

    JEONBUKBANK("037", "전북", "JEONBUKBANK"),

    JEJUBANK("035", "제주", "JEJUBANK"),

    KAKAOBANK("090", "카카오", "KAKAOBANK"),

    TOSSBANK("092", "토스", "TOSSBANK"),

    HANA("081", "하나", "HANA"),

    IBK("003", "기업", "IBK"),

    KOOKMIN("004", "국민", "KOOKMIN"),

    DAEGUBANK("031", "대구", "DAEGUBANK"),

    KDBBANK("002", "산업", "KDBBANK"),

    NONGHYEOP("011", "농협", "NONGHYEOP"),

    SC("023", "SC제일", "SC"),

    SUHYEOP("007", "수협", "SUHYEOP");


    private final String code;

    private final String codeForKorean;

    private final String codeForEnglish;

    private static final Map<String, BankType> codeMapper = Collections.unmodifiableMap(
            Stream.of(
                    values()
            ).collect(
                    Collectors
                            .toMap(BankType::getCode, Function.identity())
            )
    );

    public static BankType findBankTypeByCode(String code) {
        return codeMapper.get(code);
    }

    @Override
    public String getCode() {
        return code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<BankType, String> {
        public Converter() {
            super(BankType.class);
        }

        @Override
        public String convertToDatabaseColumn(BankType bankType) {
            return bankType.getCode();
        }
    }
}
