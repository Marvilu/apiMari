
package com.turno.pacientes.service;

import com.turno.pacientes.entity.Paciente;
import com.turno.pacientes.repository.IPacienteRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class PacienteService {
    @Autowired
    IPacienteRepository pacienterepo;
    
    //create
    public void save (Paciente paciente){
        pacienterepo.save(paciente);
    }
    //read
    public List<Paciente> list(){
        return pacienterepo.findAll();
    }
     public Optional <Paciente> getById(int id){
        return pacienterepo.findById(id);
    }
    public Optional <Paciente> getByNombre(String nombre){
        return pacienterepo.findByNombre(nombre);
    }
    public Optional <Paciente> getByEspecialista(String especialista){
         return pacienterepo.findByEspecialista(especialista);
    }
    //delete
    public void delete(int id){
        pacienterepo.deleteById(id);
    }
    public boolean existById(int id){
        return pacienterepo.existsById(id);
    }
     public boolean existsByNombre(String nombre){
         return pacienterepo.existsByNombre(nombre);
     }
     public boolean existsByEspecialista(String especialista){
         return pacienterepo.existsByNombre(especialista);
     }
    
    
    
}
