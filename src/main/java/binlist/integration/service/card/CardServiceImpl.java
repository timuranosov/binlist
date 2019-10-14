package binlist.integration.service.card;

import binlist.integration.model.Card;
import binlist.integration.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository binRepository;

    @Override
    public Page<Card> getCards() {
        return binRepository.findAll(PageRequest.of(0, 10));
    }

    @Override
    public List<Card> getCardByBinId(long id) {
        return binRepository.findByBinId(id);
    }

    @Override
    public void saveCard(Card card) {
        binRepository.save(card);
    }
}
