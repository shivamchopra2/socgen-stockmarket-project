package com.example.StockCharting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StockCharting.Entity.Company;
import com.example.StockCharting.Entity.Companystockexchangemap;
import com.example.StockCharting.Entity.StockExchange;
import com.example.StockCharting.Repository.Companyrepository;
import com.example.StockCharting.Repository.Companystockexchangemaprepository;
import com.example.StockCharting.Repository.StockExchangeRepository;

@RestController
@CrossOrigin("http:localhost:4200")

public class CompanystockexchangeController {
@Autowired 
Companystockexchangemaprepository compstkmaprepo;
@Autowired
Companyrepository cmprepo;
@Autowired
StockExchangeRepository stkrepo;
@PostMapping(path="/mapcompanycode")
public Companystockexchangemap mapcode(@RequestBody Companystockexchangemap cmpstkmap) {
	
	Company company=cmprepo.findByName(cmpstkmap.getCompanyname());
	StockExchange stkexchg=stkrepo.findByName(cmpstkmap.getStockexchangename());
	Companystockexchangemap csemap=new Companystockexchangemap();
	csemap.setCompanycode(cmpstkmap.getCompanycode());
	csemap.setCompanyname(cmpstkmap.getCompanyname());
	csemap.setStockexchangename(cmpstkmap.getStockexchangename());
	csemap.setStockexchange(stkexchg);
	csemap.setCompany(company);
	csemap=compstkmaprepo.save(csemap);
	return csemap;
}
}
