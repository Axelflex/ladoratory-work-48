package service;

public class Candidate {
    private Integer id;
    private String name;
    private String photo;
    private int votes;
    private int allVotes;
    private int percentVotes;

    public int getPercentVotes() {
        return percentVotes;
    }

    public void setPercentVotes() {
        this.percentVotes = (100 * votes) / allVotes;
    }

    public int getAllVotes() {
        return allVotes;
    }

    public void setAllVotes(int allVotes) {
        this.allVotes = allVotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Candidate(Integer id, String name, String photo, int votes, int allVotes) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.votes = votes;
        this.allVotes = allVotes;
    }
}
