package com.integradorii.gimnasiov1.controller;

import com.integradorii.gimnasiov1.entity.Payment;
import com.integradorii.gimnasiov1.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/deportista/{membershipId}/historial")
    public String historialPagos(@PathVariable Long membershipId, Model model) {
        List<Payment> historialPagos = paymentService.getPaymentsByMembership(membershipId);

        model.addAttribute("historialPagos", historialPagos);
        // Para pestaña de suscripciones (puedes derivarlas de payments o de Membership)
        model.addAttribute("suscripciones", historialPagos);

        //return "employees"; // plantilla thymeleaf que te generé antes
        return "paymenthistory";
    }
}

