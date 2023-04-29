package com.exemple.spring.jpa.h2.service;

import com.exemple.spring.jpa.h2.exception.TopicNotFoundException;
import com.exemple.spring.jpa.h2.model.Topic;
import com.exemple.spring.jpa.h2.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImp implements TopicServicee{
    @Autowired
    private TopicRepository topicRepository;
    @Override
    public List<Topic> getAllTopics(String title) {
        List<Topic> topics = new ArrayList<>();
        if (title == null) {
            topicRepository.findAll().forEach(topics::add);
        } else {
            topicRepository.findByTitleContaining(title).forEach(topics::add);
        }
        if (topics.isEmpty()) {
            throw new TopicNotFoundException("No topics found");
        }
        return topics;
    }
    @Override
    public Topic getTopicById(long id) {
        Optional<Topic> topicData = topicRepository.findById(id);
        if (topicData.isPresent()) {
            return topicData.get();
        } else {
            throw new TopicNotFoundException("Topic not found with id: " + id);
        }
    }
    @Override
    public Topic createTopic(Topic topic) {
        Topic t = topicRepository.save(new Topic(topic.getTitle(), topic.getDescription(), false));
        return t;
    }
    @Override
    public Topic updateTopic(long id, Topic topic) {
        Optional<Topic> topicData = topicRepository.findById(id);
        if (topicData.isPresent()) {
            Topic _topic = topicData.get();
            _topic.setTitle(topic.getTitle());
            _topic.setDescription(topic.getDescription());
            _topic.setPublished(topic.isPublished());
            return topicRepository.save(_topic);
        } else {
            throw new TopicNotFoundException("Topic not found with id: " + id);
        }
    }
    @Override
    public void deleteTopic(long id) {
        Optional<Topic> topicData = topicRepository.findById(id);
        if (topicData.isPresent()) {
            topicRepository.deleteById(id);
        } else {
            throw new TopicNotFoundException("Topic not found with id: " + id);
        }
    }
    @Override
    public void deleteAllTopics() {
        topicRepository.deleteAll();
    }
    @Override
    public List<Topic> findPublishedTopics() {
        return topicRepository.findByPublished(true);
    }
}
