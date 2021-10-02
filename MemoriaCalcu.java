/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;

/**
 *
 * @author Joctan Esquivel
 */
public class MemoriaCalcu {
    
    private int indice = 0;
    private ArrayList <Double> memory= new ArrayList <Double>();
    
    public void addMemory(double resul){
            try {
                    if(indice<10){
                        this.memory.set(indice, resul);
                        indice++;
                    }else{
                        this.indice=0;
                        this.memory.set(indice, resul);
                        indice++;
                    } 
            }catch (Exception NullPointerException) {
                this.memory.add(indice, resul);
                indice++;
             }   
    }
    
    
    public double promedio(){
        double resultadoSumas = 0;
        
        for (Double numero : memory) {
            resultadoSumas+=numero;  
        }
        return resultadoSumas/this.memory.size();
    }
    
    public boolean isEmpty(){
        return memory.isEmpty();
    }
    
    
}
