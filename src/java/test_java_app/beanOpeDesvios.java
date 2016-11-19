package test_java_app;

public class beanOpeDesvios {
    private String idOperario;
    private int desviosOK;
    private int desviosTotal;

    public beanOpeDesvios() {
    }

    public beanOpeDesvios(String idOperario, int desviosOK, int desviosTotal) {
        this.idOperario = idOperario;
        this.desviosOK = desviosOK;
        this.desviosTotal = desviosTotal;
    }
//get-setters
    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public int getDesviosOK() {
        return desviosOK;
    }

    public void setDesviosOK(int desviosOK) {
        this.desviosOK = desviosOK;
    }

    public int getDesviosTotal() {
        return desviosTotal;
    }

    public void setDesviosTotal(int desviosTotal) {
        this.desviosTotal = desviosTotal;
    }

    @Override
    public String toString(){
        return idOperario+" "+String.valueOf(desviosOK)+" "+String.valueOf(desviosTotal);
    }
    

    
}
