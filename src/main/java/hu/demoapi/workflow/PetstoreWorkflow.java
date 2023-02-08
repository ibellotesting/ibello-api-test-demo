package hu.demoapi.workflow;

import hu.demoapi.data.PetModel;
import hu.demoapi.steps.*;
import hu.ibello.core.Name;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Name("Petstore")
public class PetstoreWorkflow extends AbstractSteps {

    private PostPetSteps postPet;
    private DelPetSteps delPet;
    private GetPetSteps getPet;
    private TestDataSteps data;

    private PetModel petModel;
    private Long id;

    //1
    public void egy_kisállat_neve_$(String param1) {
        petModel = new PetModel();
        petModel.setName(param1);
    }

    public void a_megadott_adatokkal_létrehozok_egy_kisállatot() throws IOException, TransformerException {
        shouldNotBeNull(petModel, "Nincs elmentett kisállat modell");
        postPet.a_végpont_hívása_$_paraméterrel(petModel);
    }

    public void látom__hogy_a_kisállat_létrejött() {
        shouldNotBeNull(petModel, "Nincs elmentett kisállat modell");
        shouldNotBeNull(petModel.getName(), "Nincs elmentett kisállat név");
        postPet.ellenőrzés__a_válasz_sikeres();
        postPet.ellenőrzés__a_válaszban_nincs_hibaüzenet();
        postPet.ellenőrzés__$_néven_létrejött_az_új_kisállat(petModel.getName());
        id = postPet.létrehozott_kisállat_azonosítója();
    }

    //2
    public void van_egy_létező_kisállat_azonosítóm() {
        shouldNotBeNull(id, "Nincs elmentett kisállat azonosító");
    }

    public void kitörlöm_az_adott_kisállatot() throws IOException, TransformerException {
        delPet.a_végpont_hívása_$_paraméterrel(id);
    }

    public void látom__hogy_a_kisállat_sikeresen_törlődött() {
        delPet.ellenőrzés__a_válasz_sikeres();
        delPet.ellenőrzés__a_válaszban_nincs_hibaüzenet();
    }

    //3
    public void van_egy_nem_létező_kisállat_azonosítóm() {
        id = -5L;
    }

    public void kitörlöm_az_adott_azonosítóhoz_tartozó_kisállatot() throws IOException, TransformerException {
        delPet.a_végpont_hívása_$_paraméterrel(id);
    }

    public void látom__hogy_a_kisállat_nem_létezik() {
        delPet.ellenőrzés__a_válasz_kódja_$(404);
    }

    //4
    public void van_egy_létező_kisállat_a_rendszerben() throws IOException, TransformerException {
        postPet.a_végpont_hívása_$_tesztadattal("bajusz");
        postPet.ellenőrzés__a_válasz_sikeres();
        postPet.a_létrehozott_kisállat_azonosítójának_megjegyzése();
    }

    public void lekérdezem_az_adott_kisállat_adatait() throws IOException, TransformerException {
        getPet.a_korábban_megjegyzett_kisállat_lekérdezése();
        getPet.ellenőrzés__a_válasz_sikeres();
        getPet.ellenőrzés__a_válaszban_nincs_hibaüzenet();
    }

    public void a_lekérdezett_adatok_helyesen_jelennek_meg() {
        PetModel expPet = data.kisállat_bemenet_betöltése_$_azonosítóval("bajusz");
        getPet.ellenőrzés__a_válaszban_kapott_kisállat_adatai_megegyeznek_$_kisállat_adataival(expPet);
    }

}
