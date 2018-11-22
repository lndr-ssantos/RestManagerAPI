/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leand
 */
public class UtilsServlet {
    public static void writeJSON (HttpServletResponse response, String json) throws IOException {
        if (json != null) {
            PrintWriter wr = response.getWriter();
            response.setContentType("application/json;charset=UTF-8");
            wr.write(json);
            wr.close();
        }
    }
    
}
