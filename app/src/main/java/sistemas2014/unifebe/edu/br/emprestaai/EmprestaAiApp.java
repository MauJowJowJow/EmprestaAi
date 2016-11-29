package sistemas2014.unifebe.edu.br.emprestaai;

import android.app.Application;
import android.content.res.Configuration;

import com.facebook.stetho.Stetho;


/**
 * Created by mauma on 19/07/2016.
 */
public class EmprestaAiApp extends Application {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
