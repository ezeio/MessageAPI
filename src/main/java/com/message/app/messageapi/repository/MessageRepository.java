package com.message.app.messageapi.repository;

import com.message.app.messageapi.model.Message;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Message m set m.title = ?1, m.message = ?2 where m.id = ?3")
    int updateMessageDetailsById(String title, String message, Long messageId);
}
