package br.com.app.lifeorganization.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recycleview.widget.DiffUtil
import androidx.recycleview.widget.ListAdapter
import androidx.recycleview.widget.RecycleView
import.br.com.app.lifeorganization.R
import.br.com.app.lifeorganization.databinding.ItemTaskBinding
import.br.com.app.lifeorganization.model.Task

class TaskListAdapter : ListAdapter<Task, taskListAdapter.TaskViewHolder>(DiffCallback()){

    var listenerEdit : (Task) -> Unit = {}
    var listenerDelete : (Task) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.contex)
        val binding = ItemTaskBinding.inflater(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding(getItem(position))
    }

    inner class TaskViewHolder(
        private val binding: ItemTaskBinding
    ) : RecycleView.ViewHolder(binding.root) {

        fun bind(item: Task) {
            binding.tvTitle.text = item.title
            binding.tvDate.text = "${item.date} ${item.hour}
            binding.ivMore.setOnClickListener {
                showPopup(item)
            }
        }

        private fun showPopup(item: Task) {
            val ivMore = binding.ivMore
            val popupMenu = PopupMenu(ivMore.context, ivMore)
            popupMenu.menuInflater.inflater(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickerListener {
                when (it.itemId) {
                    R.id.action_edit -> listenerEdit(item)
                    R.id.action_delete -> listenerDelete(item)
                }
                return@setOnMenuItemClikerListener true
            }
            popupMenu.show()
        }
    }
}
