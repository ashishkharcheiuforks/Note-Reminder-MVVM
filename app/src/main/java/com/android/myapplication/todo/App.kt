package com.android.myapplication.todo

import android.app.Application
import com.android.myapplication.todo.data.db.NotesDataBase
import com.android.myapplication.todo.repositories.NotesRepository
import com.android.myapplication.todo.ui.HomeViewPagerViewModel
import com.android.myapplication.todo.ui.list.NotesListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App :Application(){
    private val koinModule= module{
        single {
            //Database
            NotesDataBase.getInstance(androidContext())
        }
        single{
            val noteDb:NotesDataBase = get()
            NotesRepository(noteDb.notesDao)
        }

        viewModel { HomeViewPagerViewModel() }



    }


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(koinModule)
        }
    }
}