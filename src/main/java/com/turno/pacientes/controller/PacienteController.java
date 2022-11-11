package com.turno.pacientes.controller;

import com.turno.pacientes.dto.PacienteDto;
import com.turno.pacientes.entity.Paciente;
import com.turno.pacientes.service.pacienteService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    private pacienteService pacienteserv; //el controlador solo inyecta el servicio
    //trae todos los registros de la bbdd

    @GetMapping("/vertodos")
    public ResponseEntity<List<Paciente>> list() {
        List<Paciente> pacientes = pacienteserv.list();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);//respuesta ante accion, en este caso ,mostrar lista paciente y el estado http respuestas satisfactorias (200-299)
    }

    //traer paciente por id
    @GetMapping("/ver/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") int id) {
        if (!pacienteserv.existById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        Paciente paciente = pacienteserv.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    //borar paciente
    @DeleteMapping("/borrar{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!pacienteserv.existById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        pacienteserv.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //crear paciente
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody PacienteDto dtopaciente) {  //uso dto para llevar y traer datos a traves de la api
        if (StringUtils.isBlank(dtopaciente.getNombre())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else if (pacienteserv.existByNombre(dtopaciente.getNombre())) { //si ya existe mando el bad request para que no hayann 2 con el mismo nombre
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Paciente paciente = new Paciente(dtopaciente.getNombre(),
                dtopaciente.getApellido(), dtopaciente.getGenero(),
                dtopaciente.getEdad(), dtopaciente.getTelefono(),
                dtopaciente.getEspecialista(),
                dtopaciente.getObraSocial(), dtopaciente.isTieneTurno(),
                dtopaciente.getTurno());
        pacienteserv.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //editar paciente
    @PutMapping("/editar{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PacienteDto dtopaciente) { //para editar un registro que ya esta en nndd lo identifico con id y le paso la nueva info por dto
        if (!pacienteserv.existById(id)) { //si no existe por id
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (StringUtils.isBlank(dtopaciente.getNombre())) {  //si el nombre del paciente esta vacio
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } //si obtengo el nombre del paciente pero el id no coincide, hago bad request
        else if (pacienteserv.existByNombre(dtopaciente.getNombre()) && pacienteserv.getByNombre(dtopaciente.getNombre()).get().getId() != id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Paciente paciente = pacienteserv.getById(id).get();
        paciente.setNombre(dtopaciente.getNombre());
        paciente.setApellido(dtopaciente.getApellido());
        paciente.setGenero(dtopaciente.getGenero());
        paciente.setEdad(dtopaciente.getEdad());
        paciente.setTelefono(dtopaciente.getTelefono());
        paciente.setEspecialista(dtopaciente.getEspecialista());
        paciente.setObraSocial(dtopaciente.getObraSocial());
        paciente.setTieneTurno(dtopaciente.isTieneTurno());
        paciente.setTurno(dtopaciente.getTurno());
        pacienteserv.save(paciente);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
