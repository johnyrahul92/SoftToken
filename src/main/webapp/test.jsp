<%@ page import="java.util.*, java.io.*, java.sql.*, java.net.*, java.util.regex.*" %>
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage=""%>
<%
	request.setCharacterEncoding("UTF-8");
	String str = "";
	StringBuffer tempBuffer = new StringBuffer();
	StringBuffer finalBuffer = new StringBuffer();
	URL objURL = new URL("https://testgbonline.e-gulfbank.com/WISE/integrationServices/loadportfoliooverviewdetails?portfolio_id=P00000001");
	try
	{
		URLConnection objURLCon = objURL.openConnection();
		objURLCon.connect();
		InputStreamReader inRead = new InputStreamReader(objURLCon.getInputStream());
		BufferedReader objBufR = new BufferedReader(inRead);
		while ((str = objBufR.readLine()) != null)
			tempBuffer.append(str + "\r\n");
		objBufR.close();
		inRead.close();
            finalBuffer.append( tempBuffer.toString().replace("/WISE", "https://testgbonline.e-gulfbank.com/WISE") );
	}
	catch (Exception e)
	{
	}
	out.println(finalBuffer.toString());
%>
