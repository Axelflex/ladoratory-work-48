import Server.BasicServer;
import Server.Utils;
import com.sun.net.httpserver.HttpExchange;
import service.*;

import java.io.IOException;
import java.util.Map;

public class VoteMachine extends BasicServer {

    private CandidateService service;
    public VoteMachine(String host, int port) throws IOException {
        super(host, port);
        service = new CandidateService();
        registerGet("/", this::mainHandler);
        registerPost("/thankyou", this::thankyouHandler);
        registerGet("/votes", this::votesHandler);
    }

    private void votesHandler(HttpExchange exchange) {
        renderTemplate(exchange, "votes.html",  new CandidateDataModel(service.getAllCandidates()));
    }


    private void thankyouHandler(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        int id = Integer.parseInt(parsed.get("candidateId"));
        Candidate candidate = service.getCandidate(id);


        renderTemplate(exchange, "thankyou.html", getSingleCandidate(candidate));
    }

    private void mainHandler(HttpExchange exchange){
        renderTemplate(exchange, "candidates.html", new CandidateDataModel(service.getAllCandidates()));
    }

    private SingleCandidateDataModel getSingleCandidate(Candidate candidate){
        SingleCandidateDataModel singleCandidateDataModel = new SingleCandidateDataModel(candidate);
        singleCandidateDataModel.getVoted(candidate);

        CandidateDataModel candidateDataModel = new CandidateDataModel(service.getAllCandidates());

        candidate.setAllVotes(candidateDataModel.getAllVotes());
        return singleCandidateDataModel;
    }

}
