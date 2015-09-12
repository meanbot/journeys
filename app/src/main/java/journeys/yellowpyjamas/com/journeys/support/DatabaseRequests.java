package journeys.yellowpyjamas.com.journeys.support;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseRequests extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "journey_requests.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "journey_requests";

    // Column name and identifier                                   Column number
    public static final String _ID = "_id";							//0
    public static final String WHERE = "where";		    	        //1
    public static final String WHAT = "what";		                //2

    public DatabaseRequests(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY, "
                + WHERE + " TEXT, "
                + WHAT + " TEXT);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addRecord(String where, String what)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WHERE, where);
        values.put(WHAT, what);

        db.insert(TABLE_NAME, null, values);
    }

    public Cursor allRows()
    {
		/*
		 * Returns a cursor to all rows and all columns in the database in the order in which they were initialized
		 */

        String[] from = { _ID, WHERE, WHAT};

        String order = _ID;

        SQLiteDatabase db = getWritableDatabase();
        return db.query(TABLE_NAME, from, null, null, null, null, order);
    }

    public long count()
    {
        long count;
        SQLiteDatabase db = getReadableDatabase();
        count = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return count;
    }

    public void deleteEntry(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, _ID+"="+id, null);
    }

    public void deleteAllEntries()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
    }

    public Cursor searchRows(String key, String value)
    {
		/*
		 * Returns a Cursor to all columns in the db where rows are matched by the incoming key-value pair
		 */
        String[] from = { _ID, WHERE, WHAT};
        String order = _ID;
        String where = key + " = ?";
        String[] args = new String[] {value};

        SQLiteDatabase db = getWritableDatabase();
        return db.query(TABLE_NAME, from, where, args, null, null, order);
    }

    public void close()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.close();
    }
}
