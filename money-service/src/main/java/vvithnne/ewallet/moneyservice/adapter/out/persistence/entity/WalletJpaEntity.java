package vvithnne.ewallet.moneyservice.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "wallet")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WalletJpaEntity {

    @Id
    @GeneratedValue
    private Long walletId;

    @Column(unique = true)
    private Long membershipId;

    private BigDecimal balance;

    public void increase(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    @Override
    public String toString() {
        return "WalletJpaEntity{" +
                "walletId=" + walletId +
                ", membershipId=" + membershipId +
                ", balance=" + balance +
                '}';
    }
}
