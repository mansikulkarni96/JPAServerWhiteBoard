package com.example.wbdvsu19jannunziserverjava.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.wbdvsu19jannunziserverjava.models.Topic;

import java.util.List;

public interface TopicRepository
    extends CrudRepository<Topic, Integer> {

    @Query("select topic from Topic topic")
    public List<Topic> findAllTopics();

    @Query("select topic from Topic topic where topic.lesson.id = :lid")
    public List<Topic> findAllTopicsForLesson(@Param("lid") Integer lessonId);

    @Query("select topic from Topic topic where topic.id = :id")
    public Topic findTopicById(@Param("id") Integer id);
}

