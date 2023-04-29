package com.exemple.spring.jpa.h2.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.exemple.spring.jpa.h2.model.Topic;
import com.exemple.spring.jpa.h2.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8082/api/topics")
@RestController
@RequestMapping("/api")
public class TopicController {
/*
	@Autowired
	TopicRepository topicRepository;

	private TopicServiceImp topicServiceImp;

	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> getAllTopics(@RequestParam(required = false) String title) {
		try {
			List<Topic> topics = topicServiceImp.getAllTopics(title);
			if (topics.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(topics, HttpStatus.OK);
		} catch (TopicNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") long id) {
		try {
			Topic topic = topicServiceImp.getTopicById(id);
			return new ResponseEntity<>(topic, HttpStatus.OK);
		} catch (TopicNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/topics")
	public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
		try {
			Topic _topic = topicServiceImp.createTopic(topic);
			return new ResponseEntity<>(_topic, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/topics/{id}")
	public ResponseEntity<Topic> updateTopic(@PathVariable("id") long id, @RequestBody Topic topic) {
		try {
			Topic updatedTopic = topicServiceImp.updateTopic(id, topic);
			return new ResponseEntity<>(updatedTopic, HttpStatus.OK);
		} catch (TopicNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/topics/{id}")
	public ResponseEntity<HttpStatus> deleteTopic(@PathVariable("id") long id) {
		try {
			topicServiceImp.deleteTopic(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (TopicNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/topics")
	public ResponseEntity<HttpStatus> deleteAllTopics() {
		try {
			topicServiceImp.deleteAllTopics();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/topics/published")
	public ResponseEntity<List<Topic>> findByPublished() {
		try {
			List<Topic> topics = topicServiceImp.findPublishedTopics();

			if (topics.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(topics, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
*/
@Autowired
TopicRepository topicRepository;

	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> getAllTopics(@RequestParam(required = false) String title) {
		try {
			List<Topic> topics = new ArrayList<Topic>();

			if (title == null)
				topicRepository.findAll().forEach(topics::add);
			else
				topicRepository.findByTitleContaining(title).forEach(topics::add);

			if (topics.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(topics, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") long id) {
		Optional<Topic> topicData = topicRepository.findById(id);

		if (topicData.isPresent()) {
			return new ResponseEntity<>(topicData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/topics")
	public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
		try {
			Topic _topic = topicRepository
					.save(new Topic(topic.getTitle(), topic.getDescription(), false));
			return new ResponseEntity<>(_topic, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/topics/{id}")
	public ResponseEntity<Topic> updateTopic(@PathVariable("id") long id, @RequestBody Topic topic) {
		Optional<Topic> topicData = topicRepository.findById(id);

		if (topicData.isPresent()) {
			Topic _topic = topicData.get();
			_topic.setTitle(topic.getTitle());
			_topic.setDescription(topic.getDescription());
			_topic.setPublished(topic.isPublished());
			return new ResponseEntity<>(topicRepository.save(_topic), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/topics/{id}")
	public ResponseEntity<HttpStatus> deleteTopic(@PathVariable("id") long id) {
		try {
			topicRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/topics")
	public ResponseEntity<HttpStatus> deleteAllTopics() {
		try {
			topicRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/topics/published")
	public ResponseEntity<List<Topic>> findByPublished() {
		try {
			List<Topic> topics = topicRepository.findByPublished(true);

			if (topics.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(topics, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
