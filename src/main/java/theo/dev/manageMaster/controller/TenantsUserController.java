package theo.dev.manageMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theo.dev.manageMaster.entities.TenantsUser;
import theo.dev.manageMaster.services.TenantsUserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TenantsUserController {
    @Autowired
    private TenantsUserService tenantsUserService;

    @GetMapping("/{id}")
    public ResponseEntity<TenantsUser> getUserById(@PathVariable Integer id) {
        TenantsUser tenantsUser = tenantsUserService.findById(id);
        if (tenantsUser != null) {
            return ResponseEntity.ok(tenantsUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<TenantsUser>> getUserByOwnerId(@PathVariable long ownerId) {
        List<TenantsUser> users = tenantsUserService.findByOwnerId(ownerId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<TenantsUser>> getUsersByRole(@PathVariable String role) {
        List<TenantsUser> users = tenantsUserService.findByRole(role);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/permissions/{permissions}")
    public ResponseEntity<List<TenantsUser>> getUsersByPermissions(@PathVariable String permissions) {
        List<TenantsUser> users = tenantsUserService.findByPermissions(permissions);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{email}")
    public ResponseEntity<TenantsUser> getByEmail(String email) {
        TenantsUser user = tenantsUserService.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TenantsUser> addNewUser(@RequestBody TenantsUser tenantsUser) {
        TenantsUser user = tenantsUserService.addNewOne(tenantsUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return tenantsUserService.deleteUser(id);
    }
    @GetMapping("/yours/{id}")
    public List<TenantsUser> getYours(@PathVariable long id){
        return tenantsUserService.findByOwnerId(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TenantsUser>> getAllUsers() {
        List<TenantsUser> allUsers = tenantsUserService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}

