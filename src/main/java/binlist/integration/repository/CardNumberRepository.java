package binlist.integration.repository;

import binlist.integration.model.CardNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardNumberRepository extends JpaRepository<CardNumber, Long> {
}
