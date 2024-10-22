package theo.dev.manageMaster.services;

import org.springframework.stereotype.Service;
import theo.dev.manageMaster.entities.AppUser;
import theo.dev.manageMaster.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AppUser> allUsers() {
        List<AppUser> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}