public class Balloon {

    private final String color;
    private double psi;

    public Balloon(String color){
        this.color = color;

    }
    public String getColor(){
        return color;
    }

    public double getPsi() {
        if (psi >= 16) {
            return Double.POSITIVE_INFINITY;
        } else {
            return psi;
        }
    }
//    public void setColor(String color) {
//        this.color = color;
//    }

    public void setPsi(double psi) {
        this.psi = psi;
    }

    public void inflate(){
        this.psi = this.psi + Math.random() * 5.0;
    }

    public boolean isExploded(){
        if(psi > 16){
            return true;
        }else{
            return false;
        }
    }


}
