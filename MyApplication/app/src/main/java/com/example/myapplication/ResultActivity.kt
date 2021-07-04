package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.ml.HeartDisease
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class ResultActivity : AppCompatActivity() {

    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var textView : TextView  = findViewById(R.id.textView)


        var myintent :  Intent = intent

        val v1 = myintent.getIntExtra("v1",0)
        val v2 = myintent.getIntExtra("v2",0)
        val v3 = myintent.getIntExtra("v3",0)
        val v4 = myintent.getIntExtra("v4",0)
        val v5 = myintent.getIntExtra("v5",0)
        val v6 = myintent.getIntExtra("v6",0)
        val v7 = myintent.getIntExtra("v7",0)
        val v8 = myintent.getIntExtra("v8",0)
        val v9 = myintent.getIntExtra("v9",0)
        val v10 = myintent.getFloatExtra("v10",0.0f)
        val v11 = myintent.getIntExtra("v11",0)
        val v12 = myintent.getIntExtra("v12",0)
        val v13 = myintent.getIntExtra("v13",0)


        var byteBuffer : ByteBuffer =  ByteBuffer.allocateDirect(4*13)
        byteBuffer.putInt(v1)
        byteBuffer.putInt(v2)
        byteBuffer.putInt(v3)
        byteBuffer.putInt(v4)
        byteBuffer.putInt(v5)
        byteBuffer.putInt(v6)
        byteBuffer.putInt(v7)
        byteBuffer.putInt(v8)
        byteBuffer.putInt(v9)
        byteBuffer.putFloat(v10)
        byteBuffer.putInt(v11)
        byteBuffer.putInt(v12)
        byteBuffer.putInt(v13)

        val model = HeartDisease.newInstance(this)

        // Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 13), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

        if(outputFeature0[0].toString() == "1.0"){
            textView.setText("you have Heart Disease")
        }else{
            textView.setText("you don't have Heart Disease")
        }



        // Releases model resources if no longer used.
        model.close()


    }
}