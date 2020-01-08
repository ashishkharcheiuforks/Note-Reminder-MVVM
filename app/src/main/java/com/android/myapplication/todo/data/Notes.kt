package com.android.myapplication.todo.data

import android.accounts.AuthenticatorDescription
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey @ColumnInfo(name = "noteId") var id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "completed") var isCompleted: Boolean = false
){
    val titleForNoteList:String
    get() = if(title.isNotEmpty()) title else description

    val isActive
    get() = !isCompleted

    val isEmpty
    get() = title.isEmpty() || description.isEmpty()

    val photoFileName
    get() = "IMG_$id.jpg"

}