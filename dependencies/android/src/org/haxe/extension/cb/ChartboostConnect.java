package org.haxe.extension.cb;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.chartboost.sdk.*;
import org.haxe.extension.Extension;
import org.haxe.lime.HaxeObject;


public class ChartboostConnect extends Extension 
{
        private static String appID = "::ENV_ChartboostID::"; 
        private static String appSignature = "::ENV_ChartboostSignature::"; 
        
        private static Chartboost cb;
        
        @Override public void onCreate (Bundle savedInstanceState)
        {
			if(ChartboostConnect.appID == "null" || ChartboostConnect.appSignature == "null")
			{
				 Log.e("ChartboostConnect","APP ID AND/OR APP SIGNATURE HAVE NOT BEEN SET, set your app id in your project.xml file like this: <setenv name='ChartboostID' value='your id' /> <setenv name='ChartboostSignature' name='your app signature' /> ");
				return;
			}
            ChartboostConnect.cb = Chartboost.sharedChartboost();
            ChartboostConnect.cb.onCreate(Extension.mainActivity, ChartboostConnect.appID, ChartboostConnect.appSignature, null);
        }
        

        @Override public void onStart()
        {
            super.onStart();
            ChartboostConnect.cb.onStart(Extension.mainActivity);
            ChartboostConnect.cb.startSession();
        }   
        
        @Override public void onStop() 
        {
            super.onStop();
            ChartboostConnect.cb.onStop(Extension.mainActivity);
        }
        
        @Override public void onDestroy() 
        {
            super.onDestroy();
            ChartboostConnect.cb.onDestroy(Extension.mainActivity);
        }

        public static void cacheAd()
        {
            if (ChartboostConnect.cb != null)
            {
                ChartboostConnect.cb.cacheInterstitial(); 
            }
        }

        public static boolean hasCachedAd() {
           if (ChartboostConnect.cb != null)
            {
                return ChartboostConnect.cb.hasCachedInterstitial(); 
            } 
            return false;
        } 
        
        public static void showAd()
        {
            if(ChartboostConnect.cb != null)
            {
                ChartboostConnect.cb.showInterstitial(); 
            }
        }
        
        
        

        
        
        
        
        
}
