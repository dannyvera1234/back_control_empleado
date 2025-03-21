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
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Los nombres no pueden estar vacios")
    private String nombres;
    @NotBlank(message = "Los apellidos no pueden estar vacios")
    private String apellidos;
    @NotBlank(message = "El email no puede estar vacio")
    @Email
    private String email;
    @NotBlank(message = "El sexo no puede estar vacio")
    private String sexo;
    @NotBlank(message = "El pais no puede estar vacio")
    private String pais;

    @NotBlank(message = "El telefono no puede estar vacio")
    private String telefono;
    @NotBlank(message = "El salario no puede estar vacio")
    private double salerio;
    @NotBlank(message = "La direccion no puede estar vacia")
    private String dirreccion;

    @NotBlank(message = "La fecha no puede estar vacia")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

}
