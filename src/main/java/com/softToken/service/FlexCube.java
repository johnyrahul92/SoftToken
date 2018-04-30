package com.softToken.service;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class FlexCube {

	@Value("${olb.url}")
	private String url;

	public JSONObject callRemoteService() {

		RestTemplate restTemplate = new RestTemplate();

		JSONObject jsonObject = new JSONObject();
		JSONParser jsonParser = new JSONParser();
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("fldLoginUserId", "DEVRETAIL4");
		map.add("fldlanguage", "eng");
		map.add("fldDeviceId", "01");
		map.add("fldLangId", "eng");
		map.add("fldRequestId", "RRTFC11");
		map.add("fldUserType", "EN1");
		map.add("fldHiddenTxnId", "TFC");

		try {
			ResponseEntity<String> response = restTemplate.postForEntity(url, map, String.class);
			StreamSource xmlSource = new StreamSource(new StringReader(response.getBody()));

			File xsltFile = new File("src/main/resources/olb-login-username.xsl");
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = factory.newTransformer(new StreamSource(xsltFile));
			StringWriter outWriter = new StringWriter();

			Result res = new StreamResult(outWriter);

			transformer.transform(xmlSource, res);
			StringBuffer sb = outWriter.getBuffer();

			jsonObject = (JSONObject) jsonParser.parse(sb.toString());
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;
	}

	public String getXML() {

		RestTemplate restTemplate = new RestTemplate();

		JSONObject jsonObject = new JSONObject();
		JSONParser jsonParser = new JSONParser();
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("fldLoginUserId", "DEVRETAIL4");
		map.add("fldlanguage", "eng");
		map.add("fldDeviceId", "01");
		map.add("fldLangId", "eng");
		map.add("fldRequestId", "RRTFC11");
		map.add("fldUserType", "EN1");
		map.add("fldHiddenTxnId", "TFC");

		ResponseEntity<String> response = restTemplate.postForEntity(url, map, String.class);
		return response.getBody();

	}

}
