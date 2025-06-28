package com.mohamed.myapplication.ui.users

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.domain.entity.UserEntity
import com.mohamed.domain.entity.UserGender
import com.mohamed.myapplication.databinding.ItemUserBinding

class UserAdapter : ListAdapter<UserEntity, UserAdapter.UserViewHolder>(DiffCallback()) {

    inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(user: UserEntity) {
            binding.tvName.text = "Name: ${user.name}"
            binding.tvTitle.text = "Title : ${user.title}"
            binding.tvAge.text = "Age: ${user.age}"
            binding.tvGender.text = "Gender: ${UserGender.toValue(user.gender)}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: UserViewHolder, position: Int): Unit =
        holder.bind(getItem(position))


    class DiffCallback : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(old: UserEntity, new: UserEntity): Boolean = old.id == new.id
        override fun areContentsTheSame(old: UserEntity, new: UserEntity): Boolean = old == new
    }
}
