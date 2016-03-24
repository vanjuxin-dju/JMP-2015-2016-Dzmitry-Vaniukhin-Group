package com.epam.example.wtask2;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RandService {
	@WebMethod
	public int random(int lower, int higher) {
		return (int)Math.floor(Math.random() * (higher - lower + 1)) + lower;
	}
}
