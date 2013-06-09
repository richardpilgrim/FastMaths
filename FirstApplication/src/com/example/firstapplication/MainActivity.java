package com.example.firstapplication;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnFragmentClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        MyOtherFragment fragment = new MyOtherFragment();
//        fragmentTransaction.add(R.id.ui_container, fragment);
//        fragmentTransaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    @Override
    public void OnFragmentClick(int action, Object object) {
        switch(action) {
            case 1:
                MyProblemFragment.updateTextBox((String)object);
                break;
            case 2:
                MyProblemFragment.clearTextBox();
                break;
            case 3:
                MySecondFragment.disableDash();
                break;
            case 4:
                MySecondFragment.enableDash();
                break;
            case 5:
                Intent i = new Intent(MainActivity.this, ResultsActivity.class);
                i.putExtra("score", (String)object);
                startActivity(i);

        }
    }
}
