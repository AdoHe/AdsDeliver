package edu.tongji.se.webserviceImpl;

import javax.jws.WebService;

import edu.tongji.se.model.User;
import edu.tongji.se.webservice.TestService;

@WebService(
		serviceName = "TestService",
		endpointInterface = "edu.tongji.se.webservice.TestService") 
public class TestServiceImpl implements TestService
{

	@Override
	public User getUser(String name) 
	{

		System.out.println("sayHello is called by " + name); 
		User user = new User();
		user.setUsName(name);
		
		return user;
	}
	
}
