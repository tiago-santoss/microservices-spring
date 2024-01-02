package br.com.spring.microservices.controller;

import br.com.spring.microservices.dto.PaymentDto;
import br.com.spring.microservices.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private PaymentService service;

    @GetMapping
    public ResponseEntity<Page<PaymentDto>> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentDto> createPayment(@RequestBody @Valid PaymentDto inputDto, UriComponentsBuilder builder) {
        PaymentDto payment = service.createPayment(inputDto);
        URI uri = builder.path("/payment/{id}").buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(uri).body(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable @NotNull Long id, @RequestBody PaymentDto inputDto) {
        return ResponseEntity.ok(service.updatePayment(id, inputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable @NotNull Long id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
