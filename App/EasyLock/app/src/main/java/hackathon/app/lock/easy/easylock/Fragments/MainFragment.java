package hackathon.app.lock.easy.easylock.Fragments;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import hackathon.app.lock.easy.easylock.Activities.MainActivity;
import hackathon.app.lock.easy.easylock.R;
import hackathon.app.lock.easy.easylock.ShakeSensor.ShakeDetector;


/**
 * Created by jose on 20/06/16.
 */
public class MainFragment extends Fragment{
    Button registrar;
    Button ingresar;

    //Sensor Manager
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_main,container,false);
        registrar = (Button) v.findViewById(R.id.registrarse);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).Registrar();

            }
        });

        ingresar = (Button) v.findViewById(R.id.ingresar);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SensorShake
                mSensorManager =  (SensorManager) getActivity().getSystemService(MainActivity.SENSOR_SERVICE);
                mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
                    @Override
                    public void onShake() {
                        Toast.makeText(getContext(),"Shake it",Toast.LENGTH_SHORT).show();
                    }
                });

                mSensorManager.registerListener(mShakeDetector,mAccelerometer,SensorManager.SENSOR_DELAY_UI);

            }
        });

        return v;
    }
}
