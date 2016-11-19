package test_java_app;

public class beanOpeDias {
    private String idOperario;
    private int dias;
//Constructores
    public beanOpeDias() {
    }

    public beanOpeDias(String idOperario, int dias) {
        this.idOperario = idOperario;
        this.dias = dias;
    }
 
//Get-seters

    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    @Override
    public String toString(){
        return idOperario+" "+String.valueOf(dias);
    }   
        
    
    
}
