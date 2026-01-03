package matalvesdev.picpay_challenge.repository;

import matalvesdev.picpay_challenge.entities.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}