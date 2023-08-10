package com.suhmoraes.test01.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_payload")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String payment_code;
    private String doc_payer;
    private String status;

    @ManyToOne
    @JoinColumn(name = "seller_code")
    private Seller seller_code;
}