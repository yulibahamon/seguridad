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
        Rol RolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        return RolActual;
    }

    @PutMapping("{id}")
    public Rol update(@PathVariable String id, @RequestBody Rol
            infoRol) {
        Rol RolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        if (RolActual != null) {
            RolActual.setNombre_rol(infoRol.getNombre_rol());
            RolActual.setId_rol(convertirSHA256(infoRol.getId_rol()));
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

    public String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}