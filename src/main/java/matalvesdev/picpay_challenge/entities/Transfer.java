package matalvesdev.picpay_challenge.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private WalletEntity sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private WalletEntity receiver;

    @Column(name = "value")
    private BigDecimal value;

    public Transfer() {
    }

    public Transfer(WalletEntity sender, WalletEntity receiver, BigDecimal value) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public WalletEntity getSender() {
        return sender;
    }

    public void setSender(WalletEntity sender) {
        this.sender = sender;
    }

    public WalletEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(WalletEntity receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}