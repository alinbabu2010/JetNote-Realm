package com.compose.jetnote.di

import com.compose.jetnote.data.db.entity.NoteEntity
import com.compose.jetnote.data.model.Note
import com.compose.jetnote.utils.DataToEntityMapper
import com.compose.jetnote.utils.EntityToDataMapper
import com.compose.jetnote.utils.Mapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface AppModule {

    @Singleton
    @Binds
    fun bindDataToEntityMapper(
        dataToEntityMapper: DataToEntityMapper
    ): Mapper<Note, NoteEntity>

    @Singleton
    @Binds
    fun bindEntityToDataMapper(
        entityToDataMapper: EntityToDataMapper
    ): Mapper<NoteEntity, Note>

}