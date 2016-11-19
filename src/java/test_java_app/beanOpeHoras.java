package test_java_app;

public class beanOpeHoras {
    private String idOperario;
    private Double horas;
//Constructores
    public beanOpeHoras() {
    }
    
    public beanOpeHoras(String idOperario, Double horasExtra) {
        this.idOperario = idOperario;
        this.horas = horasExtra;
    }

//Get-seters

    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public Double getHorasExtra() {
        return horas;
    }

    public void setHorasExtra(Double horasExtra) {
        this.horas = horasExtra;
    }
    
    @Override
    public String toString(){
        return idOperario+" "+String.valueOf(horas);
    }   
        
    
    
}
