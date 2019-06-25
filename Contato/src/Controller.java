/*
 * 
 * LINE 32 - UI[0] = "atualizar"
 * 
 * Aparece erro de index porém ele ainda atualiza
 * 
 * 
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        Contato contato = new Contato(null);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            try {
                if (ui[0].equals("end")) {
                    break;
                } 
                else if (ui[0].equals("init")) {
                    contato = new Contato(ui[1]);
                }
                
                else if (ui[0].equals("adicionar")) {
                	contato.inserir_telefone(ui[1], contato.matches(ui[2]));
                	                	
                } 
                else if (ui[0].equals("atualizar")) {
                	contato = null;
                	contato = new Contato(ui[1]);
                	int i = 2;
                	while(ui[i]!= "") {
                		contato.inserir_telefone(ui[i], contato.matches(ui[++i]));
                		i++;
                	}
                } 
                else if (ui[0].equals("show")) {
                    System.out.println(contato);
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
