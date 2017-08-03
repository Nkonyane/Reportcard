package com.example.wendy.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {


    private boolean update;
    private int id;
    private EditText Name;
    private EditText Grade;
    private EditText Surname;
    private EditText Mark1;
    private EditText Mark2;
    private TextView Total;
    private TextView Average;
    StudentDatabase sd = new StudentDatabase(this);

    static int myTotal;
    static int avarage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.edit_learner_name);
        Surname=(EditText) findViewById(R.id.edit_learner_surname);
        Grade = (EditText) findViewById(R.id.edit_learner_grade);
        Mark1 = (EditText) findViewById(R.id.edit_mark_1);
        Mark2 = (EditText) findViewById(R.id.edit_mark_2);
        Total=(TextView)findViewById(R.id.edit_total);
        Average=(TextView)findViewById(R.id.edit_average);
    }

    public void addOnDB(View view) {

        long i = 0;

        String name = Name.getText().toString();
        String surname = Surname.getText().toString();
        String grade =Grade .getText().toString();
        String mark1 = Mark1.getText().toString();
        String mark2 = Mark2.getText().toString();

        String total = Total.getText().toString();
        String average = Average.getText().toString();

        int m1 = Integer.parseInt(mark1);
        int m2 = Integer.parseInt(mark2);
//        int t = Integer.parseInt(total);
 //       int av = Integer.parseInt(average);

        int getTotal = (m1+m2);
        int getAvarage = (m1+m2)/2;


        Student student = new Student(name,surname, grade,mark1,mark2, getTotal,getAvarage);


        sd.addStudent(student);
        Intent intent = new Intent(this, starter.class);
        startActivity(intent);


    }

    public void delete(View view) {
        EditText name = (EditText) findViewById(R.id.edit_learner_name);
        String names = name.getText().toString();
        sd.deleteStudent(names);

        Intent intent = new Intent(this, starter.class);
        startActivity(intent);

    }

    public void update(View view) {

        String name = Name.getText().toString();
        String surname = Surname.getText().toString();
        String grade =Grade .getText().toString();
        String mark1 = Mark1.getText().toString();
        String mark2 = Mark2.getText().toString();

        int m1 = Integer.parseInt(mark1);
        int m2 = Integer.parseInt(mark2);

        int getTotal = (m1+m2);
        int getAvarage = (m1+m2)/2;

        Student student = new Student(name,surname, grade,mark1,mark2, getTotal,getAvarage);
        sd.updateStudent(student);

        Intent intent = new Intent(this, starter.class);
        startActivity(intent);
    }
}