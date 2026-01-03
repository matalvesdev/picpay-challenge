package matalvesdev.picpay_challenge.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import matalvesdev.picpay_challenge.entities.WalletEntity;
import matalvesdev.picpay_challenge.entities.WalletType;

public record WalletDto(@NotBlank String fullName,
                        @NotBlank String cpfCnpj,
                        @NotBlank String email,
                        @NotBlank String password,
                        @NotNull WalletType.Enum walletEntityType) {

    public WalletEntity toWallet() {
        if (walletEntityType == null) {
            throw new IllegalArgumentException("WalletEntityType cannot be null");
        }
        return new WalletEntity (
            fullName,
            cpfCnpj,
            email,
            password,
            walletEntityType.get()
        );
    }
}
