package app.hanxk.demo.coroutinememorydemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.hanxk.demo.coroutinememorydemo.R
import app.hanxk.demo.coroutinememorydemo.data.Address
import app.hanxk.demo.coroutinememorydemo.data.AddressDao
import app.hanxk.demo.coroutinememorydemo.data.MyDataBase
import kotlinx.android.synthetic.main.frag_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailFragment : Fragment(){

  val addressDao: AddressDao by lazy(LazyThreadSafetyMode.NONE) {
    MyDataBase.getInstance().addressDao()
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.frag_detail, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    btnAdd.setOnClickListener {
    }
    showCount()
  }

  private fun showCount() {
    (activity as CoroutineScope).launch(Dispatchers.Main) {
      var count = 0
      withContext(Dispatchers.IO) {
        count = addressDao.getTotalCount()
      }
      tvCount.text = count.toString()
    }
  }

//  private fun handle() {
//    GlobalScope.launch(Dispatchers.Main) {
//      addOne()
//    }
//  }
//
//  private suspend fun addOne() {
//    withContext(Dispatchers.IO) {
//      addressDao.insert(Address(text = "哈哈 ${System.currentTimeMillis()}"))
//    }
//  }

//  private suspend fun getCount(): Int {
//    val count = GlobalScope.async(Dispatchers.IO) { addressDao.getTotalCount() }.await()
//    return count
//  }

  override fun onDestroy() {
    super.onDestroy()
  }

}