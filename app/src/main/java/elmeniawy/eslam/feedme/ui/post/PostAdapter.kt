package elmeniawy.eslam.feedme.ui.post

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import elmeniawy.eslam.feedme.R
import elmeniawy.eslam.feedme.databinding.ItemPostBinding
import elmeniawy.eslam.feedme.model.Post

/**
 * PostAdapter
 * Adapter for the list of the posts.
 *
 * @property context Context in which the application is running.
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */
class PostAdapter(private val context: Context) :
        RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    // The list of posts of the adapter.
    private var posts: List<Post> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val binding: ItemPostBinding = DataBindingUtil
                .inflate(layoutInflater,
                        R.layout.item_post,
                        parent,
                        false)

        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    /**
     * Updates the list of posts of the adapter.
     *
     * @param posts the new list of posts of the adapter.
     */
    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter.
     *
     * @property binding the DataBinging object for Post item.
     */
    class PostViewHolder(private val binding: ItemPostBinding) :
            RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a post into the view.
         */
        fun bind(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }
}