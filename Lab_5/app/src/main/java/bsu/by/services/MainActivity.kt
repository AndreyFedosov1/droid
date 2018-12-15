package bsu.by.services

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(){
    private var model: MainActivityViewModel=MainActivityViewModel()
    private var messageService=MessageService();
    private var isMessageServiceBound:Boolean=false;
    private var serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            isMessageServiceBound=false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder:MessageService.MessageServiceBinder = service as MessageService.MessageServiceBinder
            messageService=binder.getService()
            isMessageServiceBound=true
            messageService.sendMessage("-Hello There!\n -General Kenobi!")
        }
    }

    var messageReceiver:BroadcastReceiver=object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val message:String = "Message from service: " + intent?.getStringExtra("msg")
            val toast:Toast=Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT)
        toast.show()
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        model.Get_isMainServiceBinded().observe(this,isBindedChanged)

        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver,IntentFilter("main_activity_toast"))
    }

    private var isBindedChanged=object :Observer<Boolean>{
        override fun onChanged(t: Boolean?) {
            val tv:TextView = findViewById(R.id.textView2)
            if(t!=null&&t){
                tv.text="State_binded"
            }
            else{
                tv.text = "State-unbinded"
            }
        }
    }

    fun onBindMainServiceClick(view:View){
        val intent: Intent = Intent(this,MessageService::class.java);
        model.Set_isMainServiceBinded(true)
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE)
    }

    fun onUnBindMessageServiceClick(view:View){
        if(isMessageServiceBound){
            val intent:Intent = Intent(this,MessageService::class.java)
            model.Set_isMainServiceBinded(false)
            unbindService(serviceConnection)
            isMessageServiceBound=false
        }
    }



}
