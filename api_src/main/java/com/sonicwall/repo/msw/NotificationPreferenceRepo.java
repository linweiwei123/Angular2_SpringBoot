package com.sonicwall.repo.msw;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sonicwall.model.msw.notification.NotificationPreferenceModel;
import java.util.Optional;
import java.util.List;

public interface NotificationPreferenceRepo extends JpaRepository<NotificationPreferenceModel, Long> {
    
    List<NotificationPreferenceModel> findByUsername(String username);

    Optional<NotificationPreferenceModel> findOneByUsername(String username);
}