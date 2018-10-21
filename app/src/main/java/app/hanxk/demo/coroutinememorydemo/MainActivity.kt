package app.hanxk.demo.coroutinememorydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import app.hanxk.demo.coroutinememorydemo.data.AddressDao
import app.hanxk.demo.coroutinememorydemo.data.MyDataBase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showCount()
    }

    private fun showCount() = launch {
        // var count = async(Dispatchers.IO) {MyDataBase.getInstance().addressDao().getTotalCount()  }.await()     // no memory leak
        var count =
            withContext(Dispatchers.IO) { MyDataBase.getInstance().addressDao().getTotalCount() } // memory leak
        tvCount.text = count.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
