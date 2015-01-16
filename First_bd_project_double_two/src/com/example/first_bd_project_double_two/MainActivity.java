package com.example.first_bd_project_double_two;

import java.util.ArrayList;

import com.example.first_bd_project_double_two.models.Product;
import com.example.first_bd_project_double_two.objects.AppContext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity
{
    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		Product p = new Product();
//		p.Name = "vasya";
//		p.Description = "blabla";
//		p.Cathegory = 21;
//		AppContext.dbAdapter1.Add(p);
		//AppContext.dbAdapter1.Delete(1);
	 ArrayList<Product> list = 	AppContext.dbAdapter1.getProducts();
	 
	 int count = list.size();
	 count++;
	} 
        
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
