package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static android.icu.text.MessagePattern.ArgType.SELECT;

public class DocADB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DoctorA_db";
    private static final String TABLE_NAME = "DoctorA";
    private static final String PATIENT_NUMBER = "Patient_number";
    private static final String NAME = "Name";
    private static final String PHONE = "Phone";
    private static final String DATE = "Date";
    private static final int DATABASE_VERSION_NO = 1;
    private Context context;

    private static final String Create_Table = "CREATE TABLE "+TABLE_NAME+"("+PATIENT_NUMBER+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            ""+NAME+" VARCHAR(255)," +
            ""+PHONE+" VARCHAR(15)," +
            ""+DATE+" VARCHAR(30));";

    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    public DocADB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION_NO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context,"onCreate successful",Toast.LENGTH_SHORT).show();
            db.execSQL(Create_Table);
        }catch (Exception e){
            Toast.makeText(context,"Exception",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"onUpgrade called",Toast.LENGTH_SHORT).show();
            db.execSQL(DELETE_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context,"Exception",Toast.LENGTH_SHORT).show();
        }

    }

    public Long InsertPatientData(String name,String phone,String date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(PHONE,phone);
        contentValues.put(DATE,date);

        long rowID = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowID;
    }

    public Cursor showAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }

    public Cursor checkAvailibility(String Date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + DATE + " = ?" , new String[]{String.valueOf(Date)}, null);
        return cursor;
    }
    public Integer deleteMethod(String patient_number){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,PATIENT_NUMBER+" = ?",new String[]{patient_number});
    }

}
