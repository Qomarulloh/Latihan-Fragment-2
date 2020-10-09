package com.example.android.latihanfragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.latihanfragment.databinding.FragmentFormBinding

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FormFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentFormBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        viewModel.eventSimpan.observe(requireActivity(), Observer {
            if (it){
                viewModel.updateMyData(
                    binding.etNama.text.toString(),
                    binding.etNik.text.toString(),
                    binding.etUsia.text.toString()
                )
                this.findNavController().navigate(R.id.action_formFragment_to_hasilFragment)
                viewModel.onSimpanComplete()
            }
        })

        viewModel.jk.observe(requireActivity(), Observer {
            when(it) {
                binding.rbLakilaki.id -> viewModel.updateJkText(binding.rbLakilaki.text.toString())
                binding.rbPerempuan.id -> viewModel.updateJkText(binding.rbPerempuan.text.toString())
            }
        })

        binding.viewModel = viewModel

        binding.radioGroup2.setOnCheckedChangeListener { _, i ->
            viewModel.updateJk(i)
        }
        binding.rbLakilaki.setOnClickListener{
            val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
            activity?.currentFocus?.clearFocus()
        }
        binding.rbPerempuan.setOnClickListener{
            val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
            activity?.currentFocus?.clearFocus()
        }
        return binding.root
    }
}
