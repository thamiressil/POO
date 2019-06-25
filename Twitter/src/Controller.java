import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Sistema sistema = new Sistema();
		while (true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");

			try {
				if (ui[0].equals("end"))
					break;
				else if (ui[0].equals("addUser")) {
					sistema.addUsuario(ui[1]);
				} else if (ui[0].equals("showUser")) {
					System.out.println(sistema);
				} else if (ui[0].equals("seguir")) {
					Usuario one = sistema.getUsuario(ui[1]);
					Usuario two = sistema.getUsuario(ui[2]);
					one.seguir(two);
				} else if (ui[0].equals("abandonar")) {
					Usuario one = sistema.getUsuario(ui[1]);
					Usuario two = sistema.getUsuario(ui[2]);
					one.abandonar(two);
				} else if (ui[0].equals("twittar")) {
					String msg = "";
					for (int i = 2; i < ui.length; i++)
						msg += ui[i] + " ";
					sistema.twittar(ui[1], msg);
				} else if (ui[0].equals("timeline")) {
					Usuario user = sistema.getUsuario(ui[1]);
					for (int i = 0; i < user.timeline.size(); i++) {
						System.out.println(user.timeline.get(i).toString());
					}
				} else if (ui[0].equals("myTweets")) {
					Usuario user = sistema.getUsuario(ui[1]);
					for (int i = 0; i < user.myTweets.size(); i++) {
						System.out.println(user.timeline.get(i).toString());
					}
				} else if (ui[0].equals("unread")) {
					Usuario user = sistema.getUsuario(ui[1]);
					user.getUnread();
				}else if (ui[0].equals("getTweet")) {
					System.out.println(sistema.getTwitter(Integer.parseInt(ui[1])));
				}

			} catch (RuntimeException rt) {
				System.out.println(rt.getMessage());
			}
		}
	}

}