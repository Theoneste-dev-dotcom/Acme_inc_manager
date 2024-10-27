package theo.dev.manageMaster.controller;

import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import theo.dev.manageMaster.dtos.ImageData;
import theo.dev.manageMaster.entities.AppUser;
import theo.dev.manageMaster.services.ImageService;

import java.io.File;

@RestController
@RequestMapping("/image")

public class ImageController {
    @Autowired
    ImageService imageService;
    @PutMapping("/{id}/add")
    public String addImage(@PathVariable Integer id, @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            return imageService.saveOrUpdateImage(id, imageFile);
        } catch (IOException e) {
            throw new RuntimeException(" an error occured",e);
        }


    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Integer id) {
        File imageFile = imageService.getImageFileByOwnerId(id);
        if (imageFile != null && imageFile.exists()) {
            Resource fileResource = new FileSystemResource(imageFile);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(fileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
