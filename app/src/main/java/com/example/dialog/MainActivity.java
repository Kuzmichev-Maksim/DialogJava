package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;
    ImageButton dateBtn, timeBtn;
    Button applyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.date_pick_btn);
        timeBtn = findViewById(R.id.time_pick_btn);
        applyBtn = findViewById(R.id.apply_btn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = 2018;
                int month = 9;
                int day = 23;

                DatePickerDialog.OnDateSetListener datePicker  = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateTxt.setText(""+i2+"-"+(i1+1)+"-"+i);
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, R.style.my_date_time_theme, datePicker,year,month,day);
                datePickerDialog.show();
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = 12;
                int minute = 45;
                boolean is24Format = false;

                TimePickerDialog.OnTimeSetListener timePick = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        timeTxt.setText(i+":"+i1);
                    }
                };
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, R.style.my_date_time_theme, timePick,hour,minute,is24Format);
            timePickerDialog.show();
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.my_dialog_theme);
                builder.setTitle("Подтверждение записи")
                    .setIcon(R.drawable.ic_date)
                    .setMessage("Вы подтверждаете свою запись?")

                    .setPositiveButton("Подтвердить",  new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface,  int i) {
                            dialogInterface.cancel();
                            Toast.makeText(MainActivity.this, "Вы записаны", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Отменить", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).create();
                builder.show();
            }
        });
    }
}