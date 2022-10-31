package com.itbuzzpress.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.*;

import java.util.ArrayList;

@Singleton
@Startup
public class UserRegistry {
 
    @Resource
	TimerService timerService;

	public ArrayList<String> listUsers;
	@PostConstruct
	public void init() {
		listUsers = new ArrayList<String>();
		listUsers.add("administrator");

		timerService.createSingleActionTimer(5000, new TimerConfig());
		 
	}
	public void addUser(String username) {
		listUsers.add(username);	
	}
	public void removeUser(String username) {
		listUsers.remove(username);	
	}

	public ArrayList<String> getListUsers() {
		return listUsers;
	}
    @Timeout
	public void createReports(jakarta.ejb.Timer timer){
	   System.out.println("It is time to create a Report!");	 
	}
	
    @Schedule(hour = "*", minute = "*", second = "*/60", info ="Every minute timer",persistent=false)
    public void printDate() {

        System.out.println("Schedule invoked at " + new java.util.Date().toString());
	 
    }

}
