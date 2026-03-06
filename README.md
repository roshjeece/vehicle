# vehicle
cohort 11 project

1. New Repository
2. Clone
3. Update .gitignore for ./idea and DS_STORE
4. start.spring.io
5. Settings:
   - Gradle - Groovy
   - Java
   - 4.0.3 
   - Group: mil.army.moda
   - Artifact: vehicle
   - Name: vehicle
   - Description: unchanged
   - Package Name: mil.army.moda.vehicle
   - Packaging: Jar
   - Configuration: YAML
   - Java: 21
   - Dependencies:
     - Spring Data JPA
     - Spring Web
     - H2 Database



6. New Package @ mil.army.moda.vehicle
7. Creating Vehicle.java
   - @Entity, then public class
   - @Id, @GeneratedValue, then probably a private long id
   - all other key variables (make, model, year, mileage)
   - Create getters and setters

CREATING REPOSITORY
```Java
public interface VehicleRepository extends JpaRepository<Vehicle, Long>
```

CREATING TEST FOR REPOSITORY
```Java
package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehicleRepositoryTest {

   @Autowired
   VehicleRepository vehicleRepository;

   @Test
   void shouldSaveAVehicle() {
      // Arrange
      Vehicle doghouse = new Vehicle("Sopwith", "dog-1", 1975, 100);

      // Act
      Vehicle savedDoghouse = vehicleRepository.save(doghouse);
      Optional<Vehicle> found = vehicleRepository.findById(doghouse.getId());

      // Assert -- this is an integration test because we're not "mocking"
      assertEquals("Sopwith", found.get().getMake()); /* Important we're calling on "found" because this
        makes us fetch from the repository */ // Is this equal to the literal?
      assertThat(found.get().getMake()).isEqualTo(savedDoghouse.getMake());
      // Is this equal to the value that we sent to the repository?
      // Mocking creates a "reflection" without actually sending anything to the repo



   }

}
```

CREATING VEHICLESERVICE.JAVA
```Java
package mil.army.moda.vehicle.vehicle;

import org.springframework.stereotype.Service;

@Service
public class VehicleService  {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }



}
```

CREATING VEHICLE SERVICE TEST
```Java
package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    VehicleService vehicleService;

    @Test
    void shouldSaveVehicle() {
        // Arrange
        Vehicle triplane = new Vehicle("Triplane", "DR-1", 1916, 100);
        triplane.setId(1L);

        // Act
        when(vehicleRepository.save(triplane)).thenReturn(triplane);
        Vehicle result = vehicleService.saveVehicle(triplane);

        // Assert
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getMake()).isEqualTo("Triplane");
        verify(vehicleRepository).save(triplane);
    }

}
```


Request Builders
Request Matchers
Response Matchers

Know the difference!


