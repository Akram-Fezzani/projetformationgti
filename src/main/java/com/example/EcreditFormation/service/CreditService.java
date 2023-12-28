package com.example.EcreditFormation.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.repository.CreditRepository;
import com.example.EcreditFormation.serviceInterface.ICreditService;


@Service
public class CreditService implements ICreditService {

	
	@Autowired
	CreditRepository creditRepository;
	
	
	@Override
	public List<Credit> findAll() {
		return  creditRepository.findAll();
	}
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public Credit addCredit(Credit credit) {
	credit.setStatus(false);
	LocalDate localDate = LocalDate.now();
	Date date = java.sql.Date.valueOf(localDate);
	credit.setDateDemande(date);
	credit.setDisplay("En cours");
	return creditRepository.save(credit);
	}
	
	@Transactional
	@Override
	public Credit updateCredit(Credit credit, Long creditID) {
		credit.setId(creditID);
		return creditRepository.save(credit);
		
	}
	

	
	
	@Override
	public void deleteCreditById(Long creditID) {
		creditRepository.deleteById(creditID);
	}
	
	@Override
	   public Optional<Credit> getCreditById(Long creditID) {
	        return creditRepository.findById(creditID);
	}
	@Override
	public Credit confirmeCredit(Long creditID) {
		Credit credit=creditRepository.findById(creditID).orElse(null);
		credit.setStatus(true);
		credit.setDisplay("Accepté");
		return creditRepository.save(credit);
	}
	@Override
	public void generateReport(JasperReport jasperReport, Map<String, Object> params, HttpServletResponse response) {
	    try {
	        // Assuming 'spec' is a parameter in the 'params' map
	        String spec = (String) params.get("spec");

	        // Check if 'spec' is null before using it
	        if (spec != null) {
	            // Generate the JasperPrint
	            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

	            // Set response headers
	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");

	            // Export the report to PDF and write it to the response output stream
	            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	        } else {
	            // Handle the case when 'spec' is null
	            System.out.println("'spec' is null");
	        }
	    } catch (IOException | JRException e) {
	        // Handle the exception or log it
	        e.printStackTrace(); // replace with appropriate logging
	    }
	}
	
	
	@Override
	public void downloadJasper(Long creditID) throws FileNotFoundException, SQLException, JRException {
	    Connection con = dataSource.getConnection();
	    final InputStream stream = this.getClass().getResourceAsStream("/formation.jrxml");

	    final JasperReport report = JasperCompileManager.compileReport(stream);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("id", creditID);
	    final JasperPrint print = JasperFillManager.fillReport(report, parameters, con);

	    String path = "C:\\Users\\FEZZANI.Akrem\\Desktop\\EcreditFormation";
	    String fileName = path + "-" + creditID + ".pdf";
	    
	    // Export the report to a PDF file
	    JasperExportManager.exportReportToPdfFile(print, fileName);
	}
	
	public void generateJasper(Long creditID) throws FileNotFoundException, SQLException, JRException {
	    Connection con = dataSource.getConnection();
	    final InputStream stream = this.getClass().getResourceAsStream("/formation.jrxml");

	    final JasperReport report = JasperCompileManager.compileReport(stream);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("id", creditID);
	    final JasperPrint print = JasperFillManager.fillReport(report, parameters, con);

	    // Export the report to a byte array
	    byte[] pdfBytes = JasperExportManager.exportReportToPdf(print);

	    // Specify the file path where you want to save the PDF
	    String filePath = "C:\\Users\\FEZZANI.Akrem\\Desktop\\EcreditFormation\\report-" + creditID + ".pdf";

	    // Save the PDF to the specified file path
	    try (FileOutputStream fos = new FileOutputStream(filePath)) {
	        fos.write(pdfBytes);
	    } catch (IOException e) {
	        // Handle the exception (e.g., log or throw a custom exception)
	        e.printStackTrace();
	    }
	}

}


