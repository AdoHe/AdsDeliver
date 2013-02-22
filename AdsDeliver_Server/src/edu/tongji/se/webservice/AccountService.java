package edu.tongji.se.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AccountService 
{
	@WebMethod(action="getAccountBalance")
	public int getAccountBalance(@WebParam(name="userName") String userName);
}
