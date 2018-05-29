package elmeniawy.eslam.feedme.injection.component

import dagger.BindsInstance
import dagger.Component
import elmeniawy.eslam.feedme.base.BaseView
import elmeniawy.eslam.feedme.injection.module.ContextModule
import elmeniawy.eslam.feedme.injection.module.NetworkModule
import elmeniawy.eslam.feedme.ui.post.PostPresenter
import javax.inject.Singleton

/**
 * PresenterInjector
 * Component providing inject() methods for presenters.
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     *
     * @param postPresenter PostPresenter in which to inject the dependencies.
     */
    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}