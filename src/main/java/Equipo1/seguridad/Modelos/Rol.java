package Equipo1.seguridad.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Rol {
    @Id
    private String id_rol;
    private String nombre_rol;
}