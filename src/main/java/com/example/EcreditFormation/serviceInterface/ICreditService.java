package com.example.EcreditFormation.serviceInterface;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.example.EcreditFormation.models.Credit;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;


public interface ICreditService {

	
	List<Credit> findAll();

	Credit addCredit(Credit credit);
	
	Credit updateCredit(Credit credit, Long CreditID);

	void deleteCreditById(Long CreditID);
	
	
	Optional<Credit> getCreditById(Long CreditID);
	
	Credit confirmeCredit(Long creditID);
	
	void generateReport(JasperReport jasperReport, Map<String, Object> params, HttpServletResponse response);
	
	 void downloadJasper(Long creditID) throws FileNotFoundException, SQLException, JRException;
	 public void generateJasper(Long creditID) throws FileNotFoundException, SQLException, JRException ;
	}