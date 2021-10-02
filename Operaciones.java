/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Joctan Esquivel
 */
public class Operaciones {
    private double numero1;
    private double numero2;
    // 1 = suma
    // 2 = resta
    // 3 = multiplicacion
    // 4 = division
    private int signo;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    
    public Operaciones(String screen){
       this.setNumero1(this.getNum1(screen));
       this.setNumero2(this.getNum2(screen));
       this.setSigno(this.getSigno(screen));
       
        
    }
    
    public double getResultado(){
        String path = "C:\\Users\\Joctan Esquivel\\Documents\\TEC\\Semestre II\\POO\\calculadora\\Bitacora.txt";
         Data archivo = new Data();
         archivo.createFile(path);
        double resultado;
        switch (this.signo){
            case 1:
                resultado= this.numero1+this.numero2;
                archivo.writeToFile(path, this.numero1+" + "+this.numero2+" = "+resultado+"\n");
                
                return resultado;
              
            case 2:
               resultado= this.numero1-this.numero2;
               archivo.writeToFile(path, this.numero1+" - "+this.numero2+" = "+resultado+"\n");
               return resultado;
            case 3:
                resultado= this.numero1*this.numero2;
                archivo.writeToFile(path, this.numero1+" * "+this.numero2+" = "+resultado+"\n");
                return resultado;
            case 4:
                if (this.numero2!=0){
                    resultado= this.numero1/this.numero2;
                    archivo.writeToFile(path, this.numero1+" / "+this.numero2+" = "+resultado+"\n");
                    return resultado;
                }
                
                
            
        }
        return resultado=0;
    }
    
    
    
    
    
    public double getNum1(String screen){
        String result="";
        boolean numeroNegativo = false;
        
        try{
            Double resultadoFinal = Double.parseDouble(screen);
            return resultadoFinal;
        }catch(Exception e){
            
        }
        
        String  character;
        for (int i =0; i<screen.length();i++){
             character = screen.substring(i, i+1);
             if (character.equals("/") | character.equals("*") |
                  character.equals("+") | character.equals("-") ){
                 if (i==0){
                     numeroNegativo=true;
                     continue;
                 }
                  Double resultadoFinal = Double.parseDouble(result);
                  if (numeroNegativo){
                      return resultadoFinal*-1;
                  }
                  return resultadoFinal;
             }else{
                 result+=character;
             }
         }
        return 0;
        
    }
    
    public double getNum2(String screen){
        String result;
        
        String  character;
        for (int i =0; i<screen.length();i++){
             character = screen.substring(i, i+1);
             if (character.equals("/") | character.equals("*") |
                  character.equals("+") | character.equals("-") ){
                 if (i==0){
                     continue;
                 }
                  result = screen.substring(i+1);
                  //System.out.println(result);
                  if (result.equals("")==false){
                      Double resultadoFinal = Double.parseDouble(result);
                      return resultadoFinal;
                  }
                  int resultadoFinal = 0;
                  
                  
                  return resultadoFinal;

             
         }
         
    }
        
         
         return 0;
        
    }
    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

   

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public int getSigno(String screen) {
        String result="";
        
        String  character;
        for (int i =0; i<screen.length();i++){
             character = screen.substring(i, i+1);
             if (character.equals("/") | character.equals("*") |
                  character.equals("+") | character.equals("-") ){
                  if (i==0 & character.equals("-")){
                      continue;
                  }
                  result = character;
                  break;
             
         }
        }
        int signo;
        
        if (result.equals("+")){
            return 1;      
        }
        else if (result.equals("-")){
            return 2;
        }
        else if (result.equals("*")){
            return 3;
        }
        else if (result.equals("/")){
            return 4;
        }
       
    
         return 0;
    }

    public void setSigno(int signo) {
        this.signo = signo;
}
    
    public boolean existeUnNumero(double num1, double num2, int signo1 ){
        
         if (num1 != 0 & num2==0 & signo1==0){
             return true;
             
         }else if (num1<0 & signo1==2){
             return true;
         }else if (signo1!=0 & num1!=0){
             return false;
         }else if (signo1!=0 & num1==0 & num2==0){
             return false;
             // 10    // 10-   // -   //10-7  //   10-7- 
         }else if (signo1!=0 & num1!=0 & num2!=0){
             return false;
             // 10    // 10-   // -   //10-7  //   10-7- 
         }
         
         return false;
        
    }
    
    public boolean existenDosNumero(double num1, double num2, int signo1 ){
        
         if (num1 != 0 & num2!=0 & signo1!=0 ){
             return true;
         }else{
             return false;
         }
         
        
    }
    
    public int convertirAEntero(String screen){
        try{
            Double num =    Double.parseDouble(screen);
            
            int resul;
            resul = (int)(num-num%1);
            return resul;
        }
        catch(Exception e){
            return -54564457;
        }
    }
    
    public String toBinary(String numero){
        String path = "C:\\Users\\Joctan Esquivel\\Documents\\TEC\\Semestre II\\POO\\calculadora\\Bitacora.txt";
        Data archivo = new Data();
        archivo.createFile(path);
        if (this.existeUnNumero(this.numero1,this.numero2,this.signo)){
            int numeroConvertido = this.convertirAEntero(numero);
            if (numeroConvertido==-54564457){
                return "ERROR";
            }
            String binario = Integer.toBinaryString(numeroConvertido);
            
            archivo.writeToFile(path, "Binario " + numeroConvertido + " = "+binario+"\n");
            return binario;       
        }else if(this.numero1 != 0 & this.numero2!=0 & this.signo!=0){
            try{
                int resultado = (int)this.getResultado();
                String binario = Integer.toBinaryString(resultado);
                archivo.writeToFile(path, "Binario  "+resultado+" = "+ binario +"\n");
            return binario; 
            }catch(Exception e){
                
            }
                 
        }
        return "ERROR";
        
}
    private boolean primo(int numero){
        int contador= 0;
        for (int i =1; i<=numero;i++){
            
            if(numero%i==0){
                contador++;
            }
        }
        
        if (contador==2){
            return true;
        } 
            return false;   
    }
    public String esPrimo(String numero){
        String path = "C:\\Users\\Joctan Esquivel\\Documents\\TEC\\Semestre II\\POO\\calculadora\\Bitacora.txt";
        Data archivo = new Data();
        archivo.createFile(path);
        if (this.existeUnNumero(this.numero1,this.numero2,this.signo)){
            int numeroConvertido = this.convertirAEntero(numero);
            if (numeroConvertido==-54564457){
                return "ERROR";
            }
            if(this.primo(numeroConvertido)){
                 archivo.writeToFile(path, "Primo " + numeroConvertido + " = True\n");
                return "True";
            }
            archivo.writeToFile(path, "Primo " + numeroConvertido + " = False\n");
            return "False";       
        }else if(this.numero1 != 0 & this.numero2!=0 & this.signo!=0){
            try{
                int resultado = (int)this.getResultado();
                 if (resultado==-54564457){
                return "ERROR";
            }
            if(this.primo(resultado)){
                archivo.writeToFile(path, "Primo " + resultado + " = True\n");
                return "True";
            }
            archivo.writeToFile(path, "Primo " + resultado + " = False\n");
             
            return "False"; 
                
                
            }catch(Exception e){
                
            }
                 
        }
        return "ERROR";
    }
    
    
}
