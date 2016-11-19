package test_java_app;

public class operarioHorasExtra {
    private String idOperario;
    private Double horasExtra;
//Constructores
    public operarioHorasExtra() {
    }
    
    public operarioHorasExtra(String idOperario, Double horasExtra) {
        this.idOperario = idOperario;
        this.horasExtra = horasExtra;
    }

//Get-seters

    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public Double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(Double horasExtra) {
        this.horasExtra = horasExtra;
    }
    
    @Override
    public String toString(){
        return idOperario+" "+horasExtra;
    }   
        
    
    
}
