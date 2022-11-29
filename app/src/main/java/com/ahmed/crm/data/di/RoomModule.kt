package com.ahmed.crm.data.di

import android.app.Application
import androidx.room.Room
import com.ahmed.crm.data.local.CustomersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, CustomersDatabase::class.java, "customers_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideDao(db: CustomersDatabase) = db.getCustomerDao()
}