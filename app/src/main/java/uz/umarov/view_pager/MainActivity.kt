package uz.umarov.view_pager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.umarov.view_pager.adapters.ViewPagerAdapter
import uz.umarov.view_pager.databinding.ActivityMainBinding
import uz.umarov.view_pager.models.MyModel

class MainActivity : AppCompatActivity() {

    lateinit var list: ArrayList<MyModel>
    lateinit var adapter: ViewPagerAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        adapter = ViewPagerAdapter(list, supportFragmentManager)

        binding.myTab.setupWithViewPager(binding.viewPager)

        binding.viewPager.adapter = adapter

        binding.btnNext.setOnClickListener {
            binding.viewPager.setCurrentItem(binding.viewPager.currentItem + 1, true)
        }

        binding.imgNext.setOnClickListener {
            binding.viewPager.setCurrentItem(binding.viewPager.currentItem + 1, true)
        }

        binding.btnSkip.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadData() {
        list = ArrayList()

        list.add(MyModel(R.drawable.image_one))
        list.add(MyModel(R.drawable.image_two))
        list.add(MyModel(R.drawable.image_three))
        list.add(MyModel(R.drawable.image_four))
    }
}
