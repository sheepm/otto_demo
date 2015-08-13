package com.example.ottodemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
	private TopFragment topFragment;
	private BottomFragment bottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    
    private void initView() {
    	topFragment = new TopFragment();
    	bottomFragment = new BottomFragment();
    	setFragment(R.id.frame_top, topFragment);
    	setFragment(R.id.frame_bottom, bottomFragment);
	}

	public void setFragment(int id,Fragment fragment){
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	transaction.replace(id, fragment);
    	transaction.commit();
    }
	

    
}
