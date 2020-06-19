package com.example.noteapps.db

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteData(
    var noteTitle: String?,
    var noteDescription: String?
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var noteID: Int = 0

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(noteTitle)
        writeString(noteDescription)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NoteData> = object : Parcelable.Creator<NoteData> {
            override fun createFromParcel(source: Parcel): NoteData =
                NoteData(source)
            override fun newArray(size: Int): Array<NoteData?> = arrayOfNulls(size)
        }
    }
}