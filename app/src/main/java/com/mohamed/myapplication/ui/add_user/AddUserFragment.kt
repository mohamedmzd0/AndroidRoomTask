package com.mohamed.myapplication.ui.add_user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mohamed.domain.entity.UserGender
import com.mohamed.myapplication.R
import com.mohamed.myapplication.databinding.FragmentAddUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserFragment : Fragment(R.layout.fragment_add_user) {

    private var _binding: FragmentAddUserBinding? = null
    private val binding get() =  _binding!!

    private val viewModel: AddUserViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentAddUserBinding.bind(view)
        setupViews()
    }

    private fun setupViews() {
        with(binding) {
            btnAddUser.setOnClickListener {
                val name = etName.text.toString()
                val age = etAge.text.toString().toIntOrNull()
                val title = etTitle.text.toString()
                val gender = when (rgGender.checkedRadioButtonId) {
                    R.id.rbMale -> UserGender.Male
                    R.id.rbFemale -> UserGender.Female
                    else -> null
                }

                if (name.isNotBlank() && age != null && title.isNotBlank() && gender != null) {
                    viewModel.addUser(name, age, title, gender)
                    Toast.makeText(requireContext(), "User added", Toast.LENGTH_SHORT).show()
                    etName.text.clear()
                    etAge.text.clear()
                    etTitle.text.clear()
                    rgGender.clearCheck()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please fill all fields correctly",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
