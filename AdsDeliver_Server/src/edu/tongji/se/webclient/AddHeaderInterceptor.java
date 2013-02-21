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
	private int userId;
	private String sessionId;
	
	public AddHeaderInterceptor(int userId, String sessionId)
	{
		super(Phase.PREPARE_SEND);
		this.setUserId(userId);
		this.setSessionId(sessionId);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault 
	{
		// TODO Auto-generated method stub
		Document document = DOMUtils.createDocument();
		Element authElement = document.createElement("auth");
		Element userIdElement = document.createElement("ads:id");
		userIdElement.setTextContent(String.valueOf(userId));
		authElement.appendChild(userIdElement);
		Element sessionIdElement = document.createElement("ads:session");
		sessionIdElement.setTextContent(sessionId);
		authElement.appendChild(sessionIdElement);
		
		Header header = new Header(new QName("edu.tongji.se.webservice"), authElement);
		message.getHeaders().add(header);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
