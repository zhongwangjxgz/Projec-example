package com.utils.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.example.timedemo.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MyTimePickerDialog extends Dialog{

	Context context;
	PickerView hour_pv, minute_pv;
	List<String> hour = new ArrayList<String>();
	List<String> minute = new ArrayList<String>();
	TextView tp_queren, tp_quxiao;
	public  String hourText ="";
	public  String minuteText = "";
	DialogOnClickListener dialogOnClickListener;
	Dialog dialog;
	private int mHour;
	private int mMinute;

	public MyTimePickerDialog(Context context) {
		super(context);
		this.context = context;
		dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		View view = LayoutInflater.from(context)
				.inflate(R.layout.my_timedialog, null);
		hour_pv = (PickerView) view.findViewById(R.id.hour);
		minute_pv = (PickerView) view.findViewById(R.id.minute);
		tp_queren = (TextView) view.findViewById(R.id.tv_dialog_operation_left);
		tp_quxiao = (TextView) view.findViewById(R.id.tv_dialog_operation_right);

		dialog.setContentView(view);
		dialog.setCancelable(false);
		Window window = dialog.getWindow();
		window.setBackgroundDrawableResource(android.R.color.transparent);
		//�����Զ���timepicker������
		Calendar d = Calendar.getInstance(Locale.CHINA);
		Date myDate = new Date();
		d.setTime(myDate);
		mHour =d.get(Calendar.HOUR_OF_DAY);
		mMinute = d.get(Calendar.MINUTE);
		for (int i = mHour; i < 17; i++) {
			if (i == mHour && mMinute > 30) {

			}else {
				hour.add(i < 10 ? "0" + i : "" + i);
			}

		}
		minute.add("00");
		minute.add("30");
		//		for (int i1 = 10; i1 < mHour; i1++) {
		//			hour.add(Integer.toString(i1));
		//		}
		//		for (int i = 0; i < 60; i++) {
		//			minute.add(i < 10 ? "0" + i : "" + i);
		//		}

		hourText =hour.get(0);
		minuteText = minute.get(0);

		hour_pv.setData(hour);
		minute_pv.setData(minute);

		hour_pv.setOnSelectListener(new PickerView.onSelectListener() {
			@Override
			public void onSelect(String text) {
				hourText = text;
			}
		});
		minute_pv.setOnSelectListener(new PickerView.onSelectListener() {
			@Override
			public void onSelect(String text) {
				minuteText = text;
			}
		});
		/*
		 *���ð�ť����¼�
		 */
		tp_queren.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialogOnClickListener.confirmedDo(hourText, minuteText);
				dismiss();
			}
		});
		tp_quxiao.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});

	}
	//��ť����¼��ӿڣ�������activity����ɹ��ܣ��������timepicker��hour��minute
	public interface DialogOnClickListener {
		public void confirmedDo(String hourText,String minuteText);

	}

	public void setDialogOnClickListener(DialogOnClickListener dialogOnClickListener){
		this.dialogOnClickListener = dialogOnClickListener;
	}
	//������һЩ���÷���
	public String getHourText(){
		return hourText;

	}

	public String getMinuteText(){
		return minuteText;
	}
	public void show() {
		dialog.show();
	}
	public void hide(){
		dialog.hide();
	}
	public void dismiss(){
		dialog.dismiss();
	}

}
