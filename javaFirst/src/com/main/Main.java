package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.exception.UserNotFoundException;
import dal.view.MainClass;

class Main
{
	public static void main(String[] args) throws IOException
	{
	
		try{
		String uname=null;
		String pwd = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter Username:");
		uname=br.readLine();
		System.out.println("Enter password:");
		pwd= br.readLine();

		if(uname.equals("deeps") && pwd.equals("pass"))
		{
			MainClass mc = new MainClass();
			System.out.println(mc);
			System.out.println("Welcome " + uname);
		}
		else{
			throw new UserNotFoundException();
		
		}
		}
		catch(UserNotFoundException unf)
		{
			System.out.println(unf);
		}

	}
}