package com.prosoft;

import org.atpfivt.ljv.LJV;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;

public class BrowseStructure {

    public static void main(String[] args) {


        // int[] array = {10, 20, 30};

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);

        browse(new LJV(), list);

    }































    public static void browse(LJV ljv, Object obj) {
        try {
            var dot = URLEncoder.encode(ljv.drawGraph(obj), "UTF8")
                    .replaceAll("\\+", "%20");
            Desktop.getDesktop().browse(
                    new URI("https://dreampuf.github.io/GraphvizOnline/#"
                            + dot));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
