package dev.jmvg.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    buttonCalculate.setOnClickListener(this)
  }

  override fun onClick(view: View) {
    val id = view.id
    if (id == R.id.buttonCalculate) {
      calculate()
    }
  }

  private fun calculate() {
    if (validationOK()) {
      try {
        val distance = editDistance.text.toString().toFloat()
        val price = editPrice.text.toString().toFloat()
        val autonomy = editAutonomy.text.toString().toFloat()
        val result = (distance * price) / autonomy
        totalValue.text = "R$ ${"%.2f".format(result)}"
      } catch (e: NumberFormatException) {
        Toast.makeText(this, getString(R.string.excecao_number_format), Toast.LENGTH_SHORT)
          .show()
      }


    } else {
      Toast.makeText(this, getString(R.string.mensagem_aviso), Toast.LENGTH_SHORT).show()
    }


  }

  private fun validationOK(): Boolean = (editDistance.text.toString() != ""
          && editPrice.text.toString() != ""
          && editAutonomy.text.toString() != "")
}