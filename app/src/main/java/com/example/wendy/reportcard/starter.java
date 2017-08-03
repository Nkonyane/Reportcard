package com.example.wendy.reportcard;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.publicKey;
import static android.R.attr.start;

public class starter extends AppCompatActivity {

    StudentDatabase sd = new StudentDatabase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        ArrayList<String> students = sd.getAllStudents();
        sd.getAllStudents();
        ListView lv = (ListView) findViewById(R.id.list);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, students);
        lv.setAdapter(arrayAdapter);


          lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                  AlertDialog.Builder dialog = new AlertDialog.Builder(starter.this);

                  dialog.setTitle("student report ");
                  dialog.setMessage("are you sure you want to: ");
                  dialog.setNegativeButton("Delete ", new DialogInterface.OnClickListener(){

                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          int id =(position+1);
//                          deleteStudent(id);
                          System.out.println(id);
                          Intent intent = new Intent(starter.this, MainActivity.class);
                          startActivity(intent);
                      }
                  });

                  dialog.setPositiveButton("Update ", new DialogInterface.OnClickListener(){
                      @Override
                      public void onClick(DialogInterface dialog, int which) {

                          Intent intent = new Intent(starter.this, MainActivity.class);
                          startActivity(intent);
                      }


                  });
                  dialog.show();
              }
          });




    }

    public void add(View view){
        Intent intent = new Intent(starter.this, MainActivity.class);
        startActivity(intent);
    }

    public void delete(View view ){
        Intent intent = new Intent(starter.this, MainActivity.class);
        startActivity(intent);

    }

    public void update(View view){
        Intent intent = new Intent(starter.this, MainActivity.class);
        startActivity(intent);
    }

    void deleteStudent(int x){
        sd.deleteStudent(String.valueOf(x));
    }
}
