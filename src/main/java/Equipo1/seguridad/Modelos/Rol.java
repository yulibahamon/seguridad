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

    public Rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getId_rol() {
        return id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
}