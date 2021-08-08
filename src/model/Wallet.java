package model;

public class Wallet {
    
    public static final int CAPACIDAD_MAXIMA = 1000000;

    private int saldo;
    private boolean tieneLimite;
    private int meta;

    public Wallet() {
        super();
        saldo = 0;  
        tieneLimite = true;
        meta = 0;
    }

    public int getSaldo(){
        return saldo;
    }
    
    public boolean establecerMeta(int value){
        if (value==0){
            meta = value;
            return true;
        }
        if (value < 0 || value <= saldo || value > CAPACIDAD_MAXIMA && tieneLimite) {
            return false;
        }
        meta = value;
        return true;
    }

    public boolean verificarMeta(){
        if(meta == 0 || meta > saldo){
            return false;
        }       
        return true;    

    }

    public boolean getTieneLimite (){
        return tieneLimite;
    }
    public void setTieneLimite(boolean  newTieneLimite) {
        this.tieneLimite = newTieneLimite;
    }
    public String saveMoney(int value) {
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite) {
            return "No se puede superar el limite " + CAPACIDAD_MAXIMA;
        }    
        saldo += value; // saldo = saldo + value
        if (verificarMeta()){System.out.println("Has cumplido la meta");}
        return "Transaccion exitosa, nuevo saldo " + saldo;
    }     

    public String takeMoney (int value) {
        if (saldo >= value) {
            saldo -= value;
            return  "Transaccion exitosa, nuevo saldo " + saldo;
        }
        return "Saldo insuficiente"; 
    }

    public String breakLimits() {   
        if(!tieneLimite) {
            return "Tu cuenta no tiene limites!";
        }    
        if (saldo >= 10000) {
            saldo -= 10000; 
            setTieneLimite(false); //Tiene Limites = False
            return "Has roto los limites";
        }
        return "No tienes saldo suficiente :( ";
    }

}
       
