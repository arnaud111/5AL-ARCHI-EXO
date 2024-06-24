import app_enum.DSizeEnum;
import app_enum.SizeEnum;
import app_enum.TypeEnum;

public class App {

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int Compute(TypeEnum type, String name, String beverage, SizeEnum size, String dessert, DSizeEnum dsize, boolean coffee) {
        // prix total à payer pour le client
        int total = 0;

        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (name == null || name.isEmpty()) return -1;

        switch (type) {
            case TypeEnum.ASSIETTE:
                total += this.ComputeAssiette(size, dsize);
                break;
            case TypeEnum.SADWITCH:
                total += this.ComputeSadwitch(size, dsize);
                break;
        }

        if (type == TypeEnum.ASSIETTE && size == SizeEnum.MOYEN && dsize == DSizeEnum.NORMAL && coffee) {
            System.out.print(" avec café offert!");
        } else {
            // Assume coffee costs 1 unit, adding to the total only if coffee is not included
            if (coffee) {
                total += 1;
            }
        }

        return total;
    }

    public int ComputeAssiette(SizeEnum size, DSizeEnum dsize) {
        int total = 15;

        if (size == SizeEnum.MOYEN && dsize == DSizeEnum.NORMAL) {
            return 18;
        }
        if (size == SizeEnum.GRAND && dsize == DSizeEnum.SPECIALE) {
            return 21;
        }

        switch (size) {
            case SizeEnum.PETIT -> total += 2;
            case SizeEnum.MOYEN -> total += 3;
            case SizeEnum.GRAND -> total += 4;
        }

        switch (dsize) {
            case DSizeEnum.NORMAL -> total += 2;
            case DSizeEnum.SPECIALE -> total += 4;
        }

        return total;
    }

    public int ComputeSadwitch(SizeEnum size, DSizeEnum dsize) {
        int total = 10;

        // ainsi qu'une boisson de taille:
        if (size == SizeEnum.PETIT) {
            total += 2;
            // dans ce cas, on applique la formule standard
            if (dsize == DSizeEnum.NORMAL) {
                // pas de formule
                // on ajoute le prix du dessert normal
                total += 2;
            } else {
                // sinon on rajoute le prix du dessert special
                total += 4;
            }
            // si on prends moyen
        } else if (size == SizeEnum.MOYEN) {
            total += 3;
            // dans ce cas, on applique la formule standard
            if (dsize == DSizeEnum.NORMAL) {
                // j'affiche la formule appliquée
                System.out.print("Prix Formule Standard appliquée ");
                // le prix de la formule est donc 13
                total = 13;
            } else {
                // sinon on rajoute le prix du dessert special
                total += 4;
            }
        } else if (size == SizeEnum.GRAND) {
            total += 4;
            // dans ce cas, on applique la formule standard
            if (dsize == DSizeEnum.NORMAL) {
                // pas de formule
                // on ajoute le prix du dessert normal
                total += 2;
            } else {
                // dans ce cas on a la fomule max
                System.out.print("Prix Formule Max appliquée ");
                total = 16;
            }
        }

        return total;
    }
}