package com.projemanag.modules

import android.os.Parcel
import android.os.Parcelable

data class Board(
    val name: String = "",
    val image: String = "",
    val created_by: String = "",
    val assigned_to: ArrayList<String> = ArrayList(),
    var documentID: String = "",
    var taskList: ArrayList<Task> = ArrayList()


) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createStringArrayList()!!,
        parcel.readString()!!,
        parcel.createTypedArrayList(Task.CREATOR)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(created_by)
        parcel.writeStringList(assigned_to)
        parcel.writeString(documentID)
        parcel.writeTypedList(taskList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Board> {
        override fun createFromParcel(parcel: Parcel): Board {
            return Board(parcel)
        }

        override fun newArray(size: Int): Array<Board?> {
            return arrayOfNulls(size)
        }
    }

}