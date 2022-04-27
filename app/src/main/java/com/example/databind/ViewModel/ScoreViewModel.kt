package com.example.databind.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore:Int):ViewModel() {

    private val scoretext = MutableLiveData<Int>()
    val score: LiveData<Int> get() = scoretext

    val playAgain = MutableLiveData<Boolean>()
    val play: LiveData<Boolean> get() = playAgain
    init {
        Log.i("final score", "final score $finalScore")

    }
   fun onPlayAgain() {
//        play.value = true
    }

   fun onPlayAgainComplete() {
//        play.value = false
    }
}