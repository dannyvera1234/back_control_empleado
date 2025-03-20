package com.example.crud.mini_control_empleado.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Para inyección de dependencias
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Empleados> findALL() {
        return (List<Empleados>) empleadoRepository.findAll();
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
    public String save(Empleados empleados) {
        empleadoRepository.save(empleados);
        return "asdasdasda";
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
    public void delete(Long ide) {
        empleadoRepository.deleteById(ide); // Se corrigió, no necesita `return`
    }

    @Override
    @Transactional
    public Empleados updatEmpleados(Long ide) {
        return null;
    }
}
