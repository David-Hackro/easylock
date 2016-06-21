package hackathon.app.lock.easy.easylock.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hackathon.app.lock.easy.easylock.Activities.MainActivity;
import hackathon.app.lock.easy.easylock.R;


/**
 * Created by jose on 20/06/16.
 */
public class MainFragment extends Fragment {
    Button registrar;
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

        return v;
    }
}
