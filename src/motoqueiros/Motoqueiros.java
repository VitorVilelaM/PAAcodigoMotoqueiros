package motoqueiros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author vitor
 */
public class Motoqueiros {

    public static void main(String[] args) {
        int i, aux, aux1, aux2, m1 = 0, m2 = 0, tempo = 0, max, n1, n2;
        ArrayList<Integer> entregas = new ArrayList<Integer>();
        ArrayList<Integer> mot1 = new ArrayList<Integer>();
        ArrayList<Integer> mot2 = new ArrayList<Integer>();

        List<String> dados = FileManager.stringReader("./exemplo.txt");

        for (i = 0; i < dados.size(); i++) {
            aux = Integer.parseInt(dados.get(i));
            entregas.add(aux);
        }

        Collections.sort(entregas);
        
        n1 = entregas.remove(entregas.size()-1);
        n2 = entregas.remove(entregas.size()-1);
        
        
        aux1 = entregas.remove(0);
        aux2 = entregas.remove(0);
        i = 0;
        
        
        while (entregas.get(i) < (aux1 + aux2) + ((aux1 + aux2) / 2)) {
            i++;
        }

        mot1.add(aux1);
        mot1.add(aux2);
        mot2.add(entregas.remove(i));

        while (!entregas.isEmpty()) {

            if (entregas.size() > 3) {

                aux1 = entregas.remove(0);
                aux2 = entregas.remove(0);

                i = 0;

                max = entregas.size() - 1;

                while (entregas.get(i) <= (aux1 + aux2)) {
                    i++;
                }

                mot1.add(aux1);
                mot1.add(aux2);
                mot2.add(entregas.remove(i));

            } else if (entregas.size() == 3) {
                mot1.add(entregas.remove(0));
                mot2.add(entregas.remove(0));
                mot1.add(entregas.remove(0));

            } else if (entregas.size() == 2) {
                mot1.add(entregas.remove(1));
                mot2.add(entregas.remove(0));
            } else {
                mot1.add(entregas.remove(0));
            }
        }

        Collections.sort(mot1);
        Collections.sort(mot2);

        for (i = 0; i < mot1.size(); i++) {
            m1 += (mot1.get(i) * 2);
        }

        for (i = 0; i < mot2.size() ; i++) {
            m2 += (mot2.get(i) * 2);
        }
        
        if (m1 > m2) {
            mot1.add(n2);
            m1 += n2;
            
            mot2.add(n1);
            m2 += n1;
        } else {
            m2 += n2;
            mot2.add(n2);
            
            m1 += n1;
            mot1.add(n1);
        }
        
        if (m1 > m2) {
            tempo = m1;
        } else {
            tempo = m2;
        }
        System.out.println("==> Melhor Tempo: " + tempo);

        System.out.println("*Moto 1");
        for (i = 0; i < mot1.size(); i++) {
            System.out.println(mot1.get(i));
        }

        System.out.println("*Moto 2");
        for (i = 0; i < mot2.size(); i++) {
            System.out.println(mot2.get(i));
        }
    }

}
