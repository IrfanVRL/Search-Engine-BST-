/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desktopsearchengine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author irfan
 */
public class IrfanVuralBinaryTree {

    IrfanVuralNode root;
    IrfanVuralmain word = new IrfanVuralmain();

    void insert(String newData) {
        IrfanVuralNode newNode = new IrfanVuralNode(newData);

        if (root == null) {
            root = newNode;
        } else {
            IrfanVuralNode temp = root;

            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return;
                    }

                    temp = temp.right;
                } else if (newData.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return;
                    }

                    temp = temp.left;
                } else {
                    return;
                }
            }

        }
    }

  

    void writeFile() {
        writeFile(root);
    }

    public void writeFile(IrfanVuralNode mainNode) {
        FileOutputStream output = null;
        PrintWriter pw = null;

        try {

            output = new FileOutputStream("output.txt");
            pw = new PrintWriter(output);

            write(mainNode, pw);

            pw.flush();

        } catch (IOException e) {
            System.out.println("An error occured");
            pw.close();
        }

    }

    public void write(IrfanVuralNode mainNode, PrintWriter w) {
        if (mainNode != null) {
            w.println(mainNode.data);
            write(mainNode.left, w);
            write(mainNode.right, w);
        }
    }
}
