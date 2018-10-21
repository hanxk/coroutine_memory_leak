package app.hanxk.demo.coroutinememorydemo

import android.app.Application
import app.hanxk.demo.coroutinememorydemo.data.MyDataBase
import com.squareup.leakcanary.LeakCanary

class MyApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) {
      LeakCanary.install(this)
    }
    MyDataBase.initialize(this)
  }

}