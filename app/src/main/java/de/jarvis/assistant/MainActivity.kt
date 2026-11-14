package de.jarvis.assistant

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.widget.*
import java.util.Locale

class MainActivity : Activity(), TextToSpeech.OnInitListener {
    private lateinit var tts: TextToSpeech
    private lateinit var output: TextView
    private lateinit var input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tts = TextToSpeech(this, this)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(28, 40, 28, 24)

        layout.addView(TextView(this).apply {
            text = "J.A.R.V.I.S."
            textSize = 28f
        })

        output = TextView(this).apply {
            text = "Guten Tag. Ich bin bereit."
            textSize = 18f
            setPadding(0, 24, 0, 24)
        }
        layout.addView(output)

        input = EditText(this).apply {
            hint = "Schreibe JARVIS etwas..."
        }
        layout.addView(input)

        layout.addView(Button(this).apply {
            text = "Senden"
            setOnClickListener { respond(input.text.toString()) }
        })

        layout.addView(Button(this).apply {
            text = "Spracheingabe"
            setOnClickListener { listen() }
        })

        setContentView(layout)
    }

    private fun listen() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "de-DE")
            putExtra(RecognizerIntent.EXTRA_PROMPT, "Sprich mit JARVIS")
        }
        try {
            startActivityForResult(intent, 10)
        } catch (_: Exception) {
            output.text = "Spracherkennung nicht verfügbar."
        }
    }

    @Deprecated("Deprecated")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10 && resultCode == RESULT_OK) {
            val words = data?.getStringArrayListExtra(
                RecognizerIntent.EXTRA_RESULTS
            )?.firstOrNull().orEmpty()
            input.setText(words)
            respond(words)
        }
    }

    private fun respond(text: String) {
        val answer = when {
            text.contains("hallo", true) ->
                "Hallo. Schön, dass du da bist."
            else ->
                "Ich habe dich verstanden: $text. Meine KI-Funktionen werden noch erweitert."
        }
        output.text = answer
        tts.speak(answer, TextToSpeech.QUEUE_FLUSH, null, "jarvis")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.GERMANY
        }
    }

    override fun onDestroy() {
        tts.shutdown()
        super.onDestroy()
    }
}
