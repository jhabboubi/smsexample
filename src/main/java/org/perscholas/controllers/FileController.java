package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

@Controller
@Log
public class FileController {

    final FileService fileService;
    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/uploadform")
    public String uploadForm() {
        return "uploadform";
    }

    @PostMapping("/uploadfile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){

        fileService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename());
        log.warning(uploadDir+ File.separator+file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("filename", "fileupload"+ File.separator+file.getOriginalFilename());
        return "redirect:/uploadform";

    }


}
