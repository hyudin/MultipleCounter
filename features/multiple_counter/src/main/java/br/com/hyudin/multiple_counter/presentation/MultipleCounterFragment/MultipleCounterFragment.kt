package br.com.hyudin.multiple_counter.presentation.MultipleCounterFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import br.com.hyudin.multiple_counter.R
import br.com.hyudin.multiple_counter.databinding.FragmentMultiplecounterBinding
import br.com.hyudin.multiple_counter.di.model.Counter

class MultipleCounterFragment: Fragment(R.layout.fragment_multiplecounter) {

    private lateinit var binding: FragmentMultiplecounterBinding
    private val viewModel: MultipleCounterViewModel by viewModels()
    private lateinit var adapter: MultipleCounterAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMultiplecounterBinding.inflate(layoutInflater)

        val counter = Counter(name = "Counter", description = "desc", count = 0)
        val arraylist = ArrayList<Counter>()
        arraylist.add(counter)
        adapter = MultipleCounterAdapter(listOfCounters = arraylist, onClickListener = MultipleCounterAdapter.OnClickListener
        { count, position, action ->
            when(action){
                "plus" -> {
                    counter.count = viewModel.increaseCount(count.count)
                    adapter.notifyItemChanged(position)
                }
                "minus" -> {
                    counter.count = viewModel.decreaseCount(count.count)
                    adapter.notifyItemChanged(position)
                }
            }
        })

        val recyclerView: RecyclerView = binding.recyclerview
        recyclerView.adapter = adapter


        return binding.root
    }
}