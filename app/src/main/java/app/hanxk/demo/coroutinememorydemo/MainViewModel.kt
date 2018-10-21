package app.hanxk.demo.coroutinememorydemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.hanxk.demo.coroutinememorydemo.data.MyDataBase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel : ViewModel(), CoroutineScope {
  private val job = Job()
  override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

  val countData = MutableLiveData<Int>()

  init {
    showCount()
  }

  private fun showCount() {
    launch {
      var count = withContext(Dispatchers.IO) { MyDataBase.getInstance().addressDao().getTotalCount() }
      countData.value = count
    }
  }

  override fun onCleared() {
    super.onCleared()
    job.cancel()
  }
}