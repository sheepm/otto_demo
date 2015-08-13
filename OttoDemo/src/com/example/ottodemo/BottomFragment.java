package com.example.ottodemo;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomFragment extends Fragment{
	
	private View view;
	private TextView mTextView;
	private Bus bus;
	
	@Override
	public void onAttach(Activity activity) {
		bus = BusProvider.getInstance();
		bus.register(this);
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.frag_bottom, container, false);
		mTextView = (TextView) view.findViewById(R.id.bottom_text);
		return view;
	}

	@Subscribe
	public void setText(UserInfo textstring) {
		String user = textstring.getUsername();
		String psd = textstring.getPassword();
		StringBuffer buffer = new StringBuffer();
		buffer.append("username:").append(user).append(" password:").append(psd);
		mTextView.setText(buffer);
	}
}
