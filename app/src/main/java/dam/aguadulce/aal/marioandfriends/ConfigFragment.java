package dam.aguadulce.aal.marioandfriends;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.content.res.Configuration;


import java.util.Locale;


public class ConfigFragment extends Fragment {

    private SwitchCompat languageSwitch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_config, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        languageSwitch = view.findViewById(R.id.switchLanguage);

        // Verifica el idioma actual y ajusta el estado del switch
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("es")) {
            languageSwitch.setChecked(true);
        } else {
            languageSwitch.setChecked(false);
        }

        // Configura el Listener del switch para cambiar el idioma
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setLanguage("es");  // Cambiar a español
            } else {
                setLanguage("en");  // Cambiar a inglés
            }
        });
    }

    // Método para cambiar el idioma de la aplicación
    private void setLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());

        // Reiniciar la actividad para aplicar el nuevo idioma
        getActivity().recreate();

        // Mostrar un Toast confirmando el cambio
        Toast.makeText(getContext(), getString(R.string.lang_change), Toast.LENGTH_SHORT).show();
    }
}