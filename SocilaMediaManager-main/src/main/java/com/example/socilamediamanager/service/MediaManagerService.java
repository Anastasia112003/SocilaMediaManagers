package com.example.socilamediamanager.service;

import com.example.socilamediamanager.dto.InfluencerDTO;
import com.example.socilamediamanager.mapper.InfluencerMapper;
import com.example.socilamediamanager.model.Influencer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MediaManagerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private InfluencerMapper influencerMapper;


    public MediaManagerService(KafkaTemplate<String, Object> kafkaTemplate, InfluencerMapper influencerMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.influencerMapper = influencerMapper;
    }

    public void sendTo(Influencer influencer) {
        InfluencerDTO dto = influencerMapper.toDto(influencer);
        Influencer influencerForSend = influencerMapper.toEntity(dto);
        kafkaTemplate.send("managerToInfluencer", dto);
        kafkaTemplate.send("managerToSubscriber1", dto);
        System.out.println(influencerForSend + " is sent");
    }


}


