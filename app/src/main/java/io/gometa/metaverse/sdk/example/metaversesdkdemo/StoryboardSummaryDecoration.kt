package io.gometa.metaverse.sdk.example.metaversesdkdemo

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *
 */
class StoryboardSummaryDecoration(
    context: Context
) : RecyclerView.ItemDecoration() {

    private val horizontalMargin = context.resources
        .getDimensionPixelSize(R.dimen.card_margin_horizontal)
    private val verticalMargin = context.resources
        .getDimensionPixelSize(R.dimen.card_margin_vertical)
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        outRect.set(horizontalMargin, verticalMargin, horizontalMargin,
            if (itemPosition == parent.adapter.itemCount - 1) verticalMargin else 0)
    }
}