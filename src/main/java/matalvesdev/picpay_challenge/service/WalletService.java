package matalvesdev.picpay_challenge.service;



import matalvesdev.picpay_challenge.controller.dto.WalletDto;
import matalvesdev.picpay_challenge.entities.WalletEntity;
import matalvesdev.picpay_challenge.exceptions.WalletDataAlreadyExistsException;
import matalvesdev.picpay_challenge.repository.WalletRepository;
import org.springframework.stereotype.Service;


@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public WalletEntity createWallet(WalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}