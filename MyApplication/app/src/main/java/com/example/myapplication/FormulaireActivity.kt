package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class FormulaireActivity : AppCompatActivity() {

    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire)


        btn  = findViewById(R.id.button)

        btn.setOnClickListener {
            submit()
        }
    }

    fun submit(){

        var age : EditText = findViewById(R.id.Age)
        var sex : Spinner = findViewById(R.id.sex)
        var Chest_pain_type : Spinner = findViewById(R.id.Chest_pain_type)
        var Resting_Blood_Pressure : EditText = findViewById(R.id.Resting_Blood_Pressure)
        var Serum_Cholestrol : EditText = findViewById(R.id.Serum_Cholestrol)
        var Fasting_Blood_Sugar : EditText = findViewById(R.id.Fasting_Blood_Sugar)
        var Resting_ECG : Spinner = findViewById(R.id.Resting_ECG)
        var Max_heart_rate_achieved: EditText = findViewById(R.id.Max_heart_rate_achieved)
        var Exercise_induced_angina : Spinner = findViewById(R.id.Exercise_induced_angina)
        var ST_depression_induced_by_exercise_relative_to_rest : EditText = findViewById(R.id.ST_depression_induced_by_exercise_relative_to_rest)
        var Peak_exercise_ST_segment : Spinner = findViewById(R.id.Peak_exercise_ST_segment)
        var Number_of_mvcf : EditText = findViewById(R.id.Number_of_mvcf)
        var Thal : Spinner = findViewById(R.id.Thal)


        var v1 : Int = age.text.toString().toInt()
        var v2 : Int = 0
        if(sex.getSelectedItem().toString() == "Man"){v2 = 1}else{v2 = 0}
        var v3 : Int =0
        if(Chest_pain_type.getSelectedItem().toString() == "typical angina"){ v3  = 1}else if(Chest_pain_type.getSelectedItem().toString() == "atypical angina"){ v3  =2}else if(Chest_pain_type.getSelectedItem().toString() == "non -- anginal pain"){ v3 =3}else{ v3  =4}
        var v4 : Int = Resting_Blood_Pressure.text.toString().toInt()
        var v5 : Int = Serum_Cholestrol.text.toString().toInt()
        var v6 : Int =0
        if(Fasting_Blood_Sugar.text.toString().toInt() > 120){v6 = 1}else {v6 = 0}
        var v7 : Int =0
        if(Resting_ECG.getSelectedItem().toString() == ""){ v7  = 0}else if(Resting_ECG.getSelectedItem().toString() == ""){ v7  = 1}else{ v7  = 2}
        var v8 : Int = Max_heart_rate_achieved.text.toString().toInt()
        var v9 : Int = 0
        if( Exercise_induced_angina.getSelectedItem().toString() == "yes" ){ v9 = 1 }else{ v9 = 0}
        var v10 : Float = ST_depression_induced_by_exercise_relative_to_rest.text.toString().toFloat()
        var v11 : Int = 0
        if(Peak_exercise_ST_segment.getSelectedItem().toString() == "upsloping"){ v11 = 1}else if(Peak_exercise_ST_segment.getSelectedItem().toString() == "flat"){ v11 = 2}else{ v11 = 3}
        var v12 : Int = Number_of_mvcf.text.toString().toInt()
        var v13 : Int =0
        if(Thal.getSelectedItem().toString() == "normal"){ v13 = 3 }else if(Thal.getSelectedItem().toString() == "fixed defect"){ v13 = 6 }else { v13 = 7 }






        var intent: Intent = Intent(applicationContext, ResultActivity::class.java)

        intent.putExtra("v1",v1)
        intent.putExtra("v2",v2)
        intent.putExtra("v3",v3)
        intent.putExtra("v4",v4)
        intent.putExtra("v5",v5)
        intent.putExtra("v6",v6)
        intent.putExtra("v7",v7)
        intent.putExtra("v8",v8)
        intent.putExtra("v9",v9)
        intent.putExtra("v10",v10)
        intent.putExtra("v11",v11)
        intent.putExtra("v12",v12)
        intent.putExtra("v13",v13)



        startActivity(intent)

    }

}