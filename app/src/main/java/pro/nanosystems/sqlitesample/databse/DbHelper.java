package pro.nanosystems.sqlitesample.databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = "DbHelper";
    public static final String DATABSE = "tasks.db";
    public static final int VERSION = 1;

    class Task implements BaseColumns {
        public static final String TABLE = "task_list";
        public static final String TITLE = "title";
        public static final String NOTES = "notes";
        public static final String TASK_DATE = "task_date";
        public static final String DONE = "done";
        public static final int DONE_TASK = 1;
        public static final int UNDONE_TASK = 0;
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE +
                "( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TITLE + " TEXT NOT NULL, " +
                NOTES + " TEXT , " +
                TASK_DATE + " TEXT NOT NULL, " +
                DONE + " INTEGER NOT NULL );";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE;

    }

    class Users implements BaseColumns {
        public static final String TABLE = "users";
        public static final String USER_NAME = "username";
        public static final String PASSWORD = "password";
        public static final String TYPE = "type";
        public static final int MALE = 0;
        public static final int FEMALE = 1;
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE +
                "( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT NOT NULL, " +
                PASSWORD + " TEXT NOT NULL, " +
                TYPE + " INTEGER NOT NULL );";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE;
    }

    public DbHelper(Context context) {
        super(context, DATABSE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Task.CREATE_TABLE);
        Log.i(TAG, "onCreate: Task " + Task.CREATE_TABLE);
        db.execSQL(Users.CREATE_TABLE);
        Log.i(TAG, "onCreate: USers " + Users.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Task.DROP_TABLE);
        db.execSQL(Users.DROP_TABLE);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


}
