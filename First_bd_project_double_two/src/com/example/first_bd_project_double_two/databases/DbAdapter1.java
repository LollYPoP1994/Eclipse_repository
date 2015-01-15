package com.example.first_bd_project_double_two.databases;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.first_bd_project_double_two.models.Product;

public class DbAdapter1 
{
	public static final String DB_NAME = "test";
	public static final int DB_VERSION = 1;
	
	public static final String TABLE_NAME	 = "purchase";
	public static final String ID = "_id";
	public static final String NAME = "name";
	
	public static final String CATHEGORY = "cathegory";
	public static final String DESCRIPTION = "description";
	
	
	Context context;
	private DbHelper dbHelper;
	private SQLiteDatabase db;
    public DbAdapter1 ( Context context)
    {
    	this.context = context;
    	dbHelper = new DbHelper(context);
		db = dbHelper.getReadableDatabase();
       createtable();
    }
    private void createtable () 
    {
    	String sql = "create table if not exists " + TABLE_NAME  + "( " + ID + 
				" integer primary key autoincrement " + " , " + 
				 NAME + " text " + " , " +
				 CATHEGORY + " int " + " , " + 
				 DESCRIPTION + " text " +  ");";
				
				 
		
		db.execSQL(sql);
	}
    public void Add(Product p)
    {
		ContentValues cv = new ContentValues();
		cv.put(NAME, p.Name);
		cv.put(CATHEGORY, p.Cathegory);
		cv.put(DESCRIPTION, p.Description);
		
		long id = db.insert(TABLE_NAME, null, cv);
		Toast.makeText(context, "id = " + id, Toast.LENGTH_SHORT).show();

	}
    public void Delete(int id)
    {
    	long count = db.delete(TABLE_NAME, ID + " = " + id, null);
    	Toast.makeText(context, "count = " + count, Toast.LENGTH_SHORT).show();
    }
    public void Update(Product p)
    {
    	int a = 0;
    	
    	a++;
    	a++;
    }
    public ArrayList<Product> getProducts()
    {
String sql = "select * from " + TABLE_NAME;
    	
    	Cursor c = db.rawQuery(sql, null);
    	
    	ArrayList<Product> list = new ArrayList<Product>();
    	if ( c.moveToFirst())
    	{
    		do
    		{
    			Product p = new Product();
                p.Id = c.getInt(c.getColumnIndex(ID));
    			p.Name = c.getString(c.getColumnIndex(NAME));
    			p.Description = c.getString(c.getColumnIndex(DESCRIPTION));
    			p.Cathegory = c.getInt(c.getColumnIndex(CATHEGORY));
    			
    			list.add(p);
    		}while(c.moveToNext());
    	}
    	return list;

    }
    private static class DbHelper extends SQLiteOpenHelper 
    {

		public DbHelper(Context context) 
		{
			super(context, DB_NAME, null, DB_VERSION);
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) 
		{
			
			String sql = "create table if not exists " + TABLE_NAME  + "( " + ID + 
					" integer primary key autoincrement " + " , " + 
					 NAME + " text " + " , " +
					 CATHEGORY + " int " + " , " + 
					 DESCRIPTION + " text " +  ");";
					
					 
			
			db.execSQL(sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			
			
		}
    }
    
}

