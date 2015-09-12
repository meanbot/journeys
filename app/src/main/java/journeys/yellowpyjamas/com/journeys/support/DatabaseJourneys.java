package journeys.yellowpyjamas.com.journeys.support;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseJourneys extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "journeys.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "journeys";

    // Column name and identifier                                   Column number
    public static final String _ID = "_id";							//0
    public static final String TITLE = "title";                     //1
    public static final String WHERE = "where";                     //2
    public static final String WHEN = "when";                       //3
    public static final String WHAT = "what";                       //4
    public static final String DURATION = "duration";               //5
    public static final String LIVE = "live";                       //6
    public static final String GIF_LINK = "gif_link";               //7
    public static final String STREAM_LINK = "stream_link";         //8

    public DatabaseJourneys(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY, "
                + TITLE + " TEXT, "
                + WHERE + " TEXT, "
                + WHEN + " TEXT, "
                + WHAT + " TEXT, "
                + DURATION + " TEXT, "
                + LIVE + " INTEGER, "
                + GIF_LINK + " TEXT, "
                + STREAM_LINK + " TEXT);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addRecord(String title, String where, String when, String what, String duration, String live, String gifLink, String streamLink)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, title);
        values.put(WHERE, where);
        values.put(WHEN, when);
        values.put(WHAT, what);
        values.put(DURATION, duration);
        values.put(LIVE, live);
        values.put(GIF_LINK, gifLink);
        values.put(STREAM_LINK, streamLink);

        db.insert(TABLE_NAME, null, values);
    }

    public Cursor allRows()
    {
		/*
		 * Returns a cursor to all rows and all columns in the database in the order in which they were initialized
		 */

        String[] from = { _ID, TITLE, WHERE, WHEN, WHAT, DURATION, LIVE, GIF_LINK, STREAM_LINK};

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
        String[] from = { _ID, TITLE, WHERE, WHEN, WHAT, DURATION, LIVE, GIF_LINK, STREAM_LINK};
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
