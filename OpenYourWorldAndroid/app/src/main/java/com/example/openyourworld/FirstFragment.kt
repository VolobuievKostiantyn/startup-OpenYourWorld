package com.example.openyourworld

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import com.example.openyourworld.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var TAG: String = javaClass.simpleName
    private var _binding: FragmentFirstBinding? = null
    // A reference to the service used to get location updates.
    private var mService: LocationTrackingService? = null;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated")

        // Find the ComposeView and set the content
        val composeView = view.findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            // Get location updates here
            Log.d(TAG, "Getting location updates started")
            //todo: add log of current location

            // Todo: check how to create LocationTrackingService constructor to create mService
            // mService = LocationTrackingService(requireContext().applicationContext, ????)
            mService?.BgLocationAccessScreen()
            Log.d(TAG, "Getting location updates ended")
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}