package com.softToken.controller;


import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.softToken.dto.CategoriesDo;
import com.softToken.service.FlexCube;
import com.softToken.service.SoftTokenService;

@RestController
@RequestMapping("/soft")
public class SoftTokenController {

	private static final Logger LOG = LogManager.getLogger(SoftTokenController.class);

	@Autowired
	SoftTokenService softTokenService;

	@Autowired
	FlexCube flexcube;

	@Autowired
	private Environment env;

	 @GetMapping("/{key}")
	 public int getToken(@PathVariable String key) throws InvalidKeyException,
	 NoSuchAlgorithmException {
	
	 //return softTokenService.getOtp(key);
	 System.out.println("inside controller for test catrgory");
	 return 1;
	
	 }
	
	
	
	
	@GetMapping("/category/{key}")
	public CategoriesDo getCategoryName(@PathVariable int key) {

		String testProp = env.getProperty("loan.amortization.disburseCheckDate");
		System.out.println(testProp);

		LOG.debug("inside controller for get catrgory");
		return softTokenService.getCategoryName(key);
		// return "qw"+key;
	}

	@GetMapping("/callRemote")
	public JSONObject callFlexcube() {

		LOG.debug("Calling FCDB Service");

		JSONObject object = flexcube.callRemoteService();

		return object;

	}

	@GetMapping("/downloadPdf")
	public void downloadPdf(HttpServletResponse response) throws SAXException, IOException, TransformerException {

		LOG.debug("Download PDF  FCDB Service");

		DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
		// the XSL FO file
		File xsltFile = new File("src/main/resources/AloanAmortization.xsl");
		File configFile = new File("src/main/resources/fop_config.xml");

		StreamSource xmlSource = new StreamSource(new StringReader(flexcube.getXML()));
		//StreamSource xmlSource = new StreamSource(new File("src/main/resources/Employees.xml"));

		// create an instance of fop factory
		FopFactory fopFactory = FopFactory.newInstance();

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + "123" + "\".pdf");

		ServletOutputStream out = null;
		
		out=response.getOutputStream();
		

		
			
			fopFactory.setUserConfig(configFile);
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			// Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

			// Setup XSLT
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

			// Resulting SAX events (the generated FO) must be piped through to
			// FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			// That's where the XML is first transformed to XSL-FO and then
			// PDF is created
			transformer.transform(xmlSource, res);
		

	}

}
