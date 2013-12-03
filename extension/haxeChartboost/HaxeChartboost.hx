package extension.haxeChartboost;


import flash.events.EventDispatcher;
import flash.events.Event;
import flash.net.SharedObjectFlushStatus;
import flash.net.SharedObject;
import flash.Lib;

#if android
import openfl.utils.JNI;
#end


@:allow(extension.haxeChartboost) class HaxeChartboost 
{
	#if android
	static var showAdFunc;
	static var cacheAdFunc;
	static var hasCachedAdFunc;
	#end
	
	public static function showInterstitial():Void
	{
		#if android
		trace("ATTEMPTING TO CREATE FUNCTION FOR CHARTBOOST");
		if (showAdFunc == null)
		{
			showAdFunc = JNI.createStaticMethod("org/haxe/extension/cb/ChartboostConnect", "showAd", "()V");
		}
		showAdFunc();
		#end
		
		#if ios
			cb_show_interstitial();
		#end
	}

	public static function cacheInterstitial():Void {
		#if android
			if (cacheAdFunc == null)
			{	
				cacheAdFunc = JNI.createStaticMethod("org/haxe/extension/cb/ChartboostConnect", "cacheAd", "()V");
			}			
			cacheAdFunc();
		#end

		#if ios
			cb_cache_interstitial();
		#end
	}

	public static function hasCachedInterstitial():Bool {
		#if android
			if (hasCachedAdFunc == null)
			{	
				hasCachedAdFunc = JNI.createStaticMethod("org/haxe/extension/cb/ChartboostConnect", "hasCachedAd", "()Z");
			}			
			return hasCachedAdFunc();
		#end

		#if ios
			return cb_has_cached_interstitial();
		#end
	}
	
	
	public static function init(appID:String, appSignature:String)
	{
		#if ios
			cb_init(appID, appSignature);
		#end
		
		#if android
		
		#end
	}

	
	#if ios
	static var cb_init               = Lib.load("ruechartboost","cb_init",2);
	static var cb_show_interstitial  = Lib.load("ruechartboost","cb_show_interstitial", 0);
	static var cb_cache_interstitial  = Lib.load("ruechartboost","cb_cache_interstitial", 0);
	static var cb_has_cached_interstitial = Lib.load("ruechartboost", "cb_has_cached_interstitial", 0);
	#end
	
	
}
