package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.TestKlasse;

import java.util.Collection;
import java.util.Optional;

public interface TestKlasseService {


    public Collection<TestKlasse> getTestKlassen();

    public Optional<TestKlasse> getTestklassenById(long id);

    public boolean testKlasseExistsById(long id);

    public long createTestKlasse(TestKlasse testKlasse);

    public void deleteTestKlasse(long id);

    public void updateTestKlasse(long id, TestKlasse testKlasse);


}
