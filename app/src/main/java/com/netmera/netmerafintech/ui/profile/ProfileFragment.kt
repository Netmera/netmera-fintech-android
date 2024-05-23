/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.profile

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.netmera.Netmera
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.model.NMImpactFintechUser
import com.netmera.netmerafintech.databinding.FragmentProfileBinding
import com.netmera.netmerafintech.utils.UserDefaultsHelper
import com.netmera.netmerafintech.utils.clearFocusOnDone
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.dateOfBirthInput.setOnClickListener {
            showDatePicker()
        }
        binding.saveButton.setOnClickListener {
            saveUserData()
        }
        fillTextInputs()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(requireContext())
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.setOnDateSetListener { _, p1, p2, p3 ->
            val month = p2 + 1
            val monthText = if (month < 10) "0$month" else "$month"
            val dayText = if (p3 < 10) "0$p3" else "$p3"
            binding.dateOfBirthInput.setText("$dayText/$monthText/$p1")
        }
        datePickerDialog.show()
    }

    private fun saveUserData() {
        binding.apply {
            UserDefaultsHelper.email = emailInput.text?.toString()
            UserDefaultsHelper.name = firstNameInput.text?.toString()
            UserDefaultsHelper.lastName = lastNameInput.text?.toString()
            UserDefaultsHelper.birthDate = dateOfBirthInput.text?.toString()
            UserDefaultsHelper.phone = phoneNumberInput.text?.toString()
            UserDefaultsHelper.companyName = companyNameInput.text?.toString()
            UserDefaultsHelper.companyEmail = companyEmailInput.text?.toString()
            UserDefaultsHelper.title = titleInput.text?.toString()
            UserDefaultsHelper.city = cityInput.text?.toString()

            val nmImpactFintechUser = NMImpactFintechUser()
            nmImpactFintechUser.setUserId(emailInput.text?.toString())
            nmImpactFintechUser.setEmail(emailInput.text?.toString())
            nmImpactFintechUser.setName(firstNameInput.text?.toString())
            nmImpactFintechUser.setSurname(lastNameInput.text?.toString())
            val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.UK)
            dateFormatter.timeZone = TimeZone.getTimeZone("UTC");
            dateOfBirthInput.text?.toString()?.let {
                nmImpactFintechUser.setDateOfBirth(
                    dateFormatter.parse(it)
                )
            }
            nmImpactFintechUser.setMsisdn(phoneNumberInput.text?.toString())
            nmImpactFintechUser.setCompanyName(companyNameInput.text?.toString())
            nmImpactFintechUser.setCompanyEmailAddress(companyEmailInput.text?.toString())
            nmImpactFintechUser.setJobTitle(titleInput.text?.toString())
            nmImpactFintechUser.setCity(cityInput.text?.toString())
            Netmera.updateUser(nmImpactFintechUser)

            view?.clearFocus()
        }

        AlertDialog.Builder(requireContext()).apply {
            setPositiveButton(android.R.string.ok) { _, _ -> }
            setMessage(getString(R.string.profile_was_updated))
        }.show()

    }

    private fun fillTextInputs() {
        binding.apply {
            emailInput.setText(UserDefaultsHelper.email)
            firstNameInput.setText(UserDefaultsHelper.name)
            lastNameInput.setText(UserDefaultsHelper.lastName)
            dateOfBirthInput.setText(UserDefaultsHelper.birthDate)
            phoneNumberInput.setText(UserDefaultsHelper.phone)
            companyNameInput.setText(UserDefaultsHelper.companyName)
            companyEmailInput.setText(UserDefaultsHelper.companyEmail)
            titleInput.setText(UserDefaultsHelper.title)
            cityInput.setText(UserDefaultsHelper.city)

            emailInput.clearFocusOnDone()
            firstNameInput.clearFocusOnDone()
            lastNameInput.clearFocusOnDone()
            dateOfBirthInput.clearFocusOnDone()
            phoneNumberInput.clearFocusOnDone()
            companyNameInput.clearFocusOnDone()
            companyEmailInput.clearFocusOnDone()
            titleInput.clearFocusOnDone()
            cityInput.clearFocusOnDone()
        }
    }
}