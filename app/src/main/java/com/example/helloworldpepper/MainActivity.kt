package com.example.helloworldpepper

import android.os.Bundle
import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.`object`.conversation.Say
import com.aldebaran.qi.sdk.builder.SayBuilder
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class MainActivity : RobotActivity(),RobotLifecycleCallbacks {

    private val tag = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(tag,"onCreate")

        QiSDK.register(this,this)
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        Log.d(tag,"onRobotFocusGained")

        val say : Say = SayBuilder.with(qiContext)
            .withText("Willkommen zum Rechenspiel")
            .build()

        say.run()
    }

    override fun onRobotFocusLost() {
        Log.d(tag,"onRobotFocusLost")
    }

    override fun onRobotFocusRefused(reason: String?) {
        Log.d(tag,"onRobotFocusRefused")
    }

    override fun onDestroy() {
        Log.d(tag,"onDestroy")
        QiSDK.unregister(this,this)
        super.onDestroy()
    }
}
