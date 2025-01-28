package com.prosoft.util;

import org.atpfivt.ljv.LJV;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;

public class Ljv {

    public static void browse(Object obj) {
        try {
            LJV ljv = new LJV();
            var dot = URLEncoder.encode(ljv.drawGraph(obj), "UTF8").replaceAll("\\+", "%20");
            Desktop.getDesktop().browse(new URI("https://dreampuf.github.io/GraphvizOnline/#" + dot));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}