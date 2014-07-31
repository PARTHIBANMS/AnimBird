package com.example.animbird;


import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.os.Build;

@SuppressWarnings({ "deprecation", "unused" })
@SuppressLint({ "ClickableViewAccessibility", "NewApi" })
public class MainActivity extends Activity implements AnimationListener, OnTouchListener{
	private ImageView letterView;                       // The letter that the user drags.
	private ImageView emptyLetterView;              // The letter outline that the user is supposed to drag letterView to.
	private AbsoluteLayout mainLayout;
	public Animation animSequential;
	TranslateAnimation translateanimate;
	private static final String DEBUG_TAG = "MyActivity";
	
	final Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		


		mainLayout = (AbsoluteLayout) findViewById(R.id.container);
		mainLayout.setOnTouchListener(this);
		letterView = (ImageView) findViewById(R.id.letterView);
		letterView.setOnTouchListener(this);
		letterView = (ImageView) findViewById(R.id.letterView);

		final Button btnOpenPopup = (Button)findViewById(R.id.openpopup);
		
		

		btnOpenPopup.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View arg0) 
			{

				LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE); 

				View popupView = layoutInflater.inflate(R.layout.popup, null); 

				final PopupWindow popupWindow = new PopupWindow( popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  

				popupWindow.showAtLocation(popupView, Gravity.CLIP_VERTICAL, 0, 0);

				Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);

				btnDismiss.setOnClickListener(new Button.OnClickListener()
				{

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						popupWindow.dismiss();
					}});

				popupWindow.showAsDropDown(btnOpenPopup, 50, -30);

			}});
	}


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

	@SuppressLint("NewApi")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		boolean eventConsumed = true;
		int x = (int)event.getX();
		int y = (int)event.getY();
		System.out.println("x value " + x );
		System.out.println("y value " + y );

		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
//			if (v == letterView) {
//				//letterView.setImageResource(R.drawable.ic_launcher);
//				//	dragging = true;
//				eventConsumed = false;
//			}
//			
//
//			setAbsoluteLocationCentered(letterView, x, y);
//			
//
//
//			// load the animation
//			animSequential = AnimationUtils.loadAnimation(getApplicationContext(),
//					R.anim.flyingbird);
//
//			// set animation listener
//			animSequential.setAnimationListener(this);
//
//			letterView.startAnimation(animSequential);
//
//			System.out.println("Animation running");
			
			int a = (int)event.getX();
			int b = (int)event.getY();
			
			
			translateanimate = new TranslateAnimation(0,a,0,b);
			
//			handler.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//
//				// Do something after 5s = 5000ms
//			
//				
//				// load the animation
//				animSequential = AnimationUtils.loadAnimation(getApplicationContext(),
//						R.anim.move);
//
//				// set animation listener
//				animSequential.setAnimationListener(this);
//
//				letterView.startAnimation(animSequential);
//
//				System.out.println("Animation move running");
//
//			}
//		}, 3000);
		


			
			

			


		} else if (action == MotionEvent.ACTION_UP) {

//			int a = (int)event.getX();
//			int b = (int)event.getY();
//			
//			
//			translateanimate = new TranslateAnimation(0,a,0,b);
			
			//letterView.drawImage(puppy, a, b, this);

			
			
//			if (v != letterView) {
//				 boolean dragging = false;
//				if (dragging) {
//					setAbsoluteLocationCentered(letterView, x, y);
//				}
//			}

//			letterView.setPivotX(x);
//			letterView.setPivotY(y);


			//		letterView.setVisibility (View.INVISIBLE);			
			//		System.out.println("Animation stopped");




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
//					if (v != letterView) {
//						if (dragging) {
//							setAbsoluteLocationCentered(letterView, x, y);
//						}
//					}
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
	@Override
	public void onAnimationEnd(Animation animation) {
		// Take any action after completing the animation

		// check for zoom in animation
		if (animation == animSequential) {
		}

	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

}
