package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.TestKlasse;
import nl.graduateproject.localSkill.repository.TestKlasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TestKlasseServiceImpl implements TestKlasseService {

    @Autowired
    private TestKlasseRepository testKlasseRepository;

    @Override
    public void deleteTestKlasse(long id) {
        if (!testKlasseRepository.existsById(id)) throw new RecordNotFoundException();
        testKlasseRepository.deleteById(id);
    }

    @Override
    public Collection<TestKlasse> getTestKlassen() {
        return testKlasseRepository.findAll();
    }

    @Override
    public Optional<TestKlasse> getTestklassenById(long id) {
        if (!testKlasseRepository.existsById(id)) throw new RecordNotFoundException();
        return testKlasseRepository.findById(id);
    }

    @Override
    public boolean testKlasseExistsById(long id) {
        return testKlasseRepository.existsById(id);
    }

    @Override
    public long createTestKlasse(TestKlasse testKlasse) {
        TestKlasse newTestKlasse = testKlasseRepository.save(testKlasse);
        return newTestKlasse.getId();
    }



    @Override
    public void updateTestKlasse(long id, TestKlasse testKlasse) {

    }



}

