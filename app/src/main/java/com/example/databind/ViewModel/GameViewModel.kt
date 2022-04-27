package com.example.databind.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val wordtext= MutableLiveData<String>()
    val word:LiveData<String> get()=wordtext
    val scoretext= MutableLiveData<Int>()
    val score:LiveData<Int> get()=scoretext
    val endscore= MutableLiveData<Boolean>()
    val endpoint:LiveData<Boolean> get() = endscore




    private lateinit var wordList: MutableList<String>
    private  fun resetList(){
        wordList= mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    init {
        wordtext.value = ""
        scoretext.value = 0
        resetList()
        nextWord()
        Log.i("gameViewModel","created game model")

    }

    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()

        } else {
            //Select and remove a _word from the list
            wordtext.value = wordList.removeAt(0)
        }
    }

    private fun onGameFinish() {
        endscore .value = true
    }

    fun onGameFinishComplete() {
        endscore.value = false
    }




    fun onSkip(){
        scoretext.value = (scoretext.value)?.minus(1)
        nextWord()
    }
    fun onCorrect(){
        scoretext.value = (scoretext.value)?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("gameViewModel","created game model")
    }
}
