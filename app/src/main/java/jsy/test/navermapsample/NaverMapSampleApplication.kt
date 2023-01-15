package jsy.test.navermapsample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NaverMapSampleApplication : Application() {

    companion object {
        lateinit var instance: NaverMapSampleApplication

        /**
         * singleton 애플리케이션 객체를 얻는다.
         *
         * @return singleton 애플리케이션 객체
         */
        @JvmStatic
        fun getGlobalApplicationContext(): NaverMapSampleApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}