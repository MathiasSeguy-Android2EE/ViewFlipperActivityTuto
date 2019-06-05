/**
* <ul>
* Android Tutorial, An <strong>Android2EE</strong>'s project.</br>
* Produced by <strong>Dr. Mathias SEGUY</strong> with the smart contribution of <strong>Julien PAPUT</strong>.</br>
* Delivered by <strong>http://android2ee.com/</strong></br>
* Belongs to <strong>Mathias Seguy</strong></br>
* ****************************************************************************************************************</br>
* This code is free for any usage but can't be distribute.</br>
* The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
* The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* For any information (Advice, Expertise, J2EE or Android Training, Rates, Business):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
* Sa distribution est reservÃ©e au site <strong>http://android2ee.com</strong>.</br>
* Sa propriÃ©tÃ© intellectuelle appartient Ã  la sociÃ©tÃ© <strong>ST Informatique Services</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* Pour tous renseignements (Conseil, Expertise, Formations J2EE ou Android, Prestations, Forfaits):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Les meilleurs des IngÃ©nieurs Java-J2EE nous rejoignent pour participer avec nous Ã  la grande aventure</br>
* de lâ€™informatique des prochaines dÃ©cennies.</br>
* N'hÃ©sitez pas Ã  nous contacter.</br>
* *****************************************************************************************************************</br>
* com.android2ee.android.tuto</br>
* 25 mars 2011</br>
*/
package com.android2ee.android.tuto;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ViewFlipperActivityTuto extends Activity {
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/
	
	String like = null;
	Integer selectedItem = null;
	
	/************ Layout 1 ****************/
	
	/**  The chocolate RadioButton */
	RadioButton radioButtonChocolate;
	/**  The hug RadioButton */
	RadioButton radioButtonHug;
	/**  The Santa RadioButton */
	RadioButton radioButtonSanta;
	/** the button of the first layout */
	Button selectButton;
	
	/************ Layout 2 ****************/
	
	//The gallery
	private Gallery gallery;
	//The ImageAdapter
	private MyImageAdapter imageAdapter;
	//the ViewFlipper
	
	/************ Layout 3 ****************/
	TextView choice;
	ImageButton avatar;
	
	/************ ViewFlipper *************/
	ViewFlipper viewFlipper;
	//the previous button
	Button previous;
	//the next button
	Button next;
	private Resources resources;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /******************************************************************************************/
		/** RadioButton instanciation *************************************************************/
		/******************************************************************************************/
        // Instanciate the radio buttons for the first radioGroup
        radioButtonChocolate = (RadioButton)findViewById(R.id.chocolate);
        radioButtonHug = (RadioButton)findViewById(R.id.hug);
        radioButtonSanta = (RadioButton)findViewById(R.id.santaclaus);
        selectButton = (Button) findViewById(R.id.selectlike);
        
              
        //load the project'sresources 
        resources = getResources();
        
        /******************************************************************************************/
		/** ViewFlipper instanciation *************************************************************/
		/******************************************************************************************/
    	viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
    	viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_push_right_in));
    	viewFlipper.setOutAnimation(this, R.anim.anim_push_right_out);
    	previous = (Button) findViewById(R.id.previous);
    	next = (Button) findViewById(R.id.next);
    	
    	/******************************************************************************************/
		/** Galery instanciation ******************************************************************/
		/******************************************************************************************/
        gallery = (Gallery) findViewById(R.id.myGallery);
        
        /******************************************************************************************/
		/** Layout 3 instanciation ******************************************************************/
		/******************************************************************************************/
        choice = (TextView) findViewById(R.id.myChoice);
        choice.setText(getString(R.string.no_choice));
        //default avatar
        avatar = (ImageButton)findViewById(R.id.myAvatar);
        avatar.setBackgroundDrawable(resources.getDrawable(R.drawable.ic_android2ee_bleu));
        
        //use the MyImageAdapter
        imageAdapter=new MyImageAdapter(this);
        //Set it to the gallery
        gallery.setAdapter(imageAdapter);
        
    	//On previous button click
    	previous.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			//switch image to the previous
    			viewFlipper.showPrevious();
    		}
    	});
    	
    	//On next button click
    	next.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			//switch image to the next
    			viewFlipper.showNext();	
    		}
    	});
    	
    	//On selectButton push (first layout)
    	selectButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Implement the text message for the stuffs "i like"
				if(radioButtonChocolate.isChecked()){
					//if the chocolate radioButton is checked, add "Chocolate" to the string
					choice.setText(getString(R.string.choice) + getString(R.string.chocolate));
				}else if(radioButtonHug.isChecked()){
					//if the Hug radioButton is checked, add "Hug" to the string
					choice.setText(getString(R.string.choice) + getString(R.string.hug));
				}else if(radioButtonSanta.isChecked()){		
					//if the Santa Claus radioButton is checked, add "Santa Claus" to the string
					choice.setText(getString(R.string.choice) + getString(R.string.santaclaus));
				}							
			}			
		});
    	
    	//Call when an element of the GridView is selected (second layout)
        gallery.setOnItemClickListener(new OnItemClickListener(){
        	//Display image selected by user
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				avatar.setBackgroundDrawable(resources.getDrawable((Integer)imageAdapter.getItem(position)));	
			}

        });      
        
    }
}