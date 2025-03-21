package com.example.crud.mini_control_empleado.servicio;

import java.util.List;

import org.springframework.data.domain.Page; // Import correcto para manejar paginación
import org.springframework.data.domain.Pageable; // Import correcto para la paginación

import com.example.crud.mini_control_empleado.dto.GeneryDto;
import com.example.crud.mini_control_empleado.entities.Empleados;

// Definimos la interfaz del servicio que gestionará los empleados
public interface EmpleadoService {

    /**
     * Obtiene una lista de todos los empleados sin paginación.
     * 
     * @return Lista de empleados.
     */
    public GeneryDto<List<Empleados>> findALL();

    /**
     * Obtiene una lista paginada de empleados.
     * Se utiliza para manejar grandes volúmenes de datos de manera eficiente.
     * 
     * @param pageable Parámetro para definir la paginación.
     * @return Página de empleados con el tamaño y número de página especificados.
     */
    public Page<Empleados> findALL(Pageable pageable);

    /**
     * Guarda un nuevo empleado o actualiza uno existente en la base de datos.
     * 
     * @param empleados Objeto que representa el empleado a guardar.
     */
    public GeneryDto<Empleados> save(Empleados empleados);

    /**
     * Busca un empleado por su ID.
     * 
     * @param ide ID del empleado.
     * @return El empleado encontrado o null si no existe.
     */
    public Empleados findOne(Long ide);

    public Empleados updatEmpleados(Long ide);

    /**
     * Elimina un empleado de la base de datos por su ID.
     * 
     * @param ide ID del empleado a eliminar.
     */
    public GeneryDto<Long> delete(Long ide);
}
