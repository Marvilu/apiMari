package com.turno.pacientes.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor //lombok para ahorrar insertar codigo de constructor sin argumentos
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre") // o @Data(pero no puedo evitar q se genere id con data) esto genera las tablas en base de datos 
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private int edad;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "especialista")
    private String especialista;

    @Column(name = "obraSocial")
    private String obraSocial;

    @Column(name = "tieneTurno")
    private boolean tieneTurno;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "turno")
    private Date turno;

    public Paciente(String nombre, String apellido, String genero, int edad, String telefono, String especialista, String obraSocial, boolean tieneTurno, Date turno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.telefono = telefono;
        this.especialista = especialista;
        this.obraSocial = obraSocial;
        this.tieneTurno = tieneTurno;
        this.turno = turno;
    }

}
