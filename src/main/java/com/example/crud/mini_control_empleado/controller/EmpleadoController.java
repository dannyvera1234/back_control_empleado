package com.example.crud.mini_control_empleado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.mini_control_empleado.dto.GeneryDto;
import com.example.crud.mini_control_empleado.entities.Empleados;
import com.example.crud.mini_control_empleado.servicio.EmpleadoService;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public GeneryDto<List<Empleados>> getEmpleado() {
        return empleadoService.findALL();
    }

    @PostMapping
    public GeneryDto<Empleados> saveEmpleado(@RequestBody Empleados empleados) {
        return empleadoService.save(empleados);

    }

    @DeleteMapping("/{ide}")
    public GeneryDto<Long> deleteEmpleado(@PathVariable Long ide) {
        return empleadoService.delete(ide);

    }

    @PutMapping("/{ide}")
    public Empleados updateEmpleados(@PathVariable Long ide) {
        return empleadoService.updatEmpleados(ide);

    }
}
