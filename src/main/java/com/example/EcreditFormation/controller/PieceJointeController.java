package com.example.EcreditFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.EcreditFormation.models.PieceJointe;
import com.example.EcreditFormation.serviceInterface.IPieceJointeService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/PieceJointe")
public class PieceJointeController {

	

	@Autowired
	IPieceJointeService pieceJointeService;
	
	
    @PostMapping("/postPieceJointe")
	@ResponseBody
	public PieceJointe addPieceJointe(@RequestBody PieceJointe pieceJointe) {
	        return pieceJointeService.addPieceJointe(pieceJointe);
	    }
    

	
	@PostMapping("updatePieceJointe/{pieceJointeID}")
	@ResponseBody
	PieceJointe updatePieceJointe(@RequestBody PieceJointe pieceJointe,@PathVariable Long pieceJointeID){
		return pieceJointeService.updatePieceJointe(pieceJointe, pieceJointeID);
	}
	
	/*@PostMapping("updateGarantie/{garantieID}")
	@ResponseBody
	Garantie updateGarantie(@RequestBody Garantie pieceJointe,@PathVariable Long pieceJointeID){
		return pieceJointeService.updatePieceJointe(pieceJointe, pieceJointeID);
	}*/
    
    @GetMapping("/getPieceJointes")
    @ResponseBody
    public List<PieceJointe> findAllPieceJointes() {
        return pieceJointeService.findAll();
    }
    

    @DeleteMapping("/delete/{pieceJointeID}")
    public void deleteGarantieById(@PathVariable Long pieceJointeID) {
    	pieceJointeService.deletePieceJointeById(pieceJointeID);
    
    }
    

    
    @ApiOperation(value = "retrievePieceJointe")
    @GetMapping("/{id}")
    public ResponseEntity<PieceJointe> getGarantieById(@PathVariable Long id) {
        Optional<PieceJointe> compte = pieceJointeService.getPieceJointeById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    	PieceJointe pieceJoint = new PieceJointe();
    	try {
            String uploadDir = "C:\\Users\\FEZZANI.Akrem\\Desktop\\EcreditFormation\\EcreditFormation\\src\\main\\java\\com\\example\\EcreditFormation\\files";

            // Create the directory if it doesn't exist
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file to the specified directory
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);
            pieceJoint.setFileName(file.getOriginalFilename());
            pieceJoint.setFileSize(file.getSize());
	        pieceJointeService.addPieceJointe(pieceJoint);
	       // Path path= uploadDir;
	        pieceJoint.setFilePath(uploadDir);
            return "File uploaded successfully!";
        } catch (Exception e) {
            return "File upload failed: " + e.getMessage();
        }
    }
    
    @GetMapping("/files/{fileName}")
    public ResponseEntity<InputStreamResource> getFile(@PathVariable String fileName) {
        try {
            String uploadDir = "C:\\Users\\FEZZANI.Akrem\\Desktop\\EcreditFormation\\EcreditFormation\\src\\main\\java\\com\\example\\EcreditFormation\\files\\";

            // Construct the file path based on the uploaded directory and the requested file name
            Path filePath = Paths.get(uploadDir, fileName);
            File file = filePath.toFile();

            // Check if the file exists
            if (file.exists()) {
                // Create an InputStreamResource from the file
                InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

                // Set the response headers
                HttpHeaders headers = new HttpHeaders();
                headers.setContentLength(file.length());
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", fileName);

                // Return the file as a ResponseEntity
                return new ResponseEntity<>(resource, headers, HttpStatus.OK);
            } else {
                // Return 404 Not Found if the file does not exist
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            // Handle file-related exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Handle other exceptions
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
