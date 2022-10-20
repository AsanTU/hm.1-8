package com.dacha.taskmanager1.ui.onBoarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dacha.taskmanager1.R
import com.dacha.taskmanager1.data.onBoard
import com.dacha.taskmanager1.databinding.ItemOnboardBinding

class onBoardingAdapter : RecyclerView.Adapter<onBoardingAdapter.onBoardingViewHolder>() {
    private val array = arrayListOf<onBoard>(
        onBoard(title = "Title = 1" , "desc=1" , R.drawable.daigo),
        onBoard(title = "Title = 2" , "desc=2" , R.drawable.daigo),
        onBoard(title = "Title = 3" , "desc=3" , R.drawable.daigo)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(ItemOnboardBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount() = array.size

    inner class onBoardingViewHolder(private val binding:ItemOnboardBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(onBoard: onBoard) {
            binding.textTitle.text = onBoard.title
            binding.textDesc.text = onBoard.desc
            //Glide.with(binding.ImageView).load(onBoard.image).into(binding.ImageView)
            binding.ImageView.setImageResource(R.drawable.james)
            if (array.lastIndexOf(onBoard) == array.lastIndex) {
                binding.btnStart.visibility = View.VISIBLE
            } else {
                binding.btnStart.visibility = View.INVISIBLE
            }

        }
    }

}