package com.xyz.app_testbook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.xyz.app_testbook.R
import com.xyz.app_testbook.data.remote.model.Class
import kotlinx.android.synthetic.main.row_live_class.view.*


class PrepAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BotViewHolder) {
            return holder.bind(position)
        }
    }

    //    RecyclerView.Adapter<BotListRecyclerAdapter.BotViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BotViewHolder {
        //To change body of created functions use File | Settings | File Templates.
        return BotViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_live_class,
                parent,
                false
            ), parent.context
        )
    }


    inner class BotViewHolder(itemView: View, context: Context) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(posiiton: Int) {
            val item = getItem(posiiton)
//            https://cdn.testbook.com/images/production/472-X-200-faculty-final_product_facultiesImage_all_1594794875.png
            itemView.tv_course_name.text = item.titles!!
            itemView.tv_live_class.text = item.summary!!.module!!.count!!.video.toString()+"+ Live Classes"
            itemView.tv_questions.text = item.summary!!.module!!.count!!.quiz.toString()+"+ Questions"
            itemView.tv_notes.text = item.summary!!.module!!.count!!.notes.toString()+"+ Notes"

            itemView.iv_course_logo.setColorFilter(R.color.colorPrimary)
//            Glide
//                .with(itemView.context)
//                .load("https:"+item.courseLogo!!)
//                .centerCrop()
//                .placeholder(R.drawable.test_1)
//                .into(itemView.iv_course_logo);
        }
    }


    val arrayList = ArrayList<Class>()
    var word : String = ""


    fun submitList(list: List<Class>) {
        val diffUtil = DiffUtil.calculateDiff(PrepAdapter.DiffUtils(list, arrayList))
        diffUtil.dispatchUpdatesTo(this)
        arrayList.clear()
        arrayList.addAll(list)
//        notifyDataSetChanged()
    }

    fun getItem(position: Int): Class {
        return arrayList.get(position)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }



    class DiffUtils(val newList: List<Class>, val oldList: ArrayList<Class>) :
        DiffUtil.Callback() {
        val currentGson = Gson()
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return newList.get(newItemPosition) == oldList.get(oldItemPosition)
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val result =
                currentGson.toJson(newList.get(newItemPosition))
                    .compareTo(currentGson.toJson(oldList.get(oldItemPosition)))
            if (result == 0) {
                return true
            }
            return false
        }

        override fun getOldListSize(): Int {
            return if (oldList != null) oldList.size else 0
        }

        override fun getNewListSize(): Int {
            return if (newList != null) newList.size else 0
        }

    }



}
