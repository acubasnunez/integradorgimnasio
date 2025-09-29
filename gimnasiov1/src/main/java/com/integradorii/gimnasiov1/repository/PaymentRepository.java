package com.integradorii.gimnasiov1.repository;


import com.integradorii.gimnasiov1.entity.Payment;
//import com.fitgym.app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Buscar todos los pagos de una membresía ordenados por fecha
    List<Payment> findByMembershipIdOrderByPaidAtDesc(Long membershipId);
}

