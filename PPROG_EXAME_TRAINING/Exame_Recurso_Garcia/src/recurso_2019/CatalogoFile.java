/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurso_2019;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class CatalogoFile implements Serializable {
    
    public static final String FILE_NAME = "CatalogoList.txt";
     
    public CatalogoFile() {
    }

    public CatalogoDeSoftware read() {
        return read(FILE_NAME);
    }

    public CatalogoDeSoftware read(String fileName) {
        return read(new File(fileName));
    }

    public CatalogoDeSoftware read(File file) {
        CatalogoDeSoftware catalogo;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            try {
                catalogo = (CatalogoDeSoftware) in.readObject();
            } finally {
                in.close();
            }
            return catalogo;
        } catch (IOException | ClassNotFoundException ex) {
            return new CatalogoDeSoftware();
        }
    }

    public boolean save(CatalogoDeSoftware catalogo) {
        return save(FILE_NAME, catalogo);
    }
    
    public boolean save(String fileName, CatalogoDeSoftware catalogo) {
        return save(new File(fileName), catalogo);
    }

    public boolean save(File file, CatalogoDeSoftware catalogo) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
            try {
                out.writeObject(catalogo);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
