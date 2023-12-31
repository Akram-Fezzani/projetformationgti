package com.example.EcreditFormation.controller;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
import org.springframework.http.HttpStatus;

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

	@GetMapping("/generateReport/{id}")
	public ResponseEntity<Void> downloadJasper(@PathVariable Long id)
	        throws FileNotFoundException, SQLException, JRException {
	    creditService.generateJasper(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	


	

}
