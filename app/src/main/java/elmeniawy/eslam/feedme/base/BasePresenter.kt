package elmeniawy.eslam.feedme.base

import elmeniawy.eslam.feedme.injection.component.DaggerPresenterInjector
import elmeniawy.eslam.feedme.injection.component.PresenterInjector
import elmeniawy.eslam.feedme.injection.module.ContextModule
import elmeniawy.eslam.feedme.injection.module.NetworkModule
import elmeniawy.eslam.feedme.ui.post.PostPresenter

/**
 * BasePresenter
 * Any presenter of the application must extend. It provides initial injections and
 * required methods.
 *
 * @param V the type of the View the presenter is based on.
 * @property view the view the presenter is based on.
 * @property injector The injector used to inject required dependencies.
 * @constructor Injects the required dependencies.
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    /**
     * The injector used to inject required dependencies
     */
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created.
     */
    open fun onViewCreated() {}

    /**
     * This method may be called when the presenter view is destroyed.
     */
    open fun onViewDestroyed() {}

    /**
     * Injects the required dependencies.
     */
    private fun inject() {
        when (this) {
            is PostPresenter -> injector.inject(this)
        }
    }
}