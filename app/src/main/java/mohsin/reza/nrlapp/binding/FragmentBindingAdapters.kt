package mohsin.reza.nrlapp.binding

import android.databinding.BindingAdapter
import android.support.v4.app.Fragment
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import mohsin.reza.nrlapp.R
import javax.inject.Inject

class FragmentBindingAdapters @Inject constructor(internal val fragment: Fragment) {
    @BindingAdapter("circleImageUrl")
    fun bindCircleImage(imageView: ImageView, url: String) { //to bind dynamic url in recyclerView

        val context = fragment.activity!!.applicationContext
        val requestOption = RequestOptions().centerCrop().error(R.mipmap.headshot_error)

        Glide.with(context)
                .load(url)
                .apply(requestOption)
                .into(imageView)
    }
}
