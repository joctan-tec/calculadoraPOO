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
    String path = "C:\\Users\\Joctan Esquivel\\Documents\\TEC\\Semestre II\\POO\\calculadora\\Bitacora.txt";
    Data archivo = new Data();
         
    
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
                    archivo.createFile(path);
                    archivo.writeToFile(path, "M+ "+resul+" > " + this.leeMemoria()+"\n");
            }catch (Exception NullPointerException) {
                this.memory.add(indice, resul);
                archivo.createFile(path);
                archivo.writeToFile(path, "M+ "+resul+" > " + this.leeMemoria()+"\n");
                indice++;
             }   
    }
    
    
    public double promedio(){
        double resultadoSumas = 0;
        
        for (Double numero : memory) {
            resultadoSumas+=numero;  
        }
        double resulPromedio = resultadoSumas/this.memory.size();
        archivo.createFile(path);
        archivo.writeToFile(path, "Avg "+ this.leeMemoria() +"   =   "+resulPromedio+"\n");
        
        return resulPromedio;
    }
    
    public boolean isEmpty(){
        return memory.isEmpty();
    }
    
    private String leeMemoria(){
        String resultado = "";
        
        for (double numero : memory){
            resultado+= numero+" ";     
        }
        return resultado.substring(0, resultado.length()-1);
    }
    
    
}
