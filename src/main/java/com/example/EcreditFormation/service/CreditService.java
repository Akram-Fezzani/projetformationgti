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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
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
	
	@Transactional
	@Override
	public Credit addCredit(Credit credit) {
	 try {
			credit.setStatus(false);
			LocalDate localDate = LocalDate.now();
			Date date = java.sql.Date.valueOf(localDate);
			credit.setDateDemande(date);
			credit.setDisplay("En cours");
			return creditRepository.save(credit);	
		}
	 catch (Exception e) {
		 throw new ResourceNotFoundException(" error posting this credit" );
		} 
	}
	
	@Transactional
	@Override
	public Credit updateCredit(Credit credit, Long creditID) {
		 try {
			 credit.setId(creditID);
			 return creditRepository.save(credit);			
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" credit not found with id = " + creditID);
			} 
	}
	

	
	@Transactional
	@Override
	public void deleteCreditById(Long creditID) {
		 try {
			 	creditRepository.deleteById(creditID);
			}
			 	 catch (Exception e) {
					 throw new ResourceNotFoundException(" credit not found with id = " + creditID);
			} 
	}
	
	@Override
	   public Optional<Credit> getCreditById(Long creditID) {   
	   	 try {
		        return creditRepository.findById(creditID);
			}
			 	 catch (Exception e) {
				 throw new ResourceNotFoundException(" credit not found with id = " + creditID);
			} 
	}
	
	
	@Transactional
	@Override
	public Credit confirmeCredit(Long creditID) {
	 	 try {
	 		Credit credit=creditRepository.findById(creditID).orElse(null);
			credit.setStatus(true);
			credit.setDisplay("Accepté");
			return creditRepository.save(credit);			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" credit not found with id = " + creditID);
			} 
	}
	@Override
	public void generateReport(JasperReport jasperReport, Map<String, Object> params, HttpServletResponse response) {
	    try {
	        String spec = (String) params.get("spec");

	        if (spec != null) {
	            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");

	            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	        } else {
	            System.out.println("'spec' is null");
	        }
	    } catch (IOException | JRException e) {
			 throw new ResourceNotFoundException(" report couldn't be generated " );
	    }
	}
	
	
	@Override
	public void downloadJasper(Long creditID) throws FileNotFoundException, SQLException, JRException {
	  try {  	Connection con = dataSource.getConnection();
	  
			    final InputStream stream = this.getClass().getResourceAsStream("/formation.jrxml");
		
			    final JasperReport report = JasperCompileManager.compileReport(stream);
			    Map<String, Object> parameters = new HashMap<>();
			    parameters.put("id", creditID);
			    final JasperPrint print = JasperFillManager.fillReport(report, parameters, con);
		
			    String path = "C:\\Users\\FEZZANI.Akrem\\Desktop\\EcreditFormation";
			    String fileName = path + "-" + creditID + ".pdf";
			    
			    JasperExportManager.exportReportToPdfFile(print, fileName);
	    } catch (Exception e) {
			 throw new ResourceNotFoundException(" credit not found with id = " + creditID);
	    }
	    
	}
	
	public void generateJasper(Long creditID) throws FileNotFoundException, SQLException, JRException {
	    Connection con = dataSource.getConnection();
	    final InputStream stream = this.getClass().getResourceAsStream("/formation.jrxml");

	    final JasperReport report = JasperCompileManager.compileReport(stream);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("id", creditID);
	    final JasperPrint print = JasperFillManager.fillReport(report, parameters, con);

	    byte[] pdfBytes = JasperExportManager.exportReportToPdf(print);

	    String filePath = "C:\\Users\\FEZZANI.Akrem\\Desktop\\EcreditFormation\\report-" + creditID + ".pdf";

	    try (FileOutputStream fos = new FileOutputStream(filePath)) {
	        fos.write(pdfBytes);
	    } catch (IOException e) {
			 throw new ResourceNotFoundException(" credit not found with id = " + creditID);
	    }
	}

}


