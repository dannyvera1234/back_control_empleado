package com.example.crud.mini_control_empleado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.mini_control_empleado.entities.Empleados;
import com.example.crud.mini_control_empleado.servicio.EmpleadoService;

@RestController
@RequestMapping("/api/v1/empledos")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleados> getEmpleado() {
        return empleadoService.findALL();
    }

    @PostMapping
    public String saveEmpleado(@RequestBody Empleados empleados) {
        return empleadoService.save(empleados);

    }

    @DeleteMapping
    public void deleteEmpleado(Long ide) {
        empleadoService.delete(ide);
    }

    @PutMapping
    public Empleados updateEmpleados(Long ide) {
        return empleadoService.updatEmpleados(ide);

    }
}
