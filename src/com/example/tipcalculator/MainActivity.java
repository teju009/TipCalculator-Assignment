package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick10(View v){
		EditText inputAmount = (EditText) findViewById(R.id.inputAmount);
		TextView resultValue = (TextView) findViewById(R.id.resultValue);
		tipCalculation(inputAmount, resultValue, 0.1);
	}
	
	public void onClick15(View v){
		EditText inputAmount = (EditText) findViewById(R.id.inputAmount);
		TextView resultValue = (TextView) findViewById(R.id.resultValue);
		tipCalculation(inputAmount, resultValue, 0.15);
	}
	
	public void onClick20(View v){
		EditText inputAmount = (EditText) findViewById(R.id.inputAmount);
		TextView resultValue = (TextView) findViewById(R.id.resultValue);
		tipCalculation(inputAmount, resultValue, 0.2);
	}
	
	private void tipCalculation(EditText inputAmount, TextView resultValue, double multiplier){
		String amountText = inputAmount.getText().toString();
		double result;
		if(validation(amountText)){
			double amount = Double.parseDouble(amountText);
			result = amount * multiplier;
			resultValue.setVisibility(View.VISIBLE);
            resultValue.setText("Tip is: $" + String.valueOf(result));
		}
		else{
			Toast.makeText(getBaseContext(), "Invalid Amount, Enter Again", Toast.LENGTH_SHORT).show();
		}
		inputAmount.setText("");
	}
	
	private boolean validation(String amountText){
		try {
            double temp = Double.parseDouble(amountText);
		} catch (NumberFormatException nfe) {
			
			return false;
		}
		return true;
	}

}
