package com.example.igx.problem1;

import android.content.Intent;
import android.hardware.Sensor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /* implements Something1, Something2 */ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        final Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);

        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText(btn_getLocation.getText());

            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_selectedType.setText((btn_getSensors.getText()));
                int x = Sensor.TYPE_GYROSCOPE;
                int xx = Sensor.TYPE_AMBIENT_TEMPERATURE;
                int xxx = Sensor.TYPE_PROXIMITY;
                int xxxx = Sensor.TYPE_LIGHT;

                text_selectedData.setText("자이로 : "+x+"\n온도 : "+xx+"\n근접 : "+xxx+"\n광도 : "+xxxx );


            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+edit_phoneNumber.toString()+""));
                intent.putExtra("sms_body", text_selectedData.getText());
                 startActivity(intent);


            }
        });
    }
}
