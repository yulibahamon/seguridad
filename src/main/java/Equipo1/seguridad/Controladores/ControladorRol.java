package Equipo1.seguridad.Controladores;
import Equipo1.seguridad.Modelos.Rol;
import Equipo1.seguridad.Repositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@CrossOrigin
@RestController
@RequestMapping("/roles")
public class ControladorRol {
    @Autowired
    private RepositorioRol miRepositorioRol;
    @GetMapping("")
    public List<Rol> index() {
        return this.miRepositorioRol.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Rol create(@RequestBody Rol infoRol) {
        return this.miRepositorioRol.save(infoRol);
    }
    @GetMapping("{id}")
    public Rol show(@PathVariable String id) {
        Rol rolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        return rolActual;
    }

    @PutMapping("{id}")
    public Rol update(@PathVariable String id, @RequestBody Rol
            infoRol) {
        Rol RolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        if (RolActual != null) {
            RolActual.setNombre_rol(infoRol.getNombre_rol());
            return this.miRepositorioRol.save(RolActual);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Rol RolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        if (RolActual != null) {
            this.miRepositorioRol.delete(RolActual);
        }
    }
}