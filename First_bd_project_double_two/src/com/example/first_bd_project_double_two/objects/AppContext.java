package com.example.first_bd_project_double_two.objects;

import com.example.first_bd_project_double_two.databases.DbAdapter1;
import com.example.first_bd_project_double_two.databases.DbAdapter2;
import com.example.first_bd_project_double_two.databases.DbAdapter3;

import android.app.Application;

public class AppContext extends Application 
{
	public static DbAdapter1 dbAdapter1;
	public static DbAdapter2 dbAdapter2;
	public static DbAdapter3 dbAdapter3;
@Override
public void onCreate() 
{
	super.onCreate();
	dbAdapter1 = new DbAdapter1(getApplicationContext());
	//dbAdapter2 = new DbAdapter2(getApplicationContext());
	//dbAdapter3 = new DbAdapter3(getApplicationContext());
}
}
