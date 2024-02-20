package vvithnne.ewallet.bankingservice.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vvithnne.ewallet.common.constant.BankType;

import java.math.BigDecimal;

@Entity
@Table(name = "requested_firmbanking")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestedFirmbankingJpaEntity {

    @Id
    @GeneratedValue
    private Long rquestedFirmbankingId;

    private BankType fromBank;

    private String fromBankAccountNumber;

    private BankType toBank;

    private String toBankAccountNumber;

    private BigDecimal moneyAmount;

    private Integer firmbankingStatus;

    private String uuid;

    public void updateStatus(int status) {
        this.firmbankingStatus = status;
    }

    @Override
    public String toString() {
        return "FirmbankingRequestHistoryJpaEntity{" +
                "rquestedFirmbankingId=" + rquestedFirmbankingId +
                ", fromBank=" + fromBank +
                ", fromBankAccountNumber='" + fromBankAccountNumber + '\'' +
                ", toBank=" + toBank +
                ", toBankAccountNumber='" + toBankAccountNumber + '\'' +
                ", moneyAmount=" + moneyAmount +
                ", firmbankingStatus=" + firmbankingStatus +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
