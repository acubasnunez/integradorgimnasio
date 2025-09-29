package com.integradorii.gimnasiov1.service;

import com.integradorii.gimnasiov1.entity.Payment;
import com.integradorii.gimnasiov1.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public List<Payment> getPaymentsByMembership(Long membershipId) {
        return paymentRepository.findByMembershipIdOrderByPaidAtDesc(membershipId);
    }
}
