package binlist.integration.service.bank;

import binlist.integration.model.Bank;
import binlist.integration.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public void saveBank(Bank bank) {
        bankRepository.save(bank);
    }
}
