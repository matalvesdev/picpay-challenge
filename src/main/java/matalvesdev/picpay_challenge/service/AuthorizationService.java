package matalvesdev.picpay_challenge.service;

import org.springframework.stereotype.Service;
import matalvesdev.picpay_challenge.client.AuthorizationClient;
import matalvesdev.picpay_challenge.controller.dto.TransferDto;
import matalvesdev.picpay_challenge.exceptions.PicPayException;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer) {

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }
}
