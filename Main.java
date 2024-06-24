import app_enum.DSizeEnum;
import app_enum.SizeEnum;
import app_enum.TypeEnum;

public class Main {

    public static void main(String[] args) {
        // pour tester, lancer en ligne de commande :
        // java Program "assiette" "couscous" "coca" "moyen" "baba" "normal" "yes"
        // Note: Make sure the class name matches the file name when compiling and running in Java.
        App app = new App();
        int price = app.Compute(TypeEnum.valueOf(args[0].toUpperCase()), args[1], args[2], SizeEnum.valueOf(args[3].toUpperCase()), args[4], DSizeEnum.valueOf(args[5].toUpperCase()), args[6].equals("yes"));
        System.out.println("Prix à payer : " + price + "€");
    }
}