package Equipo1.seguridad.Controladores;
import Equipo1.seguridad.Modelos.Permiso;
import Equipo1.seguridad.Repositorios.RepositorioPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@CrossOrigin
@RestController
@RequestMapping("/permisos")
public class ControladorPermiso {
    @Autowired

    private RepositorioPermiso miRepositorioPermiso;
    @GetMapping("")
    public List<Permiso> index(){
        return this.miRepositorioPermiso.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permiso create(@RequestBody Permiso infoPermiso){
        return this.miRepositorioPermiso.save(infoPermiso);
    }
    @GetMapping("{id}")
    public Permiso show(@PathVariable String id){
        Permiso PermisoActual=this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        return PermisoActual;
    }
    @PutMapping("{id}")
    public Permiso update(@PathVariable String id,@RequestBody Permiso
            infoPermiso){
        Permiso PermisoActual=this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if (PermisoActual!=null){
            PermisoActual.setUrl_permiso(infoPermiso.getUrl_permiso());
            PermisoActual.setMetodo(infoPermiso.getMetodo());
            PermisoActual.setId_permiso(convertirSHA256(infoPermiso.getId_permiso()));
            return this.miRepositorioPermiso.save(PermisoActual);
        }else{
            return null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Permiso PermisoActual=this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if (PermisoActual!=null){
            this.miRepositorioPermiso.delete(PermisoActual);
        }
    }
    public String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
