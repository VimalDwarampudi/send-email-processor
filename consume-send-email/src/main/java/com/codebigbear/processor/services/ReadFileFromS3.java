package com.codebigbear.processor.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ReadFileFromS3 {

    public String readFile(String key) {
        //    Create AmazonS3Client.
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("S3BucketAccessKey", "secretKey");
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion("region_name_here").build();

        // Create S3Object using bucket name and key.
        S3Object object = s3Client.getObject(new GetObjectRequest("bucketName", key));
        String html = null;

        try {
            //    Create buffer reader using S3Object and read file line by line.
            BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));

            while ((html = reader.readLine()) != null) {
                System.out.println(html);
                //your business logic here
            }

         } catch (IOException ex) {
            System.out.println(ex.getMessage());
         }
         return html;
    }

}