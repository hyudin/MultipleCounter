package br.com.hyudin.multiple_counter.presentation.MultipleCounterFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import br.com.hyudin.multiple_counter.R
import br.com.hyudin.multiple_counter.databinding.FragmentMultiplecounterBinding
import br.com.hyudin.multiple_counter.di.model.Counter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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
            Log.d("Position", "$position e $count e $action")
            when(action){
                "plus" -> {
                    adapter.addCount(position)
                    adapter.notifyItemChanged(position)
                }
                "minus" -> {
                    adapter.decreaseCount(position)
                    adapter.notifyItemChanged(position)
                }
                "remove" -> {
                    showRemoveCounterDialog(position)
                }
            }
        })

        val recyclerView: RecyclerView = binding.recyclerview
        recyclerView.itemAnimator = null
        recyclerView.adapter = adapter

        binding.buttonCreatecounter.setOnClickListener{
            showAddCounterDialog()
        }

        return binding.root
    }

    private fun showRemoveCounterDialog(position: Int){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Atenção")
            .setMessage("Deseja remover o contador?")

            .setPositiveButton("SIM") { dialog, which ->
                adapter.removeCounter(position)
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            .setNegativeButton("NÃO"){ dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showAddCounterDialog(){
        val editTextInput = EditText(requireContext())
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Atenção")
            .setMessage("Deseja adicionar o contador?")
            .setView(editTextInput)
            .setPositiveButton("SIM") { dialog, which ->
                adapter.addCounter(Counter(
                    editTextInput.text.toString(),
                    "",
                    0
                ))
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            .setNegativeButton("NÃO"){ dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

}