package com.example.crud.mini_control_empleado.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "empleados")
@NoArgsConstructor
@AllArgsConstructor
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ide;

    // @NotEmpty
    // 📌 Valida que el campo no sea null ni esté vacío ("" o una lista vacía).
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String sexo;
    @NotEmpty
    private String pais;
    // @NotNull
    // 📌 Evita valores null, pero permite valores vacíos ("" en String).
    @NotNull
    private String telefono;
    @NotNull
    private double salerio;
    // @Temporal(TemporalType.DATE)
    // 📌 Indica que el campo fecha se almacenará solo con la parte de la fecha
    // (yyyy-MM-dd).
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // 📌 Define el formato de fecha esperado al recibir datos en un request.
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

}
