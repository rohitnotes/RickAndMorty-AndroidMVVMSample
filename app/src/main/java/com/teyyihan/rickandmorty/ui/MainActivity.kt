/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teyyihan.rickandmorty.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.teyyihan.rickandmorty.MainApplication
import com.teyyihan.rickandmorty.R
import com.teyyihan.rickandmorty.databinding.ActivityMainBinding
import com.teyyihan.rickandmorty.model.CharacterQueryModel
import com.teyyihan.rickandmorty.ui.main.QueryBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity(), QueryBottomSheet.BottomSheetListener {

    private lateinit var binding: ActivityMainBinding
    private val mainViewmodel by viewModels<MainActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.mainActivityToolbar)

        /**
         *  Dark and Light modes are following system default.
         *  Manual selection will be implemented in further versions via toolbar menu
         */
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_appbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(applicationContext,"Will be implemented",Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

    /**
     *  Interface - Listener mechanism for passing bottom sheet query data. Shared Viewmodels also can be used.
     */
    override fun queryButtonClicked(query: CharacterQueryModel?) {
        // Set shared viewmodel variable value to new query. It will be listened from main fragment
        mainViewmodel.query.postValue(query)
    }




}
