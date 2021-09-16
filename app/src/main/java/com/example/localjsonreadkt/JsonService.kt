package com.example.localjsonreadkt

import android.content.Context
import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.util.ArrayList

class JsonService(context:Context) {

    lateinit var dataModelList: ArrayList<Data>
    var contexthere: Context=context

    fun loadJSONFromAssets(fileName: String): String {
        return contexthere.assets.open(fileName).bufferedReader().use { reader ->
            reader.readText()
        }
    }


    fun bindJSONDataInFacilityList() {
        dataModelList = ArrayList<Data>()
        val jsonObject = JSONObject(loadJSONFromAssets("data.json")) // Extension Function call here
        val jsonArraylist=jsonObject.getJSONArray("data")
        for (i in 0 until jsonArraylist.length()){
            val dataModel = Data()
            val dataJSONObject = jsonArraylist.getJSONObject(i)
            dataModel.name = dataJSONObject.getString("name")
            dataModel.age = dataJSONObject.getString("age")
            dataModelList.add(dataModel)
        }


    }




}