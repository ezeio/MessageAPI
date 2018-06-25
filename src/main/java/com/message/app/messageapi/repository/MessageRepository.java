package com.message.app.messageapi.repository;

import com.message.app.messageapi.model.Message;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {


    @Modifying
    @Query("update Message m set m.title = ?1, m.message = ?2 where m.id = ?3")
    public void setMessageDetailsById(String title, String message, Long messageId);
}
