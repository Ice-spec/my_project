package com.joelson.delgram.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.joelson.delgram.EditProfileActivity
import com.joelson.delgram.MainActivity

import com.joelson.delgram.R
import com.joelson.delgram.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private var pBinding: FragmentProfileBinding? = null
        //private val binding get() = pBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        pBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return pBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pBinding?.btnEditAccount?.setOnClickListener {
            val activity = requireActivity() as MainActivity
            activity.startActivity(Intent(requireActivity(), EditProfileActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        pBinding = null
    }


}