package hu.demoapi.data;

import hu.demoapi.model.Pet;
import hu.ibello.core.Name;
import hu.ibello.data.Model;

@Model
@Name("Pet")
public class PetModel extends Pet {

    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return super.toString();
    }

}