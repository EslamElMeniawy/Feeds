package elmeniawy.eslam.feedme.base

import android.content.Context

/**
 * BaseView
 * Any view must implement.
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */
interface BaseView {
    /**
     * Returns the context in which the application is running.
     * @return the context in which the application is running.
     */
    fun getContext(): Context
}