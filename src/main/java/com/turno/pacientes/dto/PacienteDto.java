
package com.turno.pacientes.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor

public class PacienteDto implements Serializable{//inmplementa interfaz serializable para la transferencia de datos(como para convertir o serializar objeto a json y viceversa de json a objeto a la vuelta)
   
    @NotBlank //validacion indica que no puede ser vacio ni nulo
    private String nombre;
    
    @NotBlank 
    private String apellido;
    
    @NotBlank 
    private String genero;
    
    @NotBlank 
    private int edad;
    
    @NotBlank 
    private String telefono;
    
    @NotBlank 
    private String especialista;
    
    @NotBlank 
    private String obraSocial;
    
    @NotBlank 
    private boolean tieneTurno;
    
    @NotBlank 
    private Date turno;
    
}
