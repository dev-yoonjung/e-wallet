package vvithnne.ewallet.bankingservice.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vvithnne.ewallet.common.constant.BankType;

@Entity
@Table(name = "registered_bank_account")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue
    private Long RegisteredBankAccountId;

    private Long membershipId;

    private BankType bankType;

    private String bankAccountNumber;

    private boolean linkedStatusIsValid;

    @Override
    public String toString() {
        return "RegisteredBankAccountJpaEntity{" +
                "RegisteredBankAccountId=" + RegisteredBankAccountId +
                ", membershipId=" + membershipId +
                ", bankType=" + bankType +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", linkedStatusIsValid=" + linkedStatusIsValid +
                '}';
    }
}
