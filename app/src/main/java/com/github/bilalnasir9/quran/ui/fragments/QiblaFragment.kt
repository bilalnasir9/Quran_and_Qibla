package com.github.bilalnasir9.quran.ui.fragments

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.bilalnasir9.quran.R
import com.github.bilalnasir9.quran.base.BaseFragment
import com.github.bilalnasir9.quran.base.showlogD
import com.github.bilalnasir9.quran.databinding.FragmentQiblaBinding
import com.github.bilalnasir9.quran.qibla.CompassQibla
import com.github.bilalnasir9.quran.qibla.CompassQiblaViewModel

class QiblaFragment : BaseFragment<FragmentQiblaBinding>(), SensorEventListener {
private val viewmodel: CompassQiblaViewModel by viewModels()
    private var currentCompassDegree = 0f
    private var currentNeedleDegree = 0f
    private var accelerometer: Sensor? = null
    private var magnetometer: Sensor? = null
    private lateinit var sensorManager2: SensorManager

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentQiblaBinding {
        return FragmentQiblaBinding.inflate(inflater, container, false)
    }

    var mp: MediaPlayer? = null


    override fun setupViews() {
        setupQibla()
        binding.apply {
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setupQibla() {
        mp = MediaPlayer.create(requireContext(), R.raw.qibla_tone)

        sensorManager2 = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager2.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        magnetometer = sensorManager2.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        if (sensorManager2.getSensorList(Sensor.TYPE_ORIENTATION).size > 0) {
            try {
                CompassQibla.Builder(this,viewmodel)
                    .onPermissionGranted { permission ->

                    }.onPermissionDenied {
                        Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT)
                            .show()
                    }.onGetLocationAddress { address ->
                        showlogD(message = "${address.latitude}, ${address.longitude},${address.adminArea}")
                    }.onDirectionChangeListener { qiblaDirection ->
                        showlogD(message = "Direction: "+qiblaDirection.toString())
                        binding.apply {
                            val direction = qiblaDirection.needleAngle
                            val isFacingQibla = direction in 352.0..360.0 || direction in 0.0..8.0
                            if (isFacingQibla) {
                                mp?.start()
                            } else {
                                "${qiblaDirection.needleAngle.toInt()}°"
                                val compassAngleAbs: Int =
                                    Math.abs(qiblaDirection.compassAngle.toInt())
                                angleText.text = buildString {
                                    append(getString(R.string.qiblaangle))
                                    append(": ")
                                    append((compassAngleAbs.toString()))
                                    append("°")
                                }
                            }
                            val rotateCompass = RotateAnimation(
                                currentCompassDegree,
                                qiblaDirection.compassAngle,
                                Animation.RELATIVE_TO_SELF,
                                0.5f,
                                Animation.RELATIVE_TO_SELF,
                                0.5f
                            ).apply {
                                duration = 210
                            }
                            currentCompassDegree = qiblaDirection.compassAngle

                            compass.startAnimation(rotateCompass)

                            val rotateNeedle = RotateAnimation(
                                currentNeedleDegree,
                                qiblaDirection.needleAngle,
                                Animation.RELATIVE_TO_SELF,
                                0.5f,
                                Animation.RELATIVE_TO_SELF,
                                0.5f
                            ).apply {
                                duration = 210
                            }
                            currentNeedleDegree = qiblaDirection.needleAngle
                            needle.startAnimation(rotateNeedle)
                        }
                    }.build()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            Toast.makeText(requireContext(), "Sensor not available", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.let {
            sensorManager2.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_UI
            )
        }
        magnetometer?.let {
            sensorManager2.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_UI
            )
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager2.unregisterListener(this)
    }

    override fun onDestroy() {
        mp?.release()
        super.onDestroy()
    }

    override fun onSensorChanged(p0: SensorEvent?) {

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}