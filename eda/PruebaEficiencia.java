/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ifons
 */
public class PruebaEficiencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        try {
            FileReader fr = new FileReader("D:\\EDA\\src\\eda\\business10k.json");
            Censo[] inf = new Censo[10000];
            int cont = 0;
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);
            JSONArray json = (JSONArray) obj;

            for (int i = 0; i < json.size(); i++) {
                JSONObject object = (JSONObject) json.get(i);
                String bus = object.get("business_id").toString();
                String n;
                if (object.get("name") != null) {
                    n = object.get("name").toString();
                } else {
                    n = "";
                }
                String a;
                if (object.get("address") != null) {
                    a = object.get("address").toString();
                } else {
                    a = "";
                }
                String c;
                if (object.get("city") != null) {
                    c = object.get("city").toString();
                } else {
                    c = "";
                }

                String s;
                if (object.get("state") != null) {
                    s = object.get("state").toString();
                } else {
                    s = "";
                }

                String p;
                if (object.get("postal_code") != null) {
                    p = object.get("postal_code").toString();
                } else {
                    p = "";
                }
                double l;
                if (object.get("latitude") != null) {
                    l = Double.parseDouble(object.get("latitude").toString());
                } else {
                    l = -1;
                }
                double lon;
                if (object.get("longitude") != null) {
                    lon = Double.parseDouble(object.get("longitude").toString());
                } else {
                    lon = -1;
                }
                double star;
                if (object.get("star") != null) {
                    star = Double.parseDouble(object.get("star").toString());
                } else {
                    star = -1;
                }
                int rev;
                if (object.get("review_count") != null) {
                    rev = Integer.parseInt(object.get("review_count").toString());
                } else {
                    rev = -1;
                }
                int op;
                if (object.get("is_open") != null) {
                    op = Integer.parseInt(object.get("is_open").toString());
                } else {
                    op = -1;
                }
                String cat;
                if (object.get("categories") != null) {
                    cat = object.get("categories").toString();
                } else {
                    cat = "";
                }

                Censo nuevo = new Censo(bus, n, a, c, s, p, l, lon, star, rev, op, cat);

                inf[cont] = nuevo;
                cont++;
            }

            Censo[] b = new Censo[10000];
            System.arraycopy(inf, 0, b, 0, 10000);
            AlgoritmosOrdenamiento.insertionSortNoRec(b);
            AlgoritmosOrdenamiento.invertir(b);
            System.out.println(inf[0]);
            long startTime = System.nanoTime();
            //System.out.println(AlgoritmosOrdenamiento.quickSort(b));
            //AlgoritmosOrdenamiento.bubbleSort(b);
            //System.out.println(AlgoritmosOrdenamiento.mergeSortO(b));
            //AlgoritmosOrdenamiento.selectionSort(inf);
            //AlgoritmosOrdenamiento.insertionSort(inf);
            //System.out.println(AlgoritmosOrdenamiento.selectionSortNoRec(b));
            System.out.println(AlgoritmosOrdenamiento.insertionSortNoRec(b));
            //System.out.println(AlgoritmosOrdenamiento.bubbleSortNoRec(b));
            long endTime = System.nanoTime() - startTime;
            System.out.println(endTime);
            System.out.println(inf[0]);

        } catch (FileNotFoundException err) {
            System.err.print(err);
            System.exit(-1);
        }
    }

}
