package recupracion.proyect.estadios.modelos;

public class Schedule {
    private String end_date;
    private String start_date;


    public Schedule(String end_date, String start_date) {
        this.end_date = end_date;
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getStart_date() {
        return start_date;
    }


}
