package dam_A42346.thematiccalculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.w3c.dom.Text


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mem: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val plus: Button = this.findViewById(R.id.plus)
        plus.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        plus.setOnClickListener(this)
        val minus: Button = this.findViewById(R.id.minus)
        minus.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        minus.setOnClickListener(this)
        val times: Button = this.findViewById(R.id.times)
        times.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        times.setOnClickListener(this)
        val divide: Button = this.findViewById(R.id.divide)
        divide.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        divide.setOnClickListener(this)
        val root: Button = this.findViewById(R.id.root)
        root.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        root.setOnClickListener(this)
        val pow: Button = this.findViewById(R.id.pow)
        pow.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        pow.setOnClickListener(this)
        val setMem: Button = this.findViewById(R.id.setMem)
        setMem.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        setMem.setOnClickListener(this)
        val getMem: Button = this.findViewById(R.id.getMem)
        getMem.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorWhite))
        getMem.setOnClickListener(this)

        val winIcon: ImageButton = findViewById(R.id.winIcon)
        winIcon.setOnTouchListener { arg0, arg1 ->
            setContext(R.id.winIcon)
            false
        }
        val macIcon: ImageButton = findViewById(R.id.macIcon)
        macIcon.setOnTouchListener { arg0, arg1 ->
            setContext(R.id.macIcon)
            false
        }
        val linuxIcon: ImageButton = findViewById(R.id.linuxIcon)
        linuxIcon.setOnTouchListener { v, event ->
            setContext(R.id.linuxIcon)
            false
        }

        val git: TextView = findViewById(R.id.selectTeam)
        git.setOnClickListener {
            val viewIntent = Intent(
                "android.intent.action.VIEW",
                Uri.parse("https://github.com/LG42346/ThematicCalculator")
            )
            startActivity(viewIntent)
        }
//        gitIcon.setOnTouchListener{v, event ->
//            val viewIntent = Intent(
//                "android.intent.action.VIEW",
//                Uri.parse("http://www.https://github.com/LG42346/ThematicCalculator")
//            )
//            startActivity(viewIntent)
//            false
//        }

     //   val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com"))
       // startActivity(i)
    }


    private fun setContext(id: Int) {

        var fc = 0
        val container: View = findViewById(R.id.container)
        val bc = R.color.colorWhite

        when (id) {

            R.id.winIcon -> {
                container.setBackgroundResource(R.drawable.windowswallpaper)
                fc = R.color.colorWindows
                //          bc = R.color.fcpb;
            }
            R.id.linuxIcon -> {
                container.setBackgroundResource(R.drawable.ubuntuwallpaper)
                fc = R.color.colorLinux
                //          bc = R.color.fcpb;
            }
            R.id.macIcon -> {
                container.setBackgroundResource(R.drawable.macwallpaper)
                fc = R.color.colorMacOS
                //          bc = R.color.fcpb;
            }
        }
        val title: TextView = findViewById(R.id.selectTeam)
        title.setTextColor(ContextCompat.getColor(baseContext, fc))

        val operand1: TextView = findViewById(R.id.operand1)
        operand1.setTextColor(ContextCompat.getColor(baseContext, fc))
        operand1.setBackgroundColor(ContextCompat.getColor(baseContext, bc))
        val operand2: TextView = findViewById(R.id.operand2)
        operand2.setTextColor(ContextCompat.getColor(baseContext, fc))
        operand2.setBackgroundColor(ContextCompat.getColor(baseContext, bc))

        val numberOp1: TextView = findViewById(R.id.numberOp1)
        numberOp1.setTextColor(ContextCompat.getColor(baseContext, bc))
        numberOp1.setBackgroundColor(ContextCompat.getColor(baseContext, fc))
        val numberOp2: TextView = findViewById(R.id.numberOp2)
        numberOp2.setTextColor(ContextCompat.getColor(baseContext, bc))
        numberOp2.setBackgroundColor(ContextCompat.getColor(baseContext, fc))

        val plus: Button = findViewById(R.id.plus)
        plus.setTextColor(ContextCompat.getColor(baseContext, fc))
        val minus: Button = findViewById(R.id.minus)
        minus.setTextColor(ContextCompat.getColor(baseContext, fc))
        val times: Button = findViewById(R.id.times)
        times.setTextColor(ContextCompat.getColor(baseContext, fc))
        val divide: Button = findViewById(R.id.divide)
        divide.setTextColor(ContextCompat.getColor(baseContext, fc))
        val root: Button = findViewById(R.id.root)
        root.setTextColor(ContextCompat.getColor(baseContext, fc))
        val pow: Button = findViewById(R.id.pow)
        pow.setTextColor(ContextCompat.getColor(baseContext, fc))
        val setMem: Button = findViewById(R.id.setMem)
        setMem.setTextColor(ContextCompat.getColor(baseContext, fc))
        val getMem: Button = findViewById(R.id.getMem)
        getMem.setTextColor(ContextCompat.getColor(baseContext, fc))

    }

    override fun onClick(v: View) {

        val c = Calculator()
        val b = v as Button
        var value = 0.0
        val numberOp1: TextView = findViewById(R.id.numberOp1)
        val numberOp2: TextView = findViewById(R.id.numberOp2)
        val sNum1 = numberOp1.text.toString()
        val sNum2 = numberOp2.text.toString()
        var num1 = sNum1.toDouble()
        val num2 = sNum2.toDouble()


        when (b.id) {

            R.id.plus -> {
                value = c.add(num1, num2)
            }
            R.id.minus -> {
                value = c.sub(num1, num2)
            }
            R.id.times -> {
                value = c.mult(num1, num2)
            }
            R.id.divide -> {
                value = c.div(num1, num2)
            }
            R.id.pow -> {
               value = c.pow(num1,num2)
            }
            R.id.root -> {
                value = c.root(num1,num2)
            }
            R.id.setMem -> {
                mem = num1
            }
            R.id.getMem -> {
                value = mem
            }
        }

        numberOp1.text = value.toString()
    }
}