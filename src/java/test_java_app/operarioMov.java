package test_java_app;

public class operarioMov {
    private String idOperario;
    private int movimientos;
//Constructores    
    public operarioMov(){
    }

    public operarioMov(String idOperario, int movimientos) {
        this.idOperario = idOperario;
        this.movimientos = movimientos;
    }
//Get-seters
    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }
        
    @Override
    public String toString(){
       return idOperario+" "+String.valueOf(movimientos);
    }
    
}
