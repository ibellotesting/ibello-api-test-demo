package hu.demoapi.steps;

import hu.demoapi.data.PetModel;
import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.steps.StepLibrary;

@Name("Test data steps")
public class TestDataSteps extends StepLibrary {

    private Long id;

    public Long kisállat_azonosító() {
        return id;
    }

    public void kisállat_azonosító_legyen(Long id) {
        this.id = id;
    }

    public PetModel kisállat_bemenet_betöltése_$_azonosítóval(String id) {
        PetModel result = testData().fromJson(PetModel.class).withId(id).load();
        if (result == null) {
            throw new TestException(String.format("Nem található PetModel tesztadat '%s' azonosítóval.", id));
        }
        return result;
    }

    public PetModel kisállat_módosító_bemenet_betöltése_$_azonosítóval(String id) {
        PetModel result = testData().fromJson(PetModel.class).withId(id).load();
        if (result == null) {
            throw new TestException(String.format("Nem található PetModel tesztadat '%s' azonosítóval.", id));
        }
        if (this.id != null) {
            result.setId(this.id);
        } else {
            throw new TestException("Nincs elmentett kisállat azonosító.");
        }
        return result;
    }

}
