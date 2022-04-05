package ma.emsi;

import ma.emsi.entities.patient;
import ma.emsi.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientMvcApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {

		SpringApplication.run(PatientMvcApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i <100 ; i++) {
			patientRepository.save(new patient(null,"loubna" + i,new Date(),Math.random()>0.5? true: false,(int)(Math.random()*1000)));
		}
		Page<patient>p1= patientRepository.findAll(PageRequest.of(0,5));
		System.out.println(p1.getTotalElements());
		System.out.println(p1.getTotalPages());
		System.out.println(p1.getNumber());
		List<patient> patients= p1.getContent();
		patients.forEach(p->{
			System.out.println("printing list");
			System.out.println(p.getId());
			System.out.println(p.getNom());
			System.out.println(p.getDatenaissance());
			System.out.println(p.isMalade());
			System.out.println(p.getScore());
				}

		);
		List<patient> lp2=patientRepository.findByMalade(true);
		patient patient = patientRepository.findById(1L).orElse(null);
		if(patient!=null){
			System.out.println(patient.getId());
			System.out.println(patient.getNom());
		}

	}
}
