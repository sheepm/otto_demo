package com.example.ottodemo;

import com.squareup.otto.Bus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TopFragment extends Fragment implements OnClickListener {

	private View view;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;

	private Bus bus;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		bus = BusProvider.getInstance();
		bus.register(this);
		view = inflater.inflate(R.layout.frag_top, container, false);
		initView();
		initEvent();
		return view;
	}

	private void initEvent() {
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
	}

	private void initView() {
		button1 = (Button) view.findViewById(R.id.button1);
		button2 = (Button) view.findViewById(R.id.button2);
		button3 = (Button) view.findViewById(R.id.button3);
		button4 = (Button) view.findViewById(R.id.button4);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			bus.post(new UserInfo("admin","admin"));
			break;
		case R.id.button2:
			bus.post(new UserInfo("user","123456"));
			break;
		case R.id.button3:
			bus.post(new UserInfo("32525","abc"));
			break;
		case R.id.button4:
			bus.post(new UserInfo("asdasd","25252"));
			break;

		}
	}
}
