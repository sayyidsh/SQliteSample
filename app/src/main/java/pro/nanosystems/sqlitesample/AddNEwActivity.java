package pro.nanosystems.sqlitesample;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pro.nanosystems.sqlitesample.databse.DbHelper;

public class AddNEwActivity extends AppCompatActivity {
    DbHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

    }
}
