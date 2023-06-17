package com.d3if3005.yummytime.viewmodel

import androidx.lifecycle.*
import com.d3if3005.yummytime.repository.MainRepository
import com.d3if3005.yummytime.response.CategoriesListResponse
import com.d3if3005.yummytime.response.FoodsListResponse
import com.d3if3005.yummytime.utils.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _randomFood: MutableLiveData<List<FoodsListResponse.Meal>> = MutableLiveData()
    val randomFood: LiveData<List<FoodsListResponse.Meal>>
        get() = _randomFood


    fun getRandomFood() = viewModelScope.launch {
        repository.getRandomFood().collect {
            _randomFood.value = it.body()?.meals!!
        }
    }


    private val _categoriesList: MutableLiveData<DataStatus<CategoriesListResponse>> = MutableLiveData()
    val categoriesList: LiveData<DataStatus<CategoriesListResponse>>
        get() = _categoriesList

    fun getCategoriesList() = viewModelScope.launch {
        repository.getCategoriesList().collect {
            _categoriesList.value = it
        }
    }

    val filtersListData = MutableLiveData<MutableList<Char>>()
    fun loadFilterList() = viewModelScope.launch {
        val letters = listOf('A'..'Z').flatten().toMutableList()
        filtersListData.value = letters
    }

    private val _foodList: MutableLiveData<DataStatus<FoodsListResponse>> = MutableLiveData()
    val foodList: LiveData<DataStatus<FoodsListResponse>>
        get() = _foodList

    fun getFoodsList(letter: String) = viewModelScope.launch {
        repository.getFoodsList(letter).collect {
            _foodList.value = it
        }
    }

    fun getFoodBySearch(letter: String) = viewModelScope.launch {
        repository.getFoodsBySearch(letter).collect {  _foodList.value = it }
    }

    fun getFoodByCategory(letter: String) = viewModelScope.launch {
        repository.getFoodsByCategory(letter).collect {  _foodList.value = it }
    }


}