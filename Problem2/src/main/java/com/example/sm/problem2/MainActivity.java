package com.example.sm.problem2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.lang.*;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    ArrayList<Employee> emp_list = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here

        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        Employee employee = null;

        switch (v.getId()){
            case R.id.btn_inc:
                employee.increase();
                break;

            case R.id.btn_dec:
                employee.decrease();
                // need something here
                break;

            case R.id.btn_store:
                String x0 = (String) findViewById(R.id.edit_name).toString();
                String y0 = (String) findViewById(R.id.edit_age).toString();
                String z0 = (String) findViewById(R.id.edit_salary).toString();

                int tt0 = Integer.getInteger(y0);
                int zz0 = Integer.getInteger(z0);

                Employee e0 = new Employee(x0,tt0,zz0);
                emp_list.add(e0);

                // need something here
                break;

            case R.id.btn_modify:
                String x = (String) findViewById(R.id.edit_name).toString();
                String y = (String) findViewById(R.id.edit_age).toString();
                String z = (String) findViewById(R.id.edit_salary).toString();

                int tt = Integer.getInteger(y);
                int zz = Integer.getInteger(z);

                Employee e = new Employee(x,tt,zz);
                break;

            case R.id.btn_delete:
                emp_list.remove(v.getId());
                // need something here
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
