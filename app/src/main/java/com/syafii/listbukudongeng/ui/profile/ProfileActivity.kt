package com.syafii.listbukudongeng.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.syafii.listbukudongeng.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.run {
            ivBack.setOnClickListener {
               finish()
            }

            mbLogout.setOnClickListener {
                showDialogLogout()
            }
        }
    }

    private fun showDialogLogout() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog")
        dialog.setMessage("Apakah anda yakin ingin keluar?")
        dialog.setPositiveButton("Ya") { p0, p1 ->
            finishAffinity()
            p0.dismiss()
        }
        dialog.setNegativeButton("Tidak") { p0, p1 ->
            p0.dismiss()
        }
        dialog.show()
    }
}
