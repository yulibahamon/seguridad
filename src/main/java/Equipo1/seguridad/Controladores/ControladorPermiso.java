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
    public List<Permiso> index() {
        return this.miRepositorioPermiso.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permiso create(@RequestBody Permiso infoPermiso) {
        return this.miRepositorioPermiso.save(infoPermiso);
    }

    @GetMapping("{id}")
    public Permiso show(@PathVariable String id) {
        Permiso PermisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        return PermisoActual;
    }

    @PutMapping("{id}")
    public Permiso update(@PathVariable String id, @RequestBody Permiso
            infoPermiso) {
        Permiso PermisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if (PermisoActual != null) {
            PermisoActual.setUrl_permiso(infoPermiso.getUrl_permiso());
            PermisoActual.setMetodo(infoPermiso.getMetodo());
            return this.miRepositorioPermiso.save(PermisoActual);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Permiso PermisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if (PermisoActual != null) {
            this.miRepositorioPermiso.delete(PermisoActual);
        }
    }
}
