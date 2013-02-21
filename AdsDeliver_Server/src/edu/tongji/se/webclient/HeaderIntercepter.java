package edu.tongji.se.webclient;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 客户端请求时SOAP头部添加sessionId
 * @author Martian
 *
 */
public class HeaderIntercepter extends AbstractSoapInterceptor {
	private String qname;
	private String mUserId;
	private String mSessionId;
	public HeaderIntercepter(String userId, String sessionId) {
		super(Phase.WRITE);
		
		this.mUserId = userId;
		this.mSessionId = sessionId;
	}
	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		// TODO Auto-generated method stub
		/*这里有个问题，这两个东西怎么传到这里*/
		String spName = mUserId;
		String spSession = mSessionId;
		
		QName name = new QName("RequestSOAPHeader");  
        Document doc = DOMUtils.createDocument();  
          
        Element spId = doc.createElement("ads:id");  
        spId.setTextContent(spName);  
         
        Element spPass = doc.createElement("ads:session");  
        spPass.setTextContent(spSession);  
          
        Element root = doc.createElementNS(qname, "tns:RequestSOAPHeader");  
        root.appendChild(spId);  
        root.appendChild(spPass);  
          
        SoapHeader head = new SoapHeader(name,root);  
        List<Header> headers = soapMessage.getHeaders();  
        headers.add(head); 
	}
}
