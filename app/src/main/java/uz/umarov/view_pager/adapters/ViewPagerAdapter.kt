package uz.umarov.view_pager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.umarov.view_pager.ViewPagerFragment
import uz.umarov.view_pager.models.MyModel

class ViewPagerAdapter(private val list: ArrayList<MyModel>, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ViewPagerFragment.newInstance(list[position])
    }
}