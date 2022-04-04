package com.nsofttask;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSONFromFile {

    JSONParser parser = new JSONParser();

    public void readJson() {
        try (FileReader reader = new FileReader("C:\\Users\\Limitless\\Desktop\\nstask\\Appendix 1 - initial data\\Markets.json")) {
            Object object = parser.parse(reader);

            JSONArray marketList = (JSONArray) object;
            System.out.println(marketList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
