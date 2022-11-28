package com.turno.pacientes.repository;

import com.turno.pacientes.entity.Paciente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

    public Optional<Paciente> findByNombre(String nombre);//para hacer una busqueda por nombre
//el optional funciona para que si no lo encuentra, devuelva un null  para qe no muera la app

    public boolean existsByNombre(String nombre);

    public Optional<Paciente> findByEspecialista(String especialista);

    public boolean existsByEspecialista(String especialista);

}
