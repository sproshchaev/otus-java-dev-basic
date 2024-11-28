package com.prosoft;

import org.atpfivt.ljv.LJV;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class BrowseStructure {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");

        browse(new LJV(), map);

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
































