package com.example.animbird;





import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
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
public class MainActivity extends Activity implements OnTouchListener{
	private ImageView Puppyimageview;                       // The letter that the user drags.	             
	private AbsoluteLayout mainLayout;	
	private static final String DEBUG_TAG = "MyActivity";
	TranslateAnimation Puppyanimation;
	ImageView[] image;
	int point=-1;

	final Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		mainLayout = (AbsoluteLayout) findViewById(R.id.container);
		mainLayout.setOnTouchListener(this);
		Puppyimageview = (ImageView) findViewById(R.id.puppy);
		Puppyimageview.setOnTouchListener(this);
		image = new ImageView[10];
		image[0] = (ImageView)findViewById(R.id.imageView1);
		image[1] = (ImageView)findViewById(R.id.imageView2);
		image[2] = (ImageView)findViewById(R.id.imageView3);
		image[3] = (ImageView)findViewById(R.id.imageView4);
		image[4] = (ImageView)findViewById(R.id.imageView5);
		image[5] = (ImageView)findViewById(R.id.imageView6);
		image[6] = (ImageView)findViewById(R.id.imageView7);
		image[7] = (ImageView)findViewById(R.id.imageView8);
		image[8] = (ImageView)findViewById(R.id.imageView9);
		image[9] = (ImageView)findViewById(R.id.imageView10);
		for(int i=0;i<=9;i++)
			image[i].setOnTouchListener(this);
		///animation for sitting dog
		Puppyimageview.setBackgroundResource(R.anim.dogsit);
		final AnimationDrawable sitAnimation = (AnimationDrawable) Puppyimageview.getBackground();
		Puppyimageview.post(new Runnable() {
		    public void run() {
		        if ( sitAnimation != null ) sitAnimation.start();
		      }
		});

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
	private boolean dragging = false;
	@SuppressLint("NewApi")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		boolean eventConsumed = true;
		int x = (int)event.getX();
		int y = (int)event.getY();
		System.out.println("x value " + x );
		System.out.println("y value " + y );

		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) 
		{

			for (int i=0;i<=9;i++)
			{
				if (v == image[i]) {
					point=i;
					System.out.println(" image"+i+i+i+i+i+i+i+i+i+i+"is clicked");												
					dragging = true;
					eventConsumed = false;
				}
			}

		}
		else if (action == MotionEvent.ACTION_UP) 
		{
			if(point==0)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X-20,0,-Y-180);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==1)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==2)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==3)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==4)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==5)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==6)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==7)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==8)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			if(point==9)
			{
				int X = (int) image[0].getX();
				int Y = (int) image[0].getY();
				Puppyanimation = new TranslateAnimation(0,X,0,-Y-220);
				Puppyanimation.setDuration(2000);
				Puppyimageview.startAnimation(Puppyanimation);												
			}
			



		} else if (action == MotionEvent.ACTION_MOVE) 
		{

		}	
		return eventConsumed;
	}




}
