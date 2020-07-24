package com.xyz.app_testbook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.xyz.app_testbook.R


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

            itemView.tv_conversation_details.text = "${item.id} : ${item.activityName}"

//            holder.cardView.setOnLongClickListener(OnLongClickListener { false })

            itemView.ll_list.setOnClickListener  {
                (itemView.context as ConversationSelectorActivity).startChatActivity(item.id.toString())
            }

        }
    }


    val arrayList = ArrayList<ConversationListModel>()
    var word : String = ""


    fun submitList(list: List<ConversationListModel>) {
        val diffUtil = DiffUtil.calculateDiff(ConversationListAdapter.DiffUtils(list, arrayList))
        diffUtil.dispatchUpdatesTo(this)
        arrayList.clear()
        arrayList.addAll(list)
//        notifyDataSetChanged()
    }

    fun getItem(position: Int): ConversationListModel {
        return arrayList.get(position)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }



    class DiffUtils(val newList: List<ConversationListModel>, val oldList: ArrayList<ConversationListModel>) :
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
