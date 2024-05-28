package com.example.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.example.bitsandpizzas.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        //val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        //val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        binding.fab.setOnClickListener {
            //val pizzaGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
            val pizzaType = binding.pizzaGroup.checkedRadioButtonId
            if (pizzaType == -1) {
                val text = "You need to choose a pizza type"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            } else {
                var text = (when (pizzaType) {
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })
                //val parmesan = view.findViewById<Chip>(R.id.parmesan)
                text += if (binding.parmesan.isChecked) ", extra parmesan" else ""
                //val chiliOil = view.findViewById<Chip>(R.id.chili_oil)
                text += if (binding.chiliOil.isChecked) ", extra chili oil" else ""
                Snackbar.make(binding.fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}