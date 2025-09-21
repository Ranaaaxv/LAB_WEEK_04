package vanessa.umn.lab_week_04

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)
class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val context: Context) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }
    override fun createFragment(position: Int): Fragment
    {
        val contentRes = when (position) {
            0 -> R.string.starbucks_desc
            1 -> R.string.janjijiwa_desc
            2 -> R.string.kopikenangan_desc
            else -> R.string.starbucks_desc
        }
        val content = context.getString(contentRes)
        return CafeDetailFragment.newInstance(content)
    }
}