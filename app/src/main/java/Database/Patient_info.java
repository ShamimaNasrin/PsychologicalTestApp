package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Patient_info extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Patient_DB";
    private static final String TABLE_NAME = "Patient_details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";
    private static final String PHONE = "Phone";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String SCORE = "Score";
    private static final int DATABASE_VERSION_NO = 2;
    private Context context;

    private static final String Create_Table = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            ""+NAME+" VARCHAR(255)," +
            ""+AGE+" INTEGER," +
            ""+GENDER+" VARCHAR," +
            ""+PHONE+" VARCHAR(15)," +
            ""+USERNAME+" VARCHAR(50)," +
            ""+PASSWORD+" VARCHAR(50)," +
            ""+SCORE+" VARCHAR(30));";

    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    public Patient_info(@Nullable Context context) {
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

    public Long InsertSignupData(String name,String age,String gender,String phone,String username,String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);
        contentValues.put(PHONE,phone);
        contentValues.put(USERNAME,username);
        contentValues.put(PASSWORD,password);

        long rowID = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowID;
    }

    //MainActivity
    public Boolean LoginMethod(String userName, String passWord){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        Boolean cursorresult = false;
        if (cursor.getCount()==0){
            Toast.makeText(context, "Null database", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                String u_name = cursor.getString(5);
                String u_password = cursor.getString(6);
                if (u_name.equals(userName) && u_password.equals(passWord)){
                    cursorresult = true;
                    break;
                }
            }
        }
        return cursorresult;
    }

    public Boolean CheckPhoneMethod(String Phone){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        Boolean cursorresult = false;
        if (cursor.getCount()==0){
            Toast.makeText(context, "Null", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                String c_name = cursor.getString(4);

                if (c_name.equals(Phone)){
                    cursorresult = true;
                    break;
                }
            }
        }
        return cursorresult;
    }


    public Boolean updateScoreMethod(String getPhone,String score){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE,score);

        sqLiteDatabase.update(TABLE_NAME,contentValues,PHONE+"=?",new String[]{getPhone});
        return true;
    }

    //MainActivity
    public String fetchPhone(String username,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        String phone = null;
        if (cursor.getCount() == 0) {
            Toast.makeText(context, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                phone = cursor.getString(4);
                String u_name = cursor.getString(5);
                String u_password = cursor.getString(6);
                if (u_name.equals(username) && u_password.equals(password)) {
                    break;
                }
            }
        }
        return phone;
    }

    //MainActivity
    public String fetchScore(String username,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        String score = null;
        if (cursor.getCount() == 0) {
            Toast.makeText(context, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                score = cursor.getString(7);
                String u_name = cursor.getString(5);
                String u_password = cursor.getString(6);
                if (u_name.equals(username) && u_password.equals(password)) {
                    break;
                }
            }
        }
        return score;
    }




}
