package co.joebirch.watertracker

import android.app.Application
import co.joebirch.watertracker.di.component.ApplicationComponent
import co.joebirch.watertracker.di.component.DaggerApplicationComponent
import javax.inject.Inject

class WaterTrackerApplication: Application() {

    @Inject lateinit var logger: Logger

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
        appComponent.inject(this)

        logger.configure()
    }
}