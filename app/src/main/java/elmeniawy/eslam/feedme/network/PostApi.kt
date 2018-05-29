package elmeniawy.eslam.feedme.network

import elmeniawy.eslam.feedme.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * PostApi
 * The interface which provides methods to get result of webservices.
 *
 * Created by Eslam El-Meniawy on 29-May-2018.
 * CITC - Mansoura University
 */
interface PostApi {
    /**
     * Get the list of the pots from the API.
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}