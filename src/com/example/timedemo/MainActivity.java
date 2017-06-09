package com.example.timedemo;

import com.utils.view.MyTimePickerDialog;
import com.utils.view.PickerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView show;
	protected MyTimePickerDialog mydialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		show = (TextView)findViewById(R.id.show);
		show.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mydialog = new MyTimePickerDialog(MainActivity.this);
				mydialog.setDialogOnClickListener(new MyTimePickerDialog.DialogOnClickListener() {

					@Override
					public void confirmedDo(String hourText, String minuteText) {
						// TODO Auto-generated method stub
						show.setText(mydialog.getHourText() + ":" + mydialog.getMinuteText());
					}
				});
				mydialog.show();
			}
		});
	}
}
