package service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CandidateDataModel {
    private List<Candidate> candidates;
    private int allVotes;

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public CandidateDataModel(List<Candidate> candidates){
        this.candidates = candidates;
    }

    public void generateAllVotes(){
        for (int i = 0; i < candidates.size(); i++) {
            allVotes = allVotes + candidates.get(1).getVotes();
        }
    }

    public void setAllVotes(int allVotes) {
        this.allVotes = allVotes;
    }

    public int getAllVotes() {
        generateAllVotes();
        return allVotes;
    }
}
