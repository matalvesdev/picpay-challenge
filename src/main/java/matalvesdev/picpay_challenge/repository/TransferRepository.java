package matalvesdev.picpay_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import matalvesdev.picpay_challenge.entities.Transfer;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
