package dam.aguadulce.aal.marioandfriends;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.content.res.Configuration;
import java.util.Locale;


/**
 * Clase que implementa el fragmento de configuración de idioma
 */
public class ConfigFragment extends Fragment {

    private SwitchCompat languageSwitch;


    /**
     * Método generado por el IDE
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_config, container, false);
    }


    /**
     * Método que comprueba el estado del switch e implementa su listener
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
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
                setLanguage("es");  // Cambia a español
            } else {
                setLanguage("en");  // Cambia a ingles
            }
        });
    }


    /**
     * Metodo que cambia el idioma de la aplicación
     * @param languageCode Código de lenguaje del terminal
     */
    private void setLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());

        // Reiniciar la actividad para aplicar el nuevo idioma
        getActivity().recreate();

        // Toast confirmando el cambio
        Toast.makeText(getContext(), getString(R.string.lang_change), Toast.LENGTH_SHORT).show();
    }
}