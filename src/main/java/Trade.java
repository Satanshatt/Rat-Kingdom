

public abstract class Trade {
    private String typeOfTrade;

    public Trade(String typeOfTrade){
        this.typeOfTrade = typeOfTrade;
    }

    public void setTypeOfTrade(String typeOfTrade){
        this.typeOfTrade = typeOfTrade;
    }

    public String getTypeOfTrade(){
        return typeOfTrade;
    }
}
