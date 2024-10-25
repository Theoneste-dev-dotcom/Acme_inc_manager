package theo.dev.manageMaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theo.dev.manageMaster.entities.TenantsUser;
import theo.dev.manageMaster.repository.TenantsUsersRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TenantsUserService {
    @Autowired
    private TenantsUsersRepository tenantsUsersRepository;

    public TenantsUser findById(Integer id) {
        return tenantsUsersRepository.findById(id).orElse(null);
    }

    public String deleteUser(Integer id) {
        tenantsUsersRepository.deleteById(id);
        return "User deleted successfully";
    }
    public String updateUser(Integer id, TenantsUser tenantsUser) {
       Optional<TenantsUser> oldUser =  tenantsUsersRepository.findById(id);
       if(oldUser.isPresent()) {
           tenantsUsersRepository.save(tenantsUser);
           return "user updated successfully";
       }else {
           return "failed to get user with that id";
       }

    }

    public List<TenantsUser> findByOwnerId(Long ownerId) {
        return tenantsUsersRepository.findByOwnerId(ownerId);
    }

    public List<TenantsUser> findByRole( String role) {
        return tenantsUsersRepository.findByRole(role);
    }
 public List<TenantsUser> findByPermissions(String perm) {
        return tenantsUsersRepository.findByPermissions(perm);
    }

    public TenantsUser findByEmail(String email) {
        return tenantsUsersRepository.findByEmail(email);
    }


    public TenantsUser addNewOne(TenantsUser user) {
        return tenantsUsersRepository.save(user);
    }

    public List<TenantsUser> getAllUsers() {
        List<TenantsUser> users = new ArrayList<>();
        tenantsUsersRepository.findAll().forEach(users::add);
        return users;
    }
}