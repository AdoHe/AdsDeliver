package edu.tongji.se.webserviceImpl;

import java.util.List;

import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.binding.soap.SoapMessage; 
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.w3c.dom.Element;

public class AuthorInterceptor extends AbstractPhaseInterceptor<SoapMessage>
{

	private SAAJInInterceptor saa = new SAAJInInterceptor();
	
	public AuthorInterceptor() {
		super(Phase.PRE_PROTOCOL);  
        getAfter().add(SAAJInInterceptor.class.getName());  
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault 
	{

		System.out.println("come in ServicesAuthorInterceptor ");  
        List<Header> headers = message.getHeaders();
        if(headers == null || headers.size() == 0)
        {
        	throw new Fault(new IllegalAccessException("There is no some fault"));
        }
        
        Header header = headers.get(0);
        Element element = (Element)header.getObject();
        
        int id = Integer.valueOf(element.getElementsByTagName("ads:id").item(0).getTextContent());
        String session = element.getElementsByTagName("ads:session").item(0).getTextContent();
        
        if(session.equals(""))
        {
        	return;
        }else
        {
        	throw new Fault(new RuntimeException("Runtime error"));
        } 
	}  
	
}
