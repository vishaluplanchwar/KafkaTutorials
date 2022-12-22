package com.vishaluplanch.org;


import com.vishaluplanch.org.pojo.LoanDetailPojo;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PojoToAvroConverter {

    public static void main(String[] args) throws IOException {
        Schema schema = ReflectData.get().getSchema(LoanDetailPojo.class);
        File schemaFile = new File("src/main/resources/loan-detail.avsc");
        FileWriter fileWriter = new FileWriter(schemaFile);
        fileWriter.append(schema.toString(true));
        fileWriter.close();
    }
}
