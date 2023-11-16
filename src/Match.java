import java.util.UUID;

public class Match {
    private UUID id;
    private MatchType matchType;
    private Double rateA;
    private Double rateB;

    public Match(UUID id) {
        this.id = id;
    }

    public Match(UUID id, String rateA, String rateB, String matchType) {
        this.id = id;
        this.matchType = MatchType.valueOf(matchType);
        this.rateA = Double.parseDouble(rateA);
        this.rateB = Double.parseDouble(rateB);
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public Double getRateA() {
        return rateA;
    }

    public void setRateA(Double rateA) {
        this.rateA = rateA;
    }

    public Double getRateB() {
        return rateB;
    }

    public void setRateB(Double rateB) {
        this.rateB = rateB;
    }
}
