package com.example.recyclerview.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialFlowerList = flowerList(resources)
    private val flowersLiveData = MutableLiveData(initialFlowerList)

    // add flower data
    fun addFlower(flower: Flower){
        val currentList = flowersLiveData.value
        if(currentList == null){
            flowersLiveData.postValue(listOf(flower))
        }else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, flower)          // 맨 앞에 추가
            flowersLiveData.postValue(updatedList)
        }
    }

    // delete flower data
    fun removeFlower(flower: Flower) {
        val currentList = flowersLiveData.value
        if(currentList != null){
            val updatedList = currentList.toMutableList()
            updatedList.remove(flower)          // 아이템 삭제
            flowersLiveData.postValue(updatedList)
        }
    }

    fun getFlowerForId(id: Long): Flower? {
        flowersLiveData.value?.let { flowers ->
            return flowers.firstOrNull{it.id == id}
        }
        return null
    }

    fun getFlowerList(): LiveData<List<Flower>>{
        return flowersLiveData
    }

    fun getRandomFlowerImageAsset() : Int? {
        val randomNum = (initialFlowerList.indices).random()
        return initialFlowerList[randomNum].image
    }

    companion object{
        private var INSTANCE: DataSource? = null;

        fun getDataSource(resources: Resources) : DataSource{
            return synchronized(DataSource::class){
                val newInstant = INSTANCE?: DataSource(resources)
                INSTANCE = newInstant
                newInstant
            }
        }
    }

}