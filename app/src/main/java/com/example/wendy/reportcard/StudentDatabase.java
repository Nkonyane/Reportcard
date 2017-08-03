package com.example.wendy.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.name;
import static android.R.attr.thickness;
import static android.R.attr.x;
import static com.example.wendy.reportcard.R.id.average;
import static com.example.wendy.reportcard.R.id.mark1;

/**
 * Created by Wendy on 2017/07/27.
 */

public class StudentDatabase extends SQLiteOpenHelper {
    private static final String TABLE_LEARNER = "Leaner";
    private final String COLUMN_NAME = "name";
    private final String COLUMN_ID = "id";
    private final String COLUMN_SURNAME = "surname";
    private final String COLUMN_GRADE = "gender";
    private final String COLUMN_MARK1 = "mark1";
    private final String COLUMN_MARK2 = "mark2";
    private final String COLUMN_TOTAL = "total";
    private final String COLUMN_AVERAGE = "average";
    private static final String DATABASE_NAME = "student.db";
    private final static int DATABASE_VERSION = 9;
    private final String DATABASE_CREATE = "create table " + TABLE_LEARNER + "( " + COLUMN_ID +
            " integer PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " text not null, " +
            COLUMN_SURNAME + " text not null, " + COLUMN_GRADE + " text not null, " +
            COLUMN_MARK1 + " text not null, " + COLUMN_MARK2 + " text not null, "+ COLUMN_TOTAL +
            " text not null, " +  COLUMN_AVERAGE + " text not null);" ;


    public StudentDatabase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Drop table if exists " + TABLE_LEARNER);
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_LEARNER);
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //id, std_num, name, gender, mark,mark2,mark3
        //contentValues.put(this.COLUMN_ID, "null");
        contentValues.put(this.COLUMN_NAME, student.getNames());
        contentValues.put(this.COLUMN_SURNAME, student.getSurname());
        contentValues.put(COLUMN_GRADE, student.getGrade());
        contentValues.put(COLUMN_MARK1, student.getMark1());
        contentValues.put(COLUMN_MARK2, student.getMark2());
        contentValues.put(COLUMN_TOTAL, student.getTotal());
        contentValues.put(COLUMN_AVERAGE, student.getAverage());

        db.insert(this.TABLE_LEARNER, null, contentValues);
    }

    public ArrayList<String> getAllStudents() {
        ArrayList<String> students = new ArrayList<>();
        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_LEARNER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);

                String name = cursor.getString(1);
                String surname = cursor.getString(2);
                System.out.println(cursor.getString(3));
                String grade = cursor.getString(3);
                String mark1 = cursor.getString(4);
                String mark2 = cursor.getString(5);
                String average = cursor.getString(7);
                int total = cursor.getInt(6);

                String display = id + "Learner Name: " + name + " " + "Surname: " + " " + surname +
                        " " + "Grade: " + " " + grade + " " + "Mark1: " + " " + mark1 + " " +
                        "Mark2: " + " " + mark2 +"Total: " + " " + total+ " Average: " + " " + average;
                students.add(display);
            }
            while (cursor.moveToNext());
        }
        return students;

    }

    public int deleteStudent(String x) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {x};
        int count = db.delete(this.TABLE_LEARNER, this.COLUMN_NAME + " = ? ", whereArgs);
        db.close();
        return count;
    }

    public void updateStudent(Student student) {

        //Student student = new Student();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String[] wherArgs = {student.getNames()};

        contentValues.put(this.COLUMN_NAME, student.getNames());
        contentValues.put(this.COLUMN_SURNAME, student.getSurname());
        contentValues.put(COLUMN_GRADE, student.getGrade());
        contentValues.put(COLUMN_MARK1, student.getMark1());
        contentValues.put(COLUMN_MARK2, student.getMark2());
        contentValues.put(COLUMN_TOTAL, student.getTotal());
        contentValues.put(COLUMN_AVERAGE, student.getAverage());

        db.update(this.TABLE_LEARNER, contentValues, this.COLUMN_NAME + " = ?", wherArgs);

    }

    public Student getAStudent(int id) {
        Student s = new Student();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_LEARNER + " where " + COLUMN_ID + " = ? ";
        String args[] = {String.valueOf(id)};
        Cursor c = db.rawQuery(selectQuery, args);
        if (c.moveToFirst()) {

            s.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
            s.setNames(c.getString(c.getColumnIndex(COLUMN_NAME)));
            s.setSurname(c.getString(c.getColumnIndex(COLUMN_NAME)));
//            s.setMark1(c.getInt(c.getColumnIndex(COLUMN_MARK1)));
//            s.setMark2(c.getInt(c.getColumnIndex(COLUMN_MARK2)));
//            s.setTotal(c.getInt(c.getColumnIndex(COLUMN_TOTAL)));
            s.setAverage(c.getInt(c.getColumnIndex(COLUMN_AVERAGE)));

        }
        return s;
    }
}