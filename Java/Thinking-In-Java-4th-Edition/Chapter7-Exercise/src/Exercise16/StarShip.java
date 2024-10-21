package Exercise16;

class AlertStatus {
    public void Alert() {} 
}

class FireAlert extends AlertStatus {
    public void Alert() {System.out.println("Fire!!!");}
}

class FloodAlert extends AlertStatus {
    public void Alert() {System.out.println("Flood!!");}
}

class ExplosionAlert extends AlertStatus {
    public void Alert() {System.out.println("Boom!");}
}

class Stage {
    private AlertStatus alertStatus = new FireAlert();
   
    public void change(int i) {
        switch (i) {
            case 0:
                alertStatus = new FireAlert();
                break;

            case 1:
                alertStatus = new FloodAlert();
                break;

            case 2:
                alertStatus = new ExplosionAlert();
                break;

            default:
                break;
        }

    }

    public void perfromAlert() { alertStatus.Alert(); }
}

public class StarShip {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.change(0);
        stage.perfromAlert();
        stage.change(1);
        stage.perfromAlert();
        stage.change(2);
        stage.perfromAlert();
    }
}