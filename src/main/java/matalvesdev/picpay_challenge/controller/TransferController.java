package matalvesdev.picpay_challenge.controller;

import feign.Response;
import jakarta.validation.Valid;
import matalvesdev.picpay_challenge.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import matalvesdev.picpay_challenge.controller.dto.TransferDto;
import matalvesdev.picpay_challenge.entities.Transfer;
@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto) {

        var resp = transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }
}
