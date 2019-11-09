package br.com.vinimanara.chatboardapp.utils

import android.app.Activity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object FlexTracker {
    fun trackScreen(activity: Activity, screenName: String) {
        if (screenName != ScreenMap.SCREEN_NOT_TRACKING) {
            //Log.i("ANALYTICS", screenName)
            val mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity)
            mFirebaseAnalytics.setCurrentScreen(activity, screenName, null)
        }
    }
    fun trackEvent(activity: Activity, bundle: Bundle) {
        val mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity)
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}