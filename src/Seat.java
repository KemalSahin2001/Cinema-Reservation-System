public class Seat{
    private String filmName;
    private String hallName;
    private Integer row_of_seat;
    private Integer column_of_seat;
    private String owner_name;
    private Double price_that_it_has_been_bought;
    private Boolean isBought;
    
    public Seat(String filmName, String hallName, Integer row_of_seat, Integer column_of_seat, String owner_name,
        double price_that_it_has_been_bought) {
        this.filmName = filmName;
        this.hallName = hallName;
        this.row_of_seat = row_of_seat;
        this.column_of_seat = column_of_seat;
        this.owner_name = owner_name;
        if(this.owner_name == null){
            this.price_that_it_has_been_bought = price_that_it_has_been_bought;
        }
        else{
            if(price_that_it_has_been_bought < 0){
                this.price_that_it_has_been_bought = (double) 0;
            }
            else{
                this.price_that_it_has_been_bought = price_that_it_has_been_bought;
            }
        }
        if(this.getOwner_name().equals("null")){
            this.setIsBought(false);
        }
        else{
            this.setIsBought(true);
        }
    }
    public Seat() {
	}
    public Boolean getIsBought() {
        return isBought;
    }
    public void setIsBought(Boolean isBought) {
        this.isBought = isBought;
    }
	public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public String getHallName() {
        return hallName;
    }
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    public Integer getRow_of_seat() {
        return row_of_seat;
    }
    public void setRow_of_seat(Integer row_of_seat) {
        this.row_of_seat = row_of_seat;
    }
    public Integer getColumn_of_seat() {
        return column_of_seat;
    }
    public void setColumn_of_seat(Integer column_of_seat) {
        this.column_of_seat = column_of_seat;
    }
    public String getOwner_name() {
        return owner_name;
    }
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
    public Double getPrice_that_it_has_been_bought() {
        return price_that_it_has_been_bought;
    }
    public void setPrice_that_it_has_been_bought(double d) {
        this.price_that_it_has_been_bought = d;
    }   
}
