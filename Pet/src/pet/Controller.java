package pet;

import java.util.Scanner;

public class Controller {
	public static void switchCase (Pet pet) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("eat");
		System.out.println("play");
		System.out.println("sleep");
		System.out.println("limpar");
		System.out.println("show");
		System.out.println("exit");
		String opcao = scanner.next();
		while(true){
		  if(opcao.equals("show")){
              System.out.println(pet);
              switchCase(pet);
              break;
		  }
		  else if(opcao.equals("eat")){
                pet.eat();
                switchCase(pet);
                break;
          }
		  else if(opcao.equals("play")){
                pet.play();
                switchCase(pet);
                break;
          }
		  else if(opcao.equals("sleep")){
                pet.sleep();
                switchCase(pet);
                break;
          }
		  else if(opcao.equals("limpar")){
              pet.limpar();
              switchCase(pet);
              break;
		  }
		  else if(opcao.equals("exit")){
              	break;
		  }
		  else{
                System.out.println("comando invalido");
                switchCase(pet);
                break;
}
		}
		
	}
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do seu pet: ");
        String nome = scanner.next();
        System.out.println("Digite sua energia: ");
        int energia = scanner.nextInt();
        System.out.println("Digite sua saciedade: ");
        int saciedade = scanner.nextInt();
        System.out.println("Digite sua limpeza: ");
        int limpeza = scanner.nextInt();
        Pet pet = new Pet (nome, energia, saciedade, limpeza);
        switchCase(pet);
      
    }
}
    
    
    
    