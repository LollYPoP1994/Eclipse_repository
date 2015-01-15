package com.example.first_bd_project_double_two.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class DbAdapter3 
{
	public static final String DB_NAME = "detalotest";
	public static final int DB_VERSION = 3;
	
	public static final String TABLE_NAME	 = "detals";
	public static final String ID = "_id";
	public static final String NAME = "name";
	
	public static final String TYPE = "tipe";
	public static final String RAZMER = "razmer";
	public static final String DIAMETR = "diametr";
	public static final String PRICE = "price";
	
	Context context;
	private DbHelper dbHelper;
	private SQLiteDatabase db;
	
	public DbAdapter3 (Context context)
	{
		this.context = context;
    	dbHelper = new DbHelper(context);
		db = dbHelper.getReadableDatabase();
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
			String sql = "create table if not exists " + TABLE_NAME + "( " + ID +
					" integer primary key autoincrement " + " , " +
					NAME + " text " + " , " +
					PRICE + " real " + " , " +
					DIAMETR + " real " + " , " +
					TYPE + " int " + " , " + 
					RAZMER + " real " + " );";
			db.execSQL(sql);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
}
