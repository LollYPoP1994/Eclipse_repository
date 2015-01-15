package com.example.first_bd_project_double_two.databases;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter2 
{
	public static final String DB_NAME = "protest1";
	public static final int DB_VERSION = 2;
	
	public static final String TABLE_NAME	 = "books";
	public static final String ID = "_id";
	public static final String NAME = "name";
	
	public static final String PRICE = "price";
	public static final String CODE = "code";
	public static final String CATHEGORY = "cathegory";
	
	Context context;
	private DbHelper dbHelper;
	private SQLiteDatabase db;
	public DbAdapter2 ( Context context)
    {
    	this.context = context;
    	dbHelper = new DbHelper(context);
		db = dbHelper.getReadableDatabase();

    }
	
	private static class DbHelper extends SQLiteOpenHelper
	{

		public DbHelper(Context context)
		{
			super(context, DB_NAME, null ,DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) 
		{
			String sql = "create table if not exists " + TABLE_NAME + "( " + ID +
					" integer primary key autoincrement " + " , " +
					NAME + " text " + " , " +
					PRICE + " real " + " , " +
					CODE + " int " + " , " +
					CATHEGORY + " int " + " , " + " );";
					
			db.execSQL(sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		} 
	}
}
