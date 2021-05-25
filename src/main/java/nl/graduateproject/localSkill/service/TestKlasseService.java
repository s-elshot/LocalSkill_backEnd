package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Image;
import nl.graduateproject.localSkill.model.Item;
import nl.graduateproject.localSkill.model.TestKlasse;

import java.util.Collection;
import java.util.Optional;

public interface TestKlasseService {

    public abstract void deleteTestKlasse(long id);

    public abstract Collection<TestKlasse> getTestKlassen();

    public abstract Optional<TestKlasse> getTestklassenById(long id);

    public abstract boolean testKlasseExistsById(long id);

    public abstract long createTestKlasse(TestKlasse testKlasse);


    public abstract void updateTestKlasse(long id, TestKlasse testKlasse);

}
