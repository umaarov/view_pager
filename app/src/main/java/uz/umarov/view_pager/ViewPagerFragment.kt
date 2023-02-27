package uz.umarov.view_pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.umarov.view_pager.databinding.FragmentViewPagerBinding
import uz.umarov.view_pager.models.MyModel

private const val ARG_PARAM1 = "param1"

class ViewPagerFragment : Fragment() {
    private var param1: MyModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as MyModel
        }
    }

    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)

        val url = param1?.img

        if (url != null) {
            binding.showImage.setImageResource(url)
        }

        return binding.root
    }

    companion object {

        fun newInstance(param1: MyModel) =
            ViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}