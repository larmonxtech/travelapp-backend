package com.xplorelatam.util;

import com.xplorelatam.model.Category;
import com.xplorelatam.model.Role;
import com.xplorelatam.model.Tag;
import com.xplorelatam.model.User;
import com.xplorelatam.repository.ICategoryRepository;
import com.xplorelatam.repository.IRoleRepository;
import com.xplorelatam.repository.ITagRepository;
import com.xplorelatam.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ICategoryRepository categoryRepository;
    private final ITagRepository tagRepository;
    private final IRoleRepository roleRepository;
    private final IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role admin = new Role(1, "ADMIN", "Administrador");
            Role user = new Role(2, "USER", "Usuario");
            Role dba = new Role(3, "DBA", "Admin de bd");
            roleRepository.saveAll(Arrays.asList(admin, user, dba));
            System.out.println("Roles insertados.");
        }

        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.findById(1).orElse(null);
            User admin = new User(1, "exampletest@gmail.com", "$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.", true, Collections.singletonList(adminRole));
            userRepository.save(admin);
            System.out.println("Usuario de prueba insertado.");
        }

        if (categoryRepository.count() == 0) {
            List<Category> categories = Arrays.asList(
                new Category(null, "Aventura", "Actividades al aire libre y deportes extremos", true),
                new Category(null, "Cultura", "Recorridos históricos y museos", true),
                new Category(null, "Gastronomía", "Experiencias culinarias y catas", true),
                new Category(null, "Naturaleza", "Observación de flora y fauna", true),
                new Category(null, "Relajación", "Spas y retiros espirituales", true),
                new Category(null, "Playa", "Actividades acuáticas y descanso", true),
                new Category(null, "Montaña", "Senderismo y escalada", true),
                new Category(null, "Ciudad", "Tours urbanos y compras", true),
                new Category(null, "Arte", "Galerías y talleres creativos", true),
                new Category(null, "Música", "Conciertos y festivales locales", true)
            );
            categoryRepository.saveAll(categories);
            System.out.println("10 Categorías insertadas.");
        }

        if (tagRepository.count() == 0) {
            List<Tag> tags = Arrays.asList(
                new Tag(null, "Ecoturismo", true),
                new Tag(null, "Familiar", true),
                new Tag(null, "Parejas", true),
                new Tag(null, "Económico", true),
                new Tag(null, "Lujo", true),
                new Tag(null, "Sostenible", true),
                new Tag(null, "Fotografía", true),
                new Tag(null, "Pet Friendly", true),
                new Tag(null, "Accesible", true),
                new Tag(null, "Nocturno", true)
            );
            tagRepository.saveAll(tags);
            System.out.println("10 Tags insertados.");
        }
    }
}
