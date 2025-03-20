package com.example.crud.mini_control_empleado.repositorios;

import com.example.crud.mini_control_empleado.entities.Empleados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ✅ @Repository → Indica que esta clase es un componente de acceso a datos.
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Long> {

}
