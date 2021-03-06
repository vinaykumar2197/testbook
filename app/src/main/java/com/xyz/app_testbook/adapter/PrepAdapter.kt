package com.xyz.app_testbook.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.xyz.app_testbook.R
import com.xyz.app_testbook.data.remote.model.Class
import com.xyz.app_testbook.local.UserSharedPrefs

import kotlinx.android.synthetic.main.row_live_class.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


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

            if(item.classInfo!!.classFeature!!.features!!.size>=5) {
                itemView.tv_live_class.text =
                    item.classInfo!!.classFeature!!.features!![0].count.toString() + "+ Live Classes"
                itemView.tv_questions.text =
                    item.classInfo!!.classFeature!!.features!![3].count.toString() + "+ Questions"
                itemView.tv_notes.text =
                    item.classInfo!!.classFeature!!.features!![2].count.toString() + "+ Notes"
            }
            else{
                itemView.tv_live_class.text = item.summary!!.module!!.count!!.liveClasses.toString()+"+ Live Classes"
                itemView.tv_questions.text = item.summary!!.module!!.count!!.quiz.toString()+"+ Questions"
                itemView.tv_notes.text = item.summary!!.module!!.count!!.notes.toString()+"+ Notes"
            }

//            itemView.iv_course_logo.setColorFilter(R.color.colorPrimary)

            if(posiiton%2==0) {
                drawPath(itemView,"#FF8E4326" , "#FFA84E2C", "#FFA04B2C")
            }
            else{
                drawPath(itemView, "#525d7b","#4f5a77" , "#4b5168")
            }
            var userSharedPrefs: UserSharedPrefs =   UserSharedPrefs.getSharedPref(itemView.context)
            var numberOfDays = daysDiff( userSharedPrefs.getCurrentDate()!!,item.releaseDate!!)

            if(numberOfDays.equals("0")){
                itemView.tv_starts_in.visibility = GONE
            }
            else{
                itemView.tv_starts_in.visibility = VISIBLE
                itemView.tv_starts_in.text = "Starts in $numberOfDays Day"

            }
            Glide
                .with(itemView.context)
//                .load("https:"+item.courseLogo!!)
                .load("https:"+item.classInfo!!.facultiesImage)
                .placeholder(R.drawable.test_1)
                .into(itemView.iv_course_logo);
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




    fun drawPath(itemView : View,backgroundColor : String , leftColor : String,bottomColor: String ){
        // draw circle on canvas and get bitmap
        val bitmap = drawCircle(
            radius = 300f,
//            canvasBackground = Color.parseColor("#FF77381F")
            canvasBackground = Color.parseColor(backgroundColor),
            leftColor = leftColor,
            bottomColor = bottomColor

        )

        // show drawing on image view
        itemView.iv_card_bg.setImageBitmap(bitmap)
    }

    // function to draw circle on canvas
    fun drawCircle(
        bitmapWidth:Int = 1500,
        bitmapHeight:Int = 900,
        radius:Float = 1500f/3,
        cx:Float = bitmapWidth / 2f,
        cy:Float = bitmapHeight / 1.25f,
        canvasBackground:Int = Color.WHITE,
        leftColor : String,bottomColor: String
    ): Bitmap {
        val bitmap = Bitmap.createBitmap(
            bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888
        )

        // canvas to draw circle
        val canvas = Canvas(bitmap).apply {
            drawColor(canvasBackground)
        }

        // paint to draw on canvas
        val paint = Paint().apply {
            //            this.color = color
//            this.color = Color.parseColor("#FFA04B2C")
            this.color = Color.parseColor(leftColor)
            isAntiAlias = true
        }

        val paint1 = Paint().apply {
//            this.color = Color.parseColor("#FFA84E2C")
            this.color = Color.parseColor(bottomColor)
            isAntiAlias = true
        }




        canvas.drawCircle(
            0f, // x-coordinate of the center of the circle
            520f, // y-coordinate of the center of the circle
            bitmapWidth/1.5f, // radius of the circle
            paint1 // paint used to draw the circle
        )

        // draw circle on canvas
        canvas.drawCircle(
            bitmapWidth/1.25f, // x-coordinate of the center of the circle
            bitmapHeight/1f, // y-coordinate of the center of the circle
            bitmapWidth/2.4f, // radius of the circle
            paint // paint used to draw the circle
        )

//        val rectF = RectF(50f, 20f, 100f, 80f)
//        // draw circle on canvas
//        canvas.drawArc(
//            rectF,
//            180f, 135f, true,
//            paint // paint used to draw the circle
//        )

        return bitmap
    }


    fun daysDiff(currentDate : String , finalDate : String ) : String {
        var dayDifference : String = "0"
        try {
            var date1: Date
            var date2: Date
//            var dates = SimpleDateFormat("MM/dd/yyyy")
//            2020-07-27T10:34:28.012Z
            var dates = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            date1 = dates.parse(currentDate.replace("T"," "))
            date2 = dates.parse(finalDate.replace("T"," "))
            var difference: Long = Math.abs(date1.getTime() - date2.getTime())
            var differenceDates = difference / (24 * 60 * 60 * 1000)
            dayDifference = differenceDates.toInt().toString()
//            textView.setText("The difference between two dates is $dayDifference days")
        } catch (exception: Exception) {
//            Toast.makeText(this, "Unable to find difference", Toast.LENGTH_SHORT).show()
        }
        return dayDifference
    }


}
