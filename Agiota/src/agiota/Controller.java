package agiota;

import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            try {
                if (ui[0].equals("end")) {
                    break;
                } 
                else if (ui[0].equals("init")) {
                    sistema = new Sistema(Float.parseFloat(ui[1]));
                }
                else if (ui[0].equals("cadastrar")) {
                    String id = ui[1];
                    String[] subarray = Arrays.copyOfRange(ui, 2, ui.length);
                    String fullname = String.join(" ", subarray);
                    sistema.cadastrar(new Cliente(id, fullname));

                } 
                else if (ui[0].equals("emprestar")) {
                    sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
                } 
                else if (ui[0].equals("historico")) {
                    for (Transacao tr : sistema.getHistorico())
                        System.out.println(tr);
                }  
                else if (ui[0].equals("showClient")) {
                    sistema.showClient(ui[1]);
                }  
                else if (ui[0].equals("receber")) {
                    sistema.receber(ui[1], Float.parseFloat(ui[2]));
                }
                else if (ui[0].equals("matar")) {
                    sistema.matar(ui[1]);
                }
                
                else if (ui[0].equals("show")) {
                    System.out.println(sistema);
                } 
            
            
                else {
                    System.out.println("fail: comando invalido");
                }
            }catch(RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
    }

}
