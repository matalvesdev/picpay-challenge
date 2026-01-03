package matalvesdev.picpay_challenge.controller;


import jakarta.validation.Valid;
import matalvesdev.picpay_challenge.controller.dto.WalletDto;
import matalvesdev.picpay_challenge.entities.WalletEntity;
import matalvesdev.picpay_challenge.entities.WalletType;
import matalvesdev.picpay_challenge.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<WalletEntity> createWallet(@RequestBody @Valid WalletDto dto) {
        if (dto.walletEntityType() == null) {
            dto = new WalletDto(
                dto.fullName(),
                dto.cpfCnpj(),
                dto.email(),
                dto.password(),
                WalletType.Enum.USER // Default to USER if null
            );
        }

        var wallet = walletService.createWallet(dto);

        return ResponseEntity.ok(wallet);
    }
}