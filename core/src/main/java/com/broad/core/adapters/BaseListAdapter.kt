package com.broad.core.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<M : Any?, VB : ViewDataBinding>(
    private val inflate: (LayoutInflater, ViewGroup, Boolean) -> VB,
    diffCallback: DiffUtil.ItemCallback<M>? = null
) : ListAdapter<M, BaseListAdapter.ViewHolder<VB>>(diffCallback ?: DefaultDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> {
        val binding = inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder<VB>, position: Int) {
        val model = getItem(position)
        holder.bind(model, position) { binding, item, pos ->
            onBindData(binding, item, pos)
        }
    }

    abstract fun onBindData(binding: VB, model: M?, adapterPosition: Int)

    class ViewHolder<VB : ViewDataBinding>(private val binding: VB) : RecyclerView.ViewHolder(binding.root) {
        fun <M : Any?> bind(model: M?, position: Int, onBind: (VB, M?, Int) -> Unit) {
            onBind(binding, model, position)
            binding.executePendingBindings()
        }
    }

    class DefaultDiffCallback<M : Any?> : DiffUtil.ItemCallback<M>() {
        override fun areItemsTheSame(oldItem: M & Any, newItem: M & Any): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: M & Any, newItem: M & Any): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        fun <M : Any?> diffCallback(
            areItemsSame: (oldItem: M?, newItem: M?) -> Boolean,
            areContentsSame: (oldItem: M?, newItem: M?) -> Boolean
        ): DiffUtil.ItemCallback<M> = object : DiffUtil.ItemCallback<M>() {
            override fun areItemsTheSame(oldItem: M & Any, newItem: M & Any): Boolean {
                return areItemsSame(oldItem, newItem)
            }
            override fun areContentsTheSame(oldItem: M & Any, newItem: M & Any): Boolean {
                return  areContentsSame(oldItem, newItem)
            }
        }
    }
}