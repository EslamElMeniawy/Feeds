package elmeniawy.eslam.feedme.ui.post

import elmeniawy.eslam.feedme.R
import elmeniawy.eslam.feedme.base.BasePresenter
import elmeniawy.eslam.feedme.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * PostPresenter
 * The Presenter that will present the Post view.
 *
 * @param postView the Post view to be presented by the presenter.
 * @property postApi the API interface implementation.
 * @property subscription the subscription to the API call.
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */
class PostPresenter(postView: PostView) : BasePresenter<PostView>(postView) {
    @Inject
    lateinit var postApi: PostApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    /**
     * Loads the posts from the API and presents them in the view when retrieved, or shows error if
     * any.
     */
    private fun loadPosts() {
        view.showLoading()

        subscription = postApi
                .getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { postList -> view.updatePosts(postList) },
                        { view.showError(R.string.unknown_error) }
                )
    }
}