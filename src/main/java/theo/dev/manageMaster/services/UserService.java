package theo.dev.manageMaster.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import theo.dev.manageMaster.entities.AppUser;
import theo.dev.manageMaster.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public AppUser updateProfile(AppUser appUser, MultipartFile image) throws IOException {
        appUser.setImageName(image.getOriginalFilename());
        appUser.setImageType(image.getContentType());
        appUser.setImageData(image.getBytes());
        return userRepository.save(appUser);
    }

    public AppUser getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public AppUser getById(Integer id) {
        Optional<AppUser> appUser = userRepository.findById(id);
        if (appUser.isPresent()) {
            return appUser.get();
        } else {
            return null;
        }
    }
}