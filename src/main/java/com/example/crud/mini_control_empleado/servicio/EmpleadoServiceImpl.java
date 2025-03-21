package com.example.crud.mini_control_empleado.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Para inyección de dependencias
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.mini_control_empleado.dto.EmpleadoDto;
import com.example.crud.mini_control_empleado.dto.GeneryDto;
import com.example.crud.mini_control_empleado.entities.Empleados;
import com.example.crud.mini_control_empleado.repositorios.EmpleadoRepository;

@Service // Marca la clase como un servicio de Spring
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired // Inyección del repositorio
    private EmpleadoRepository empleadoRepository;

    /**
     * Obtiene una lista de todos los empleados.
     * 
     * @return Lista de empleados.
     */
    @Override
    @Transactional(readOnly = true)
    public GeneryDto<List<Empleados>> findALL() {
        GeneryDto<List<Empleados>> empleados = new GeneryDto<List<Empleados>>();
        empleados.setMessage("Empleados encontrados");
        empleados.setData(empleadoRepository.findAll());
        return empleados;
    }

    /**
     * Obtiene una lista paginada de empleados.
     * 
     * @param pageable Objeto de paginación.
     * @return Página de empleados.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Empleados> findALL(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    /**
     * Guarda o actualiza un empleado en la base de datos.
     * 
     * @param empleados Objeto empleado a guardar.
     */
    @Override
    @Transactional
    public GeneryDto<EmpleadoDto> save(Empleados empleados) {
        Empleados savEmpleados = empleadoRepository.save(empleados);
        GeneryDto<EmpleadoDto> dto = new GeneryDto<EmpleadoDto>();
        dto.setMessage("Empleado Guardado");

        dto.setData(
                new EmpleadoDto(
                        savEmpleados.getIde(),
                        savEmpleados.getNombres(),
                        savEmpleados.getApellidos(),
                        savEmpleados.getEmail(),
                        savEmpleados.getPais(),
                        savEmpleados.getTelefono()));
        return dto;
    }

    /**
     * Busca un empleado por su ID.
     * 
     * @param ide ID del empleado.
     * @return El empleado encontrado o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Empleados findOne(Long ide) {
        return empleadoRepository.findById(ide).orElse(null); // Se corrigió la implementación
    }

    /**
     * Elimina un empleado de la base de datos por su ID.
     * 
     * @param ide ID del empleado a eliminar.
     */
    @Override
    @Transactional
    public GeneryDto<Long> delete(Long ide) {
        empleadoRepository.deleteById(ide); // Se corrigió, no necesita `return`
        GeneryDto<Long> dto = new GeneryDto<Long>();
        dto.setMessage("Empleado Eliminado");
        dto.setData(ide);
        return dto;
    }

    @Override
    @Transactional
    public Empleados updatEmpleados(Long ide) {
        Empleados empleados = empleadoRepository.findById(ide).orElse(null);
        return empleados;
    }
}
