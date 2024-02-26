package vvithnne.ewallet.moneyservice.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vvithnne.ewallet.moneyservice.common.constant.ChangingStatus;
import vvithnne.ewallet.moneyservice.common.constant.ChangingType;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "changing_money")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChangingMoneyJpaEntity {

    @Id
    @GeneratedValue
    private Long changingMoneyId;

    private Long membershipId;

    private ChangingType changingType;

    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Instant timestamp;

    private ChangingStatus status;

    private String uuid;

    public void updateStatus(ChangingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChangingMoneyJpaEntity{" +
                "changingMoneyId=" + changingMoneyId +
                ", membershipId=" + membershipId +
                ", changingType=" + changingType +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", status=" + status +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
