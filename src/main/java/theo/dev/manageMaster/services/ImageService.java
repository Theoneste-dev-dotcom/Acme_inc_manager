package theo.dev.manageMaster.services;

import io.jsonwebtoken.io.IOException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import theo.dev.manageMaster.dtos.ImageData;
import theo.dev.manageMaster.entities.AppUser;
import theo.dev.manageMaster.repository.ImageRepository;
import theo.dev.manageMaster.repository.UserRepository;

import java.io.File;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    UserService userService;


    @Value("${app.image.upload-dir}")
    private String uploadDir;

    @PostConstruct
    public void init() {
        // Create directory if it doesn't exist
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }



    public String saveOrUpdateImage(Integer ownerId, MultipartFile imageFile) throws IOException {
        // Find existing image data by owner ID
        ImageData existingImage = imageRepository.findByOwnerId(ownerId);

        // Set up new image filename
        String imageName = ownerId + "_" + System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        File file = new File(uploadDir, imageName);

        if (existingImage != null) {
            // Delete old file if it exists
            File oldFile = new File(uploadDir, existingImage.getImageName());
            if (oldFile.exists()) {
                oldFile.delete();
            }
            // Update database record with new filename
            existingImage.setImageName(imageName);
            imageRepository.save(existingImage);
        } else {
            // Save new image data
            ImageData newImageData = new ImageData();
            newImageData.setOwnerId(ownerId);
            newImageData.setImageName(imageName);
            imageRepository.save(newImageData);
        }

        // Save the file to the filesystem
        try {
            imageFile.transferTo(file);
        } catch (java.io.IOException e) {
            throw new IOException("there is an error",e);
        }

        return "Image saved successfully";
    }


    public File getImageFileByOwnerId(Integer ownerId) {
        ImageData imageData = imageRepository.findByOwnerId(ownerId);
        if (imageData != null) {
            return new File(uploadDir, imageData.getImageName());
        }
        return null;
    }
}
