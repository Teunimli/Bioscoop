package com.example.rickyberg.bioscopify.DataAccessLayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Michael on 27/03/2018.
 */

public class SqlHandler extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public SqlHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `Movie` (\n" +
                "\t`id`\tINTEGER NOT NULL,\n" +
                "\t`title`\tTEXT,\n" +
                "\t`adult`\tInteger,\n" +
                "\t`genre`\tTEXT,\n" +
                "\t`language`\tTEXT,\n" +
                "\t`posterpath`\tTEXT,\n" +
                "\t`overview`\tTEXT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Item");
        this.onCreate(sqLiteDatabase);
    }
    public SQLiteDatabase getDatabase()
    {
        return db;
    }
    public void closeConnection()
    {
        db.close();
    }
}
