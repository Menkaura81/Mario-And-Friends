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

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inicializar binding
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener referencias a las vistas
        ImageView detailImage = binding.detailImage;
        TextView detailName = binding.detailName;
        TextView detailDescription = binding.detailDescription;
        TextView detailSkills = binding.detailSkills;

        // Obtener los argumentos pasados
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evitar fugas de memoria
    }
}