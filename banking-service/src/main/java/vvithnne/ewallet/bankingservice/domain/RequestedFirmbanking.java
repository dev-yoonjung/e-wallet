package vvithnne.ewallet.bankingservice.domain;

import lombok.*;
import vvithnne.ewallet.common.constant.BankType;
import vvithnne.ewallet.bankingservice.domain.BankAccount.BankAccountNumber;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestedFirmbanking {

    @Getter private final RequestedFirmbankingId requestedFirmbankingId;

    @Getter private final BankType fromBank;

    @Getter private final BankAccountNumber fromBankAccountNumber;

    @Getter private final BankType toBank;

    @Getter private final BankAccountNumber toBankAccountNumber;

    @Getter private final Money moneyAmount;

    @Getter private final FirmbankingStatus firmbankingStatus;

    @Getter private final UUID uuid;

    /**
     * Creates an {@link RequestedFirmbanking} entity without an ID. Use to create a new entity that is not yet
     * persisted.
     */
    public static RequestedFirmbanking of(
            BankType fromBank,
            BankAccountNumber fromBankAccountNumber,
            BankType toBank,
            BankAccountNumber toBankAccountNumber,
            Money moneyAmount
    ) {
        return new RequestedFirmbanking(
                null,
                fromBank,
                fromBankAccountNumber,
                toBank,
                toBankAccountNumber,
                moneyAmount,
                FirmbankingStatus.REQUESTED,
                UUID.randomUUID()
        );
    }

    /**
     * Creates an {@link RequestedFirmbanking} entity with an ID. Use to reconstitute a persisted entity.
     */
    public static RequestedFirmbanking of(
            RequestedFirmbankingId requestedFirmbankingId,
            BankType fromBank,
            BankAccountNumber fromBankAccountNumber,
            BankType toBank,
            BankAccountNumber toBankAccountNumber,
            Money moneyAmount,
            FirmbankingStatus firmbankingStatus,
            String uuid
    ) {
        return new RequestedFirmbanking(
                requestedFirmbankingId,
                fromBank,
                fromBankAccountNumber,
                toBank,
                toBankAccountNumber,
                moneyAmount,
                firmbankingStatus,
                UUID.fromString(uuid)
        );
    }

    @Value
    @AllArgsConstructor
    public static class RequestedFirmbankingId {
        Long value;
    }

    @RequiredArgsConstructor
    public enum FirmbankingStatus {

        REQUESTED(0, "요청"),

        COMPLETED(1, "완료"),

        FAILED(2, "실패");

        @Getter private final int code;

        @Getter private final String name;

        private static final Map<Integer, FirmbankingStatus> codeMapper = Collections.unmodifiableMap(
                Stream.of(
                        values()
                ).collect(
                        Collectors
                                .toMap(FirmbankingStatus::getCode, Function.identity())
                )
        );

        public static FirmbankingStatus findFirmbankingStatusByCode(int code) {
            return codeMapper.get(code);
        }

    }

}
