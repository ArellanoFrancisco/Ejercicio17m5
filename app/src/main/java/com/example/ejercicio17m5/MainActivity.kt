package com.example.ejercicio17m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ejercicio17m5.databinding.ActivityMainBinding


open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val spinner1 =binding.spinner1
        val spinner2 =binding.spinner2
        val currency = binding.Currency
        val result = binding.result
        val divisas = resources.getStringArray(R.array.Divisa)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,divisas)
        var position1 = ""
        var position2 = ""
        var total = 0.0

        spinner1.adapter = adapter
        spinner2.adapter = adapter

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                position1 = divisas[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, R.string.Toast2, Toast.LENGTH_LONG).show()
            }

        }
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                position2 = divisas[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, R.string.Toast2, Toast.LENGTH_LONG).show()
            }

        }



        binding.convert.setOnClickListener {
            if (currency.text.isNotEmpty()) {
                when (position1) {
                    "USD" -> {
                        when (position2) {
                            "USD" -> {
                                result.text = currency.text
                            }

                            "EURO" -> {
                                total = currency.text.toString().toFloat() * 0.89
                                result.text = total.toString()
                            }

                            "PESO CHILENO" -> {
                                total = currency.text.toString().toFloat() * 806.70
                                result.text = total.toString()
                            }

                            "YEN" -> {
                                total = currency.text.toString().toFloat() * 139.29
                                result.text = total.toString()
                            }

                            "Elije una divisa" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    "EURO" -> {
                        when (position2) {
                            "EURO" -> {
                                result.text = currency.text
                            }

                            "USD" -> {
                                total = currency.text.toString().toFloat() * 1.12
                                result.text = total.toString()
                            }

                            "PESO CHILENO" -> {
                                total = currency.text.toString().toFloat() * 903.54
                                result.text = total.toString()
                            }

                            "YEN" -> {
                                total = currency.text.toString().toFloat() * 156.32
                                result.text = total.toString()
                            }

                            "Elije una divisa" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    "PESO CHILENO" -> {
                        when (position2) {
                            "PESO CHILENO" -> {
                                result.text = currency.text
                            }

                            "EURO" -> {
                                total = currency.text.toString().toFloat() * 0.0011
                                result.text = total.toString()
                            }

                            "USD" -> {
                                total = currency.text.toString().toFloat() * 0.0012
                                result.text = total.toString()
                            }

                            "YEN" -> {
                                total = currency.text.toString().toFloat() * 0.17
                                result.text = total.toString()
                            }

                            "Elije una divisa" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    "YEN" -> {
                        when (position2) {
                            "YEN" -> {
                                result.text = currency.text
                            }

                            "EURO" -> {
                                total = currency.text.toString().toFloat() * 0.0064
                                result.text = total.toString()
                            }

                            "PESO CHILENO" -> {
                                total = currency.text.toString().toFloat() * 5.78
                                result.text = total.toString()
                            }

                            "USD" -> {
                                total = currency.text.toString().toFloat() * 0.0072
                                result.text = total.toString()
                            }

                            "Elije una divisa" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    "Elije una divisa" -> {
                        when (position2) {
                            "YEN" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }

                            "EURO" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()

                            }

                            "PESO CHILENO" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }

                            "USD" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }

                            "Elije una divisa" -> {
                                Toast.makeText(this, R.string.Toast2, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                } }else {
                    Toast.makeText(this, R.string.Toast1, Toast.LENGTH_LONG).show()
                }
            }

        binding.reset.setOnClickListener {
            currency.setText(" ")
            result.text   = ""

        }
        }
    }

