package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;

import com.bezkoder.spring.jpa.h2.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
  List<Topic> findByPublished(boolean published);

  List<Topic> findByTitleContaining(String title);
}
