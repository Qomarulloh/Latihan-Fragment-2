package com.example.android.latihanfragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.latihanfragment.databinding.FragmentHasilBinding

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HasilFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HasilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HasilFragment : Fragment() {
    private lateinit var viewModel : SharedViewModel
    private lateinit var binding: FragmentHasilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hasil, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.data = viewModel.myData.value
        binding.invalidateAll()
        return binding.root
    }
}
