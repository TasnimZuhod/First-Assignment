package com.example.firstassignment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	int random;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        random = (int) (Math.random() * (1000 - 0)) + 0;
        
        final EditText edtxt = (EditText) findViewById(R.id.editText1);
        
        Button gnrate = (Button) findViewById(R.id.button1);
        
        gnrate.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		String value = edtxt.getText().toString();
        		
        		if( value.equals("") )
        			print("You must enter a value");
        		else if( !isNumeric(value) )
        			print("You must enter a numeric value");
        		else{
        			int toGuess = Integer.parseInt( value );
        			guess(toGuess);
        		}
                
        	}
        });
        
    }
    
    
    public void guess(int toGuess){
    	
    	if( random-5 <= toGuess && toGuess <= random+5 )
    		print("Very Close");
    	else if( toGuess > random+5 )
    		print("Greater");
    	else if( toGuess < random-5 )
    		print("Smaller");
    	
    }
    
    
    public boolean isNumeric( String input ){
       try{
          Integer.parseInt( input );
          return true;
       }
       catch( Exception e){
          return false;
       }
    }
    
    
    public void print(String msg){
    	Toast.makeText(getBaseContext(), msg ,Toast.LENGTH_LONG).show();
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
}
