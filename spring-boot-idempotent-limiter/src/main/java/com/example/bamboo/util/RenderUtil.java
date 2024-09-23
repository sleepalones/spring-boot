package com.example.bamboo.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author brotherming
 * @createTime 2024年08月07日 20:45:00
 */
public class RenderUtil {

    public static void render(HttpServletResponse response, Map<String, Object> meg) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        ServletOutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(meg);
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

}
