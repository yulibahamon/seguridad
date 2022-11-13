package Equipo1.seguridad.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Usuario {
    @Id
    private String id;
    private String cedula;
    private String seudonimo;
    private String correo;
    private String contrasena;
    @DBRef
    private Rol Rol;
    public Usuario(String cedula, String seudonimo, String correo, String contrasena) {
        this.cedula= cedula;
        this.seudonimo = seudonimo;
        this.correo =correo;
        this.contrasena = contrasena;

    }

    public String getId() {return id;}
    public String getCedula() {return cedula;}
    public void setCedula(String cedula) {this.cedula = cedula;}
    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
