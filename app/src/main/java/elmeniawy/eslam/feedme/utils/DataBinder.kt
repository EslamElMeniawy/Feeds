// Safe here as method are used by Data binding
@file:Suppress("unused")

package elmeniawy.eslam.feedme.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import elmeniawy.eslam.feedme.ui.post.PostAdapter

/**
 * DataBinder
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */

/**
 * Sets an adapter to a RecyclerView (to be used in view with one RecyclerView).
 *
 * @param view the RecyclerView on which to set the adapter.
 * @param adapter the adapter to set to the RecyclerView.
 */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: PostAdapter) {
    view.adapter = adapter
}

/**
 * Sets a LayoutManager to a RecyclerView (to be used in view with one RecyclerView).
 *
 * @param view the RecyclerView on which to set the LayoutManager.
 * @param layoutManager the LayoutManager to set to the RecyclerView.
 */
@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

/**
 * Adds a DividerItemDecoration to a RecyclerView (to be used in view with one RecyclerView).
 *
 * @param view the RecyclerView on which to set the DividerItemDecoration.
 * @param dividerItemDecoration the DividerItemDecoration to set to the RecyclerView.
 */
@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}
