package io.gometa.metaverse.sdk.example.metaversesdkdemo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.gometa.sdk.Result
import io.gometa.sdk.model.StoryboardSummary
import kotlinx.android.synthetic.main.view_storyboard_summary.view.*

/**
 *
 */
class StoryboardSummaryAdapter : RecyclerView.Adapter<StoryboardSummaryAdapter.ViewHolder>() {

    interface StoryboardSummaryClickListener {
        fun onReloadStoryboard(storyboardId: String)
        fun onLaunchStoryboard(storyboardId: String)
    }

    private val keys = ArrayList<String>()
    private val values = ArrayList<Result<StoryboardSummary>>()

    var storyboardSummaryClickListener: StoryboardSummaryClickListener? = null

    operator fun set(storyboardId: String, result: Result<StoryboardSummary>) {
        val index = keys.indexOf(storyboardId)
        if (index == -1) {
            // New entry
            keys.add(storyboardId)
            values.add(result)
            notifyItemInserted(keys.size - 1)
        } else {
            // Entry replaced
            values[index] = result
            notifyItemChanged(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.view_storyboard_summary, parent, false))

    override fun getItemCount(): Int = keys.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(keys[position], values[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val loadingGoneViews: Array<View> =
            arrayOf(itemView.error_icon, itemView.error_text, itemView.icon,
                itemView.title, itemView.description, itemView.reload)
        private val errorVisibleViews: Array<View> =
            arrayOf(itemView.error_icon, itemView.error_text, itemView.reload)
        private val errorGoneViews: Array<View> =
            arrayOf(itemView.spinner, itemView.icon, itemView.title,  itemView.description)
        private val successGoneViews: Array<View> =
                arrayOf(itemView.spinner, itemView.error_icon, itemView.error_text, itemView.reload)

        fun bind(storyboardId: String, result: Result<StoryboardSummary>) {
            when (result) {
                is Result.Success -> bindSuccess(result.data)
                is Result.Error -> bindError(storyboardId)
                is Result.Loading -> bindLoading()
            }
        }

        private fun bindSuccess(summary: StoryboardSummary) {
            successGoneViews.forEach { it.visibility = View.GONE }
            itemView.icon.visibility = View.VISIBLE
            Glide.with(itemView)
                .load(summary.iconUrl)
                .into(itemView.icon)
            itemView.title.apply {
                visibility = View.VISIBLE
                text = summary.name ?: "**Untitled Storyboard**"
            }
            summary.description?.let {
                itemView.description.apply {
                    visibility = View.VISIBLE
                    text = it
                }
            } ?: run {
                itemView.description.visibility = View.GONE
            }
            itemView.cardview.setOnClickListener {
                storyboardSummaryClickListener?.onLaunchStoryboard(summary.storyboardId)
            }
        }

        private fun bindError(storyboardId: String) {
            errorVisibleViews.forEach { it.visibility = View.VISIBLE }
            errorGoneViews.forEach {it.visibility = View.GONE }
            itemView.reload.setOnClickListener {
                storyboardSummaryClickListener?.onReloadStoryboard(storyboardId)
            }
            itemView.cardview.setOnClickListener(null)
        }

        private fun bindLoading() {
            itemView.spinner.visibility = View.VISIBLE
            loadingGoneViews.forEach { it.visibility = View.GONE }
            itemView.cardview.setOnClickListener(null)
        }

    }
}