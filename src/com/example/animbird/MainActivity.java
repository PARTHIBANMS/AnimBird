package com.example.animbird;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.os.Build;

@SuppressWarnings({ "deprecation", "unused" })
@SuppressLint("ClickableViewAccessibility")
public class MainActivity extends Activity implements OnTouchListener{
	private ImageView letterView;                       // The letter that the user drags.
	private ImageView emptyLetterView;              // The letter outline that the user is supposed to drag letterView to.
	private AbsoluteLayout mainLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainLayout = (AbsoluteLayout) findViewById(R.id.container);
		mainLayout.setOnTouchListener(this);
		letterView = (ImageView) findViewById(R.id.letterView);
		letterView.setOnTouchListener(this);

		//emptyLetterView = (ImageView) findViewById(R.id.emptyLetterView);
//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//			.add(R.id.container, new PlaceholderFragment()).commit();
//		}
	}
	private boolean dragging = false;
	private Rect hitRect = new Rect();

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container,
//					false);
//			return rootView;
//		}
//	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		boolean eventConsumed = true;
		int x = (int)event.getX();
		int y = (int)event.getY();

		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			if (v == letterView) {
				//letterView.setImageResource(R.drawable.ic_launcher);
				dragging = true;
				eventConsumed = false;
			}
			
			setAbsoluteLocationCentered(letterView, x, y);
			
		} else if (action == MotionEvent.ACTION_UP) {
			

			//		if (dragging) {
			//			emptyLetterView.getHitRect(hitRect);
			//			if (hitRect.contains(x, y)) {
			//				letterView.setImageResource(R.drawable.ic_launcher);
			//				setSameAbsoluteLocation(letterView, emptyLetterView);
			//			}
			//		}
			//		dragging = false;
			//		eventConsumed = false;

		} else if (action == MotionEvent.ACTION_MOVE) {
			//		if (v != letterView) {
			//			if (dragging) {
			//				setAbsoluteLocationCentered(letterView, x, y);
			//			}
			//		}
		}

		return eventConsumed;
	}
	private void setSameAbsoluteLocation(View v1, View v2) {
		AbsoluteLayout.LayoutParams alp2 = (AbsoluteLayout.LayoutParams) v2.getLayoutParams();
		setAbsoluteLocation(v1, alp2.x, alp2.y);
	}


	private void setAbsoluteLocationCentered(View v, int x, int y) {
		setAbsoluteLocation(v, x - v.getWidth() / 2, y - v.getHeight() / 2);
	}


	private void setAbsoluteLocation(View v, int x, int y) {
		AbsoluteLayout.LayoutParams alp = (AbsoluteLayout.LayoutParams) v.getLayoutParams();
		alp.x = x;
		alp.y = y;
		v.setLayoutParams(alp);
	}

}
