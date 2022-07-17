package com.codebigbear.processor.consumer;

import com.codebigbear.avro.Email;
import com.codebigbear.processor.exceptions.CustomException;
import com.codebigbear.processor.services.EmailService;
import com.codebigbear.processor.services.ReadFileFromS3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverAndSend {

    private static final Logger LOG = LoggerFactory.getLogger(ReceiverAndSend.class);


    @Autowired
    EmailService sendGridEmailService;

    @Autowired
    ReadFileFromS3 readFileFromS3;

    private String htmlBody;

    @KafkaListener(topics = "${app.topic.receive}", groupId = "sendGrid")
    public void receive(Email email ) {

        try {
            handleMessage(email);

        } catch (CustomException e) {
            e.printStackTrace();
            LOG.error("Exception caught. Not committing offset to Kafka.");
        }
    }


    private void handleMessage(Email message) throws CustomException {

        // read the html from S3
        htmlBody = readFileFromS3.readFile(message.getTemplateId());
        // send email through sendGrid
        sendGridEmailService.sendHTML("abc@gmail.com", message.getEmailId(), "Hello World", htmlBody);

    }
    }

