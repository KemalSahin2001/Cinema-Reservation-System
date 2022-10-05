import java.util.ArrayList;

public class Hall{
    private Film film;
    private ArrayList<Seat> seats = new ArrayList<>();;
    private String hallname;
    private Integer price_per_seat;
    private Integer row;
    private Integer column;
    public Hall(Film film, String hallname, Integer price_per_seat, Integer row, Integer column) {
        this.film = film;
        this.hallname = hallname;
        this.price_per_seat = price_per_seat;
        this.row = row;
        this.column = column;
    }
    public Hall() {
    }
    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
    public String getHallname() {
        return hallname;
    }
    public void setHallname(String hallname) {
        this.hallname = hallname;
    }
    public Integer getPrice_per_seat() {
        return price_per_seat;
    }
    public void setPrice_per_seat(Integer price_per_seat) {
        this.price_per_seat = price_per_seat;
    }
    public Integer getRow() {
        return row;
    }
    public void setRow(Integer row) {
        this.row = row;
    }
    public Integer getColumn() {
        return column;
    }
    public void setColumn(Integer column) {
        this.column = column;
    } 
}
