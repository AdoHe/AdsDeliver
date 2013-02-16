package edu.tongji.se.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import edu.tongji.se.model.User;

@WebService
public interface TestService {
	public User getUser(@WebParam(name="name") String name);
}
