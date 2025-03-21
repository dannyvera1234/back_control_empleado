package com.example.crud.mini_control_empleado.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.mini_control_empleado.dto.EmpleadoDto;
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
    public GeneryDto<EmpleadoDto> saveEmpleado(@RequestBody Empleados empleados) {
        System.out.println(empleados);
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

    @PostMapping("/detailsEmpleado")
    public Empleados findOne(@RequestBody Map<String, Long> request) {
        Long ide = request.get("ide"); // Extraer el ID del body
        System.out.println("ID recibido: " + ide);
        return empleadoService.findOne(ide);
    }

}
