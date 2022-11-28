package com.example.demo.Service;

import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Experience;
import com.example.demo.Repository.IExperienceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ExperienceService")
@RequiredArgsConstructor
public class ExperienceService implements IExperienceService {
    @Autowired
    private IExperienceRepo ExperienceRepo;
    @Autowired
    private IEtudiantService etudiantService;
    ;
    @Override
    public List<Experience> retrieveAllExperiences() {
        return (List<Experience>) ExperienceRepo.findAll();
    }

    @Override
    public Experience updateExperience(Experience ce) {
        return ExperienceRepo.save(ce);
    }

    @Override
    public Experience addExperience(Experience ce) {
        return ExperienceRepo.save(ce);
    }

    @Override
    public Experience retrieveExperience(Integer idExperience) {
        return ExperienceRepo.findById(idExperience).get();
    }

    @Override
    public void removeExperience(Integer idExperience) {
        ExperienceRepo.deleteById(idExperience);
    }

  /*  @Override
    public Experience assignEtudiantToExperience(Integer idExperience, Integer idDep) {
        Experience e=ExperienceRepo.findById(idExperience);

        e.getEtudiant().add(ce);
        ce.setExperience(e);
        edtREpo.save(ce);
        ExperienceRepo.save(e);
        return ce;
    }*/




    /*   @Override
       public Etudiant assignEtudiantToExperience(Integer id, Integer idEtudiant) {
           Experience ee=experienceService.retrieveExperience(id);
           Etudiant e=retrieveEtudiant(idEtudiant);
           ee.setEtudiant(e);
           experienceService.addExperience(ee);
           return e;
       }*/
  @Override
  public Experience assignEtudiantToExperience(Integer id, Integer idExpereince) {
      Etudiant e=etudiantService.retrieveEtudiant(id);
      Experience ee=retrieveExperience(idExpereince);
      ee.setEtudiant(e);
      etudiantService.addEtudiant(e);
      ExperienceRepo.save(ee);
      return ee;
  }

}