package com.androidhive.texttospeech;

import java.util.Locale;
import java.util.Random;
import com.example.animbird.R;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AndroidTextToSpeechActivity extends Activity implements
		TextToSpeech.OnInitListener {
	/** Called when the activity is first created. */

	private TextToSpeech tts;
	private Button btnSpeak;
	private EditText txtText;
	int min = 1;
	int max = 100;

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tts = new TextToSpeech(this, this);

		btnSpeak = (Button) findViewById(R.id.btnSpeak);

		txtText = (EditText) findViewById(R.id.txtText);

		// button on click event
		btnSpeak.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				speakOut();
			}

		});
	}
	
								public static int randInt(int min, int max) {
							
								    // NOTE: Usually this should be a field rather than a method
								    // variable so that it is not re-seeded every call.
								    Random rand = new Random();
							
								    // nextInt is normally exclusive of the top value,
								    // so add 1 to make it inclusive
								    int randomNum = rand.nextInt((max - min) + 1) + min;
							
								    return randomNum;
								}
	

	@Override
	public void onDestroy() {
		// Don't forget to shutdown!
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			// tts.setPitch(5); // set pitch level

			// tts.setSpeechRate(2); // set speech speed rate

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Language is not supported");
			} else {
				btnSpeak.setEnabled(true);
				speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed");
		}

	}

	private void speakOut() {
		
//		txtText.setText("Random Number: " + Math.random());

		String text = txtText.getText().toString();

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		
		

		
	}
}