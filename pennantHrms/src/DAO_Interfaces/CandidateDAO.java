package DAO_Interfaces;

import java.util.List;

import models.Candidate;

public interface CandidateDAO {

	// To display list of candidates
	List<Candidate> getAllCandidates();

	//
	void saveCandidate(Candidate candidate);

	// To display candidate details by id
	Candidate getCandidateById(int candidateId);

}
