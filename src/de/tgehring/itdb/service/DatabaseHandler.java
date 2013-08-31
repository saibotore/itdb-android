package de.tgehring.itdb.service;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.itdb.model.Benutzer;
import de.tgehring.itdb.model.Todo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "itdb";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		dropBenutzerTable(db);
		dropTodoTable(db);
		String CREATE_TODO_TABLE = Todo.createTable();
		String CREATE_BENUTZER_TABLE = Benutzer.createTable();
        db.execSQL(CREATE_TODO_TABLE);
        db.execSQL(CREATE_BENUTZER_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS " + Todo.getTableName());
		db.execSQL("DROP TABLE IF EXISTS " + Benutzer.getTableName());
        onCreate(db);
	}
	
	public void truncateTodoTable() {
		SQLiteDatabase db = this.getWritableDatabase();
		dropTodoTable(db);
		db.execSQL(Todo.createTable());
	}
	
	public void truncateBenutzerTable() {
		SQLiteDatabase db = this.getWritableDatabase();
		dropBenutzerTable(db);
		db.execSQL(Benutzer.createTable());
	}
	
	public void dropTodoTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + Todo.getTableName());
	}
	
	public void dropBenutzerTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + Benutzer.getTableName());
	}
	
    public void addTodo(Todo todo) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put("ID", todo.getId());
        values.put("NAME", todo.getName());
        values.put("BESCHREIBUNG", todo.getBeschreibung());
        values.put("WICHTIG", todo.getWichtig());
        values.put("DATE", todo.getDate());
 
        db.insert(Todo.getTableName(), null, values);
        db.close();
    }
    
	public Todo getTodo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(Todo.getTableName(), new String[] { "ID",
                "NAME", "BESCHREIBUNG", "WICHTIG", "DATE"}, "ID" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Todo todo = new Todo();
        todo.setId(Integer.parseInt(cursor.getString(0)));
        todo.setName(cursor.getString(1));
        todo.setBeschreibung(cursor.getString(2));
        todo.setWichtig(Integer.parseInt(cursor.getString(3)));
        todo.setDate(cursor.getString(4));
        db.close();
        return todo;
    }
	
    public List<Todo> getAllTodos() {
        List<Todo> list = new LinkedList<Todo>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Todo.getTableName();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
        	while (cursor.moveToNext()) {
        		Todo todo = new Todo();
        		todo.setId(Integer.parseInt(cursor.getString(0)));
                todo.setName(cursor.getString(1));
                todo.setBeschreibung(cursor.getString(2));
                todo.setWichtig(Integer.parseInt(cursor.getString(3)));
                todo.setDate(cursor.getString(4));
                list.add(todo);
			}
        }
        db.close();
        return list;
    }
 
    public int updateTodo(Todo todo) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put("NAME", todo.getName());
        values.put("BESCHREIBUNG", todo.getBeschreibung());
        values.put("WICHTIG", todo.getWichtig());
        values.put("DATE", todo.getDate());
        
        db.close();
        return db.update(Todo.getTableName(), values, "ID" + " = ?",
                new String[] { String.valueOf(todo.getId()) });
    }
 
    public void deleteTodo(Todo todo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Todo.getTableName(), "ID" + " = ?",
                new String[] { String.valueOf(todo.getId()) });
        db.close();
    }
 
    public int getTodosCount() {
        String countQuery = "SELECT  * FROM " + Todo.getTableName();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
        return cursor.getCount();
    }
    
    public void addBenutzer(Benutzer benutzer) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put("ID", benutzer.getId());
    	values.put("VORNAME", benutzer.getVorname());
    	values.put("NACHNAME", benutzer.getNachname());
    	values.put("BENUTZERNAME", benutzer.getBenutzername());
    	values.put("PASSWORT", benutzer.getPasswort());
    	int admin = 0;
    	if(benutzer.isAdmin()) {
    		admin = 1;
    	}
    	values.put("ADMIN", admin);
    	
    	db.insert(Benutzer.getTableName(), null, values);
    	db.close();
    }
    
    public Benutzer getBenutzer(int id) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	Cursor cursor = db.query(Todo.getTableName(), new String[] { "ID",
    		"VORNAME", "NACHNAME", "BENUTZERNAME", "PASSWORT", "ADMIN" }, "ID" + "=?",
    		new String[] { String.valueOf(id) }, null, null, null, null);
    	if (cursor != null)
    		cursor.moveToFirst();
    	
    	Benutzer benutzer = new Benutzer();
    	benutzer.setId(Integer.parseInt(cursor.getString(0)));
    	benutzer.setVorname(cursor.getString(1));
    	benutzer.setNachname(cursor.getString(2));
    	benutzer.setBenutzername(cursor.getString(3));
    	benutzer.setPasswort(cursor.getString(4));
    	boolean admin = false;
    	if(Integer.parseInt(cursor.getString(5)) == 1) {
    		admin = true;
    	}
    	benutzer.setAdmin(admin);
    	db.close();
    	return benutzer;
    }
    
    public List<Benutzer> getAllBenutzer() {
    	List<Benutzer> list = new LinkedList<Benutzer>();
    	// Select All Query
    	String selectQuery = "SELECT  * FROM " + Benutzer.getTableName();
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
    	if (cursor.moveToFirst()) {
    		while (cursor.moveToNext()) {
    			Benutzer benutzer = new Benutzer();
    	    	benutzer.setId(Integer.parseInt(cursor.getString(0)));
    	    	benutzer.setVorname(cursor.getString(1));
    	    	benutzer.setNachname(cursor.getString(2));
    	    	benutzer.setBenutzername(cursor.getString(3));
    	    	benutzer.setPasswort(cursor.getString(4));
    	    	boolean admin = false;
    	    	if(Integer.parseInt(cursor.getString(5)) == 1) {
    	    		admin = true;
    	    	}
    	    	benutzer.setAdmin(admin);
    			list.add(benutzer);
    		}
    	}
    	db.close();
    	return list;
    }
    
    public int updateBenutzer(Benutzer benutzer) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put("VORNAME", benutzer.getVorname());
    	values.put("NACHNAME", benutzer.getNachname());
    	values.put("BENUTZERNAME", benutzer.getBenutzername());
    	values.put("PASSWORT", benutzer.getPasswort());
    	int admin = 0;
    	if(benutzer.isAdmin()) {
    		admin = 1;
    	}
    	values.put("ADMIN", admin);
    	db.close();
    	
    	return db.update(Benutzer.getTableName(), values, "ID" + " = ?",
    			new String[] { String.valueOf(benutzer.getId()) });
    }
    
    public void deleteBenutzer(Benutzer benutzer) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	db.delete(Benutzer.getTableName(), "ID" + " = ?",
    			new String[] { String.valueOf(benutzer.getId()) });
    	db.close();
    }
    
    
    public int getBenutzerCount() {
    	String countQuery = "SELECT  * FROM " + Benutzer.getTableName();
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.rawQuery(countQuery, null);
    	cursor.close();
    	db.close();
    	return cursor.getCount();
    }
    
    public int getTodoCount() {
    	String countQuery = "SELECT  * FROM " + Todo.getTableName();
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.rawQuery(countQuery, null);
    	cursor.close();
    	db.close();
    	return cursor.getCount();
    }

}
