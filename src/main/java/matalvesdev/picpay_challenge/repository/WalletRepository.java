package matalvesdev.picpay_challenge.repository;

import matalvesdev.picpay_challenge.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

    Optional<WalletEntity> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
