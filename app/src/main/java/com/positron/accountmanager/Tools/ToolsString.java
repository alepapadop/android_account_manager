package com.positron.accountmanager.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by alepapadop on 4/1/16.
 *
 * add here functions related to string operations
 *
 */
public class ToolsString {

    public String stream_to_str(InputStream stream) throws IOException {

        /* Try to find an optimized process for this to work */

        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(stream));

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        br.close();

        return sb.toString();
    }
}
