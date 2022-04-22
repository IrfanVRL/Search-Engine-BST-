package com.mycompany.desktopsearchengine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author irfan
 */
public class IrfanVuralmain {

    public static void main(String[] args) throws IOException {
        IrfanVuralBinaryTree tr = new IrfanVuralBinaryTree();

        File file = new File("cse22505.html");
        File fileIgnore = new File("ignoreList.txt");

        Scanner sc = new Scanner(file);
        Scanner sci = new Scanner(fileIgnore);
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        ArrayList<String> ignoreList = new ArrayList<String>();
        while (sci.hasNext()) {
            String nextword = sci.next();
            ignoreList.add(nextword);
        }
        sc.useDelimiter("[^A-Za-z]+");

        try {

            while (sc.hasNext()) {
                String nextword = sc.next();
                if (ignoreList.contains(nextword) || nextword.equals("DOC") || nextword.equals("AUTHOR")
                        || nextword.equals("BIBLIO") || nextword.equals("DOCNO")
                        || nextword.equals("TITLE") || nextword.equals("TEXT")) {
                    continue;
                } else if (words.contains(nextword)) {
                    int index = words.indexOf(nextword);
                    count.set(index, count.get(index) + 1);

                } else {
                    tr.insert(nextword);
                    words.add(nextword);
                    count.add(1);

                }
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }

        tr.writeFile();

    }
}
