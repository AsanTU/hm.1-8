package com.dacha.taskmanager1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.dacha.taskmanager1.data.local.PrefName
import com.dacha.taskmanager1.data.local.PrefOnBoarding
import com.dacha.taskmanager1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding:FragmentProfileBinding
    private lateinit var prefName: PrefName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefName = PrefName(requireContext())
        binding.btnSave.setOnClickListener{
            prefName.saveNameShow(true)
        }
    }
    var launchForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val image = result.data?.data
            binding.ivImage.setImageURI(image)}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

    }



    private fun initListeners() {
        binding.ivImage.setOnClickListener{
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            launchForResult.launch(intent)
        }
    }

}