package test;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.ui.Model;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DAO_Interfaces.CandidateDAO;
import controllers.CandidateController;
import models.Candidate;
import models.input.output.CandidateIO;

public class CandidateControllerTest {
    @Mock
    private CandidateDAO candidateDAO;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private Model model;

    @InjectMocks
    private CandidateController candidateController;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowCandidateList() {
        // Mock data
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate());
        candidates.add(new Candidate());

        when(candidateDAO.getAllCandidates()).thenReturn(candidates);
        when(modelMapper.map(anyList(), any())).thenReturn(new ArrayList<CandidateIO>());

        // Test method
        String result = candidateController.showCandidateList(1, model);

        // Verify the interactions and assertions
        verify(candidateDAO).getAllCandidates();
        verify(modelMapper).map(anyList(), any());

        Assert.assertEquals(result, "candidateview");
    }

    @Test
    public void testGetCandidateDetails() {
        // Mock data
        Candidate candidate = new Candidate();
        candidate.setCandId(1);

        when(candidateDAO.getCandidateById(1)).thenReturn(candidate);
        when(modelMapper.map(anyList(), any())).thenReturn(new ArrayList<CandidateIO>());

        // Test method
        String result = candidateController.getCandidateDetails(1, model);

        // Verify the interactions and assertions
        verify(candidateDAO).getCandidateById(1);
        verify(modelMapper).map(anyList(), any()); // Update the verification here

        Assert.assertEquals(result, "viewcandidate");
    }


    @Test
    public void testAddCandidates() {
        // Test method
        String result = candidateController.addCandidates(model);

        // Verify the interactions and assertions
        Assert.assertEquals(result, "candidate");
    }

    @Test
    public void testListOfCandidatesAfterInsertion() {
        // Mock data
        Candidate candidate = new Candidate();

        when(candidateDAO.getAllCandidates()).thenReturn(new ArrayList<>());
        when(modelMapper.map(anyList(), any())).thenReturn(new ArrayList<CandidateIO>());

        // Test method
        String result = candidateController.listOfCandidatesAfterInsertion(candidate, null, model);

        // Verify the interactions and assertions
        verify(candidateDAO).saveCandidate(candidate);
        verify(candidateDAO).getAllCandidates();
        verify(modelMapper).map(anyList(), any());

        Assert.assertEquals(result, "update");
    }
}
