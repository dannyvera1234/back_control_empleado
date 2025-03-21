package com.example.crud.mini_control_empleado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoDto {
    private Long ide;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String pais;

}
