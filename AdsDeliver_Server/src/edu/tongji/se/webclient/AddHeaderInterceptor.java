package edu.tongji.se.webclient;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddHeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage> 
{
	private String userName;
	private String sessionId;
	
	public AddHeaderInterceptor(String userName, String sessionId)
	{
		super(Phase.PREPARE_SEND);
		this.setUserName(userName);
		this.setSessionId(sessionId);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault 
	{
		// TODO Auto-generated method stub
		Document document = DOMUtils.createDocument();
		Element authElement = document.createElement("auth");
		Element userIdElement = document.createElement("ads:id");
		userIdElement.setTextContent(userName);
		authElement.appendChild(userIdElement);
		Element sessionIdElement = document.createElement("ads:session");
		sessionIdElement.setTextContent(sessionId);
		authElement.appendChild(sessionIdElement);
		
		Header header = new Header(new QName("edu.tongji.se.webservice"), authElement);
		message.getHeaders().add(header);
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
