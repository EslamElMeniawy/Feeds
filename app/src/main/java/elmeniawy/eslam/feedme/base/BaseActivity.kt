package elmeniawy.eslam.feedme.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * BaseActivity
 * All Activity classes of rosso must extend. It provides required methods and presenter
 * instantiation and calls.
 *
 * @param P the type of the presenter the Activity is based on.
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */
abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    /**
     * Instantiates the presenter the Activity is based on.
     */
    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }
}