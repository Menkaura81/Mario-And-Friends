package dam.aguadulce.aal.marioandfriends;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import dam.aguadulce.aal.marioandfriends.databinding.ActivityMainBinding;
import dam.aguadulce.aal.marioandfriends.databinding.CardviewBinding;
import dam.aguadulce.aal.marioandfriends.databinding.FragmentHomeBinding;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;
    private NavController navController;
    private CardviewBinding bindingCardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Obtener el NavController desde el NavHostFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        // Configurar menú toggle
        configureToggleMenu();

        // Configurar la navegación
        configureNavigation();

        // Configurar el icono del menú en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void configureToggleMenu() {
        // Configurar el ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar la selección de elementos del menú
        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.homeFragment); // Navegar al fragmento de inicio
            } else if (menuItem.getItemId() == R.id.nav_config) {
                navController.navigate(R.id.configFragment);
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            return true;
        });

        // Escuchar el resultado del clic en el RecyclerView
        getSupportFragmentManager().setFragmentResultListener("cardClick", this, (requestKey, result) -> {
            String characterName = result.getString("characterName", "");
            String characterDetails = result.getString("characterDetails", "");
            String characterSkills = result.getString("characterSkills", "");
            int characterImage = result.getInt("characterImage", R.drawable.bowser); // Usa una imagen por defecto si no se pasa la imagen

            Bundle bundle = new Bundle();
            bundle.putString("characterName", characterName);
            bundle.putString("characterDetails", characterDetails);
            bundle.putString("characterSkills", characterSkills); // Habilidades
            bundle.putInt("characterImage", characterImage); // Imagen


            navController.navigate(R.id.detailFragment, bundle);
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar clics en el icono del menú
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = NavHostFragment.findNavController(navHostFragment);
            return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }

}