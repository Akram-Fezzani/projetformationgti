package com.example.EcreditFormation.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.serviceInterface.ICreditService;
import io.swagger.annotations.ApiOperation;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/Credit")
public class CreditController {

	@Autowired
	ICreditService creditService;

	@PostMapping("/postCredit")
	@ResponseBody
	public Credit addCredit(@RequestBody Credit credit) {
		return creditService.addCredit(credit);
	}

	@PostMapping("updateCredit/{creditID}")
	@ResponseBody
	Credit updateCredit(@RequestBody Credit credit, @PathVariable Long creditID) {
		return creditService.updateCredit(credit, creditID);
	}

	@GetMapping("/getCredit")
	@ResponseBody
	public List<Credit> findAllCredits() {
		return creditService.findAll();
	}

	@DeleteMapping("/delete/{creditID}")
	public void deleteCreditById(@PathVariable Long creditID) {
		creditService.deleteCreditById(creditID);

	}

	@ApiOperation(value = "retrieveCredit")
	@GetMapping("/{id}")
	public ResponseEntity<Credit> getClientById(@PathVariable Long id) {
		Optional<Credit> compte = creditService.getCreditById(id);

		return compte.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@CrossOrigin
	@PostMapping("confirmeCredit/{creditID}")
	@ResponseBody
	public ResponseEntity<Credit> confirmeCredit(@PathVariable Long creditID) {
		Credit credit = creditService.confirmeCredit(creditID);
		return new ResponseEntity<>(credit, HttpStatus.OK);

	}

	/*@GetMapping("/generate")
	public void generateReport(HttpServletResponse response) throws IOException {
		// Load your JasperReport (you can load it from a file, classpath, database,
		// etc.)
		JasperReport jasperReport = loadJasperReport(); // This method needs to be implemented

		// Set parameters for the report
		Map<String, Object> params = new HashMap<>();
		// Add parameters if needed

		// Generate and return the report
		creditService.generateReport(jasperReport, params, response);
	}

	// Example method to load JasperReport from a file in the classpath
	private JasperReport loadJasperReport() {
		try (InputStream inputStream = getClass()
				.getResourceAsStream("C:\\Users\\FEZZANI.Akrem\\JaspersoftWorkspace\\MyReports\\formation.jrxml")) {
			return JasperCompileManager.compileReport(inputStream);
		} catch (Exception e) {
			throw new RuntimeException("Error loading JasperReport", e);
		}
	}*/
	@GetMapping("/generateReport/{id}")
	public ResponseEntity<Void> downloadJasper(@PathVariable Long id)
	        throws FileNotFoundException, SQLException, JRException {
	    creditService.generateJasper(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	


	

}
