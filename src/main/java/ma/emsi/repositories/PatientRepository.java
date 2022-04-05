package ma.emsi.repositories;

import ma.emsi.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<patient, Long>{
     List<patient> findByMalade(boolean m);
     List<patient> findByDatenaissanceBetweenAndMaladeIsTrueAndNomLike(Date d, Date d2,String nom);
     @Query("Select p from patient p where p.nom like :x")
     List<patient> ChercherPatient(@Param("x") String x);

}
