package dam.aguadulce.aal.marioandfriends;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import dam.aguadulce.aal.marioandfriends.databinding.FragmentDetailBinding;


/**
 * Clase que implementa el fragmento de detalles de personaje
 */
public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;


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
        // Inicializar binding
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    /**
     * Método que vincula los campos del layout con los datos del personaje que se muestra
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencias a las vistas
        ImageView detailImage = binding.detailImage;
        TextView detailName = binding.detailName;
        TextView detailDescription = binding.detailDescription;
        TextView detailSkills = binding.detailSkills;

        // Argumentos pasados
        if (getArguments() != null) {
            String characterName = getArguments().getString("characterName", "No Name");
            String characterDetails = getArguments().getString("characterDetails", "No Details");
            int characterImage = getArguments().getInt("characterImage", R.drawable.bowser); // Valor predeterminado
            String characterSkills = getArguments().getString("characterSkills", "No Skills");

            // Actualizar las vistas con los datos
            detailName.setText(characterName);
            detailDescription.setText(characterDetails);
            detailImage.setImageResource(characterImage); // Se configura la imagen
            detailSkills.setText(characterSkills);
            Toast.makeText(getContext(), getString(R.string.selection) + " " + characterName, Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Método para evitar fugas de memoria al cerrar la vista
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}