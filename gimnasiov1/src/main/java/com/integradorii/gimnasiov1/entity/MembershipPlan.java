package com.integradorii.gimnasiov1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "membershipplans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmembershipplans")
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 30)
    private String code; // Ej: BASIC, PREMIUM, ELITE

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "period_days", nullable = false)
    private Integer periodDays;

    @Column(name = "price_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal priceAmount;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency = "PEN";

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    // Relación con memberships
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membership> memberships = new ArrayList<>();

    // Conveniencia para sincronizar la relación
    public void addMembership(Membership membership) {
        memberships.add(membership);
        membership.setPlan(this);
    }

    public void removeMembership(Membership membership) {
        memberships.remove(membership);
        membership.setPlan(null);
    }
}
