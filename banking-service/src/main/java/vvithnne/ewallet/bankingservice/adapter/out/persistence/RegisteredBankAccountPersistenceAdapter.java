package vvithnne.ewallet.bankingservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import vvithnne.ewallet.bankingservice.adapter.out.persistence.entity.RegisteredBankAccountJpaEntity;
import vvithnne.ewallet.bankingservice.application.port.out.RegisterBankAccountPort;
import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount;
import vvithnne.ewallet.common.annotation.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;

    @Override
    public RegisteredBankAccount createRegisteredBankAccount(RegisteredBankAccount registeredBankAccount) {
        RegisteredBankAccountJpaEntity entity = registeredBankAccountRepository.save(
                registeredBankAccountMapper.mapToJpaEntity(registeredBankAccount)
        );

        return registeredBankAccountMapper.mapToDomain(entity);
    }

}
