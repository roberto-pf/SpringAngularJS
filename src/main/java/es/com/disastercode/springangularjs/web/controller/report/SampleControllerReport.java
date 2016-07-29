package es.com.disastercode.springangularjs.web.controller.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.com.disastercode.springangularjs.business.entity.CityEntity;
import es.com.disastercode.springangularjs.business.service.CityService;
import es.com.disastercode.springangularjs.utils.CustomJRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class SampleControllerReport {

	@Autowired
	private CityService cityService;
	
	
    //@Secured({ "ROLE_demo" })
    @RequestMapping(value="reportSample", method = RequestMethod.GET)
    public void generateReport(HttpServletResponse response, HttpServletRequest request) throws JRException, IOException {
		this.generateReportCity(response,request);
	}
    
    
    
	private void generateReportCity(HttpServletResponse response, HttpServletRequest request) throws JRException, IOException {
	    //InputStream jasperStream = this.getClass().getResourceAsStream("static/jasper/report.jasper");
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(
	    		request.getServletContext().getRealPath("/") + "jasper/report.jasper");
		
	    /*compile jrxml
		JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/static/reports/report.jrxml");
		*/
		
		CustomJRDataSource<CityEntity> dataSource = new CustomJRDataSource<CityEntity>()
				.initBy( cityService.findItems() );
		Map<String,Object> params = new HashMap<>();
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		//JasperExportManager.exportReportToPdfFile(jasperPrint,"src/main/resources/static/jasper/report.pdf");
		
		
	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
}
