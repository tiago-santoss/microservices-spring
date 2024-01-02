package br.com.spring.microservices.dto;

import br.com.spring.microservices.enums.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDto {

    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long formaDePagamentoId;
    private Long pedidoId;

}
