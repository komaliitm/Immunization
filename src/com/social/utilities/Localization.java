package com.social.utilities;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.*;

public class Localization  {
	
public static  int ENGLISH_SELECTOR=1;
public static  int HINDI_SELECTOR=2;

public static void setLanguage(Context context,String language,Locale activityLocale)

{
	Resources res=context.getResources();
	DisplayMetrics dm=res.getDisplayMetrics();
    Configuration conf=res.getConfiguration();
    activityLocale=new Locale(language);	
    conf.locale=activityLocale;
    res.updateConfiguration(conf,dm);	
}

public static boolean isLocaleChanged(Context context,Locale activityLocale)
{
	
	boolean result=false;
	Resources res=context.getResources();
    Configuration conf=res.getConfiguration();
    Locale locale=conf.locale;	
    
    if (!locale.toString().equals(activityLocale.toString())) {
		result=true;
	}
return result;
}

	
	
	
}
