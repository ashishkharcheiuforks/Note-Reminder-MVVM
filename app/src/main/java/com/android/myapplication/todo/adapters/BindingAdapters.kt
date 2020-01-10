package com.android.myapplication.todo.adapters

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.todo.R
import com.android.myapplication.todo.data.Notes
import com.bumptech.glide.Glide

@BindingAdapter("notesList")
fun RecyclerView.submitList(notes: List<Notes>?) {
    val adapter = this.adapter as NotesListAdapter
    adapter.submitList(notes)
}

@BindingAdapter("placeHolder")
fun ImageView.placeholderImage(drawable: Drawable?){
    Glide.with(this.context).load(drawable).into(this)
}

@BindingAdapter("displayIsFavorite")
fun ImageView.displayImage(isFavorite:Boolean?) {
    isFavorite?.let {
        if (it) {
            setImageDrawable(this.context.getDrawable(R.drawable.ic_favorite_active))
        } else {
            setImageDrawable(this.context.getDrawable(R.drawable.ic_favorite_inactive))
        }
    }
}

