package com.integradorii.gimnasiov1.controller;

import com.integradorii.gimnasiov1.entity.Employee;
import com.integradorii.gimnasiov1.repository.EmployeeRepository;
import com.integradorii.gimnasiov1.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    @GetMapping("mostrar")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "employees"; // nombre del HTML
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/admin/employees";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        /*employeeRepository.save(employee);
        return "redirect:/admin/employees";*/
        Employee existing = employeeRepository.findById(employee.getIdemployee())
                .orElseThrow();
        // Actualizar campos básicos
        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());
        existing.setPhone(employee.getPhone());
        existing.setRole(employee.getRole());
        existing.setActive(employee.isActive());
        // ✅ Manejo de la contraseña
        if (employee.getPasswordHash() != null && !employee.getPasswordHash().isEmpty()) {
            // Aquí deberías cifrar la contraseña con BCrypt antes de guardarla
            existing.setPasswordHash(employee.getPasswordHash());
        }
        employeeRepository.save(existing);
        return "redirect:/admin/employees";
    }

    @PostMapping("/toggle/{id}")
    public String toggleActive(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setActive(!employee.isActive());
        employeeRepository.save(employee);
        return "redirect:/admin/employees";
    }
}

