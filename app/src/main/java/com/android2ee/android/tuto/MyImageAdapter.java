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
* Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br>
* Sa propriété intellectuelle appartient à la société <strong>ST Informatique Services</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* Pour tous renseignements (Conseil, Expertise, Formations J2EE ou Android, Prestations, Forfaits):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Les meilleurs des Ingénieurs Java-J2EE nous rejoignent pour participer avec nous à la grande aventure</br>
* de l’informatique des prochaines décennies.</br>
* N'hésitez pas à nous contacter.</br>
* *****************************************************************************************************************</br>
* com.android2ee.android.tuto</br>
* 25 mars 2011</br>
*/
package com.android2ee.android.tuto;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Gallery.LayoutParams;

/**
 * @author (Julien PAPUT sous la direction du Dr. Mathias Séguy)
 * @goals This class aims to:
 *        <ul>
 *        <li>This class init the Gallery , and permit to retrieve the user selected item</li>
 *        </ul>
 */
public class MyImageAdapter extends BaseAdapter {
    private final Context mContext;

    
    //references to our images
    private final Integer[] mThumbIds = {
    		R.drawable.ic_android2ee_blc, R.drawable.ic_android2ee_bleu,
            R.drawable.ic_android2ee_orange, R.drawable.ic_android2ee_violet,
            R.drawable.ic_android2ee_blc_inv, R.drawable.ic_android2ee_bleu_inv,
            R.drawable.ic_android2ee_orange_inv, R.drawable.ic_android2ee_violet_inv
    };
    
    /**
     * Constructor
     * @param c
     */
    public MyImageAdapter(Context c) {
        mContext = c;
    }

    @Override
	public int getCount() {
        return mThumbIds.length;
    }

    @Override
	public Object getItem(int position) {
    	return mThumbIds[position];
    }

    @Override
	public long getItemId(int position) {
    	//As there is no data base plugged on the ImageAdapter,
    	//You should not return ItemId.
    	//The itemId is in fact the URI id of the item when you are using database or ContentProvider
    	//see associated chapter to understand what an item id is.
    	return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        // if it's not recycled, initialize some attributes
        if (convertView == null) { 
            imageView = new ImageView(mContext);
            Gallery.LayoutParams params = new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(params);            
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(15, 0, 15, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

 }

	