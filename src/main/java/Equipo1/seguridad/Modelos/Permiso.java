package Equipo1.seguridad.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Permiso {
    @Id
    private String id_permiso;
    private String url_permiso;
    private String metodo;

    public Permiso(String url_permiso, String metodo) {
        this.url_permiso = url_permiso;
        this.metodo = metodo;
    }

    public String getId_permiso() {
        return id_permiso;
    }

    public String getUrl_permiso() {
        return url_permiso;
    }

    public void setUrl_permiso(String url_permiso) {
        this.url_permiso = url_permiso;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}
