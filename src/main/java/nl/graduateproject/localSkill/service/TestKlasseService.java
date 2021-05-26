package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Image;
import nl.graduateproject.localSkill.model.Item;
import nl.graduateproject.localSkill.model.TestKlasse;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TestKlasseService {



    public Collection<TestKlasse> getTestKlassen();

    public Optional<TestKlasse> getTestklassenById(long id);

    public boolean testKlasseExistsById(long id);

    public long createTestKlasse(TestKlasse testKlasse);

    public void deleteTestKlasse(long id);

    public List<TestKlasse> findByDescriptionEquals (String description);

    public void updateTestKlasse(long id, TestKlasse testKlasse);

    public List<TestKlasse> findAllByAreaCodeEquals(String areaCode);

}
