
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

public class pacienteService {
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
        return pacienterepo.existById(id);
    }
     public boolean existByNombre(String nombre){
         return pacienterepo.existByNombre(nombre);
     }
     public boolean existByEspecialista(String especialista){
         return pacienterepo.existByNombre(especialista);
     }
    
    
    
}
