package com.dacha.taskmanager1.ui.onBoarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dacha.taskmanager1.R
import com.dacha.taskmanager1.data.onBoard
import com.dacha.taskmanager1.databinding.ItemOnboardBinding

class onBoardingAdapter(private val onClick : () -> Unit) : RecyclerView.Adapter<onBoardingAdapter.onBoardingViewHolder>() {
    private val array = arrayListOf<onBoard>(
        onBoard(title = "Title = 1" , "desc=1" , R.drawable.ic_launcher_background),
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
            binding.ImageView.setImageResource(R.drawable.ic_launcher_background)
            binding.btnStart.isVisible = adapterPosition == array.lastIndex
            binding.textSkip.isVisible = adapterPosition != array.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
            binding.textSkip.setOnClickListener{
                onClick()
            }

        }
    }

}