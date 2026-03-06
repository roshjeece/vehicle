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

        // Assert
        assertEquals("Sopwith", found.get().getMake());
        assertThat(found.get().getMake()).isEqualTo(savedDoghouse.getMake());
        assertThat(found.get()).isEqualTo(savedDoghouse);



    }

}