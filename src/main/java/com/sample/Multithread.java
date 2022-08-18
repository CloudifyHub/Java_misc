package com.sample;

import okhttp3.*;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Multithread extends Thread {
    private int threadNumber;
    public Multithread (int threadNumber){
        this.threadNumber = threadNumber;
    }
    @Override
    public void run(){
        Random random = new Random();
        long q = random.nextLong();


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"CustomerMobile\": \"233546640723\",\n" +
                "    \"customerName\": \"RICHMOND\",\n" +
                "    \"network\": \"MTN\",\n" +
                "    \"accountRef\": \"Testing\",\n" +
                "    \"paymentRef\": \"MOH\",\n" +
                "    \"amount\": \"60\",\n" +
                "    \"transactionId\":"+q+",\n" +
                "    \"username\": \"cf041b6b-2e57-4df3-8bb7-362ccc94064d\",\n" +
                "    \"password\": \"5a0bcf9a-6dce-4505-a0bd-29c2928430fe\"}" +
                "");
        Request request = new Request.Builder()
                .url("https://eywik85fpyrijct-nonproduction1.adb.uk-london-1.oraclecloudapps.com/ords/mawulepe/momo/test/callback")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();


        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String message = response.body().string();


            JSONObject jsonObject = new JSONObject(message);
            System.out.println(message);
            System.out.println(threadNumber);
            System.out.println(jsonObject.optString("ResponseCode"));

            File f = new File("C:\\Users\\RICHMOND ASAMOAH\\Desktop\\Stress\\response.json");

            if(f.exists()){
                f.delete();
                f.createNewFile();
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(message);
                myWriter.close();
            }
            else {
                f.createNewFile();
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(message);
                myWriter.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

